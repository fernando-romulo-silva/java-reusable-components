package org.reusablecomponent.spring.core.application.query.nonpaged;

import java.util.Optional;

import org.reusablecomponent.core.application.query.entity.nonpaged.EntityQueryFacade;
import org.reusablecomponent.core.domain.AbstractEntity;
import org.reusablecomponent.spring.core.domain.InterfaceSpringRepository;

public class SpringEntityQueryFacade<Entity extends AbstractEntity<Id>, Id>
		// base class
		extends EntityQueryFacade<Entity, Id, // basic
				Id, // by id arg
				Optional<Entity>, // One result
				Iterable<Entity>, // multiple result
				Long, // count result
				Boolean> // boolean result
                // interface
		implements InterfaceSpringEntityQueryFacade<Entity, Id> {
    
    protected final InterfaceSpringRepository<Entity, Id> repository;

    public SpringEntityQueryFacade(final InterfaceSpringRepository<Entity, Id> repository) {
	super( // functions
		repository::existsById, // Function<Id, Boolean> existsByIdFunction, 
		(id, directives) -> repository.findById(id), // BiFunction<Id, Object[], Optional<Entity>> findByIdFunction
		(directives) -> repository.findAll(), // Function<Object[], Iterable<Entity>> findAllFunction 
		repository::count, // Supplier<Long> countAllFunction
		() -> repository.count() > 0 // Supplier<ExistsResult> existsAllFunction
	);
	
	this.repository = repository;
    }
}
