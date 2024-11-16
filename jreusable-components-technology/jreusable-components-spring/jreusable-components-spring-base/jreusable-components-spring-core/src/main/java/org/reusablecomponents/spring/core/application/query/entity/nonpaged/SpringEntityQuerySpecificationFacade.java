package org.reusablecomponents.spring.core.application.query.entity.nonpaged;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.reusablecomponents.base.core.application.query.entity.nonpaged.EntityQuerySpecificationFacade;
import org.reusablecomponents.base.core.application.query.entity.nonpaged.EntityQuerySpecificationFacadeBuilder;
import org.reusablecomponents.base.core.domain.AbstractEntity;
import org.reusablecomponents.base.core.infra.exception.InterfaceExceptionAdapterService;
import org.reusablecomponents.base.security.InterfaceSecurityService;
import org.reusablecomponents.base.translation.InterfaceI18nService;
import org.reusablecomponents.spring.core.domain.InterfaceSpringSpecificationRepository;

import org.springframework.stereotype.Service;

@Service
public class SpringEntityQuerySpecificationFacade<Entity extends AbstractEntity<Id>, Id, Specification>
		// base class
		extends EntityQuerySpecificationFacade<Entity, Id, Optional<Entity>, // One result
				Iterable<Entity>, // multiple result
				Long, // count result
				Boolean, Specification>

		implements InterfaceSpringEntityQuerySpecificationFacade<Entity, Id, Specification> {

	protected InterfaceSpringSpecificationRepository<Entity, Id, Specification> repository;

	/**
	 * 
	 * @param builder
	 */
	public SpringEntityQuerySpecificationFacade(
			final InterfaceSpringSpecificationRepository<Entity, Id, Specification> repository,
			final InterfaceSecurityService securityService,
			final InterfaceExceptionAdapterService exceptionAdapterService,
			final InterfaceI18nService i18Service) {

		super(new EntityQuerySpecificationFacadeBuilder<>($ -> {
			$.findBySpecificationFunction = (specification, directives) -> List.<Entity>of();
			$.findOneByFunction = (specification, directives) -> Optional.empty();
			$.existsBySpecificationFunction = specification -> Boolean.FALSE;
			$.countBySpecificationFunction = specification -> 0L;

			// services
			$.i18nService = i18Service;
			$.exceptionAdapterService = exceptionAdapterService;
			$.securityService = securityService;
		}));

		this.repository = repository;
	}

}