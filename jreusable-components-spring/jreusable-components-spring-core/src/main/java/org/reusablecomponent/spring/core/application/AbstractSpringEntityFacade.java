package org.reusablecomponent.spring.core.application;

import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections4.IterableUtils;
import org.reusablecomponent.core.application.command.entity.InterfaceEntityCommandFacade;
import org.reusablecomponent.core.application.full.entity.nonpaged.EntityFacade;
import org.reusablecomponent.core.application.query.entity.nonpaged.InterfaceEntityQueryFacade;
import org.reusablecomponent.core.domain.AbstractEntity;
import org.reusablecomponent.spring.core.domain.InterfaceSpringRepository;
import org.reusablecomponent.spring.core.infra.i18n.SpringI18nService;
import org.reusablecomponent.spring.core.infra.logging.Loggable;
import org.springframework.transaction.annotation.Transactional;

/**
 * @param <Entity>
 * @param <Id>
 */
@Loggable
@Transactional
public abstract class AbstractSpringEntityFacade<Entity extends AbstractEntity<Id>, Id> 
	extends EntityFacade<Entity, Id, Entity, Optional<Entity>, Iterable<Entity>, Long, Boolean, Void> {
    
    protected InterfaceSpringRepository<Entity, Id> interfaceSpringRepository;
    
    /**
     * @param entityCommandFacade
     * @param entityQueryFacade
     */
    protected AbstractSpringEntityFacade(
		    final InterfaceEntityCommandFacade<Entity, Id, Entity, Iterable<Entity>, Void> entityCommandFacade, 
		    final InterfaceEntityQueryFacade<Entity, Id, Optional<Entity>, Iterable<Entity>, Long, Boolean> entityQueryFacade, 
		    final SpringI18nService i18n) {
	
	super(entityCommandFacade, entityQueryFacade);
    }

    /**
     * @param repository
     * @param i18n
     */
    public AbstractSpringEntityFacade( //
		    final InterfaceSpringRepository<Entity, Id> repository, // 
		    final SpringI18nService i18n) { 
	
 	super( // functions
 		repository::save, // saveFunction
 		repository::saveAll, // saveAllFunction
 		//
 		entity -> { repository.delete(entity); return null;}, // deleteFunction
 		entities -> { repository.deleteAll(entities); return null; }, // deleteAllFunction
 		id -> { repository.deleteById(id); return null; }, // deleteByIdFunciton
 		ids -> { repository.deleteAllById(ids); return null; }, // deleteAllByIdFunction
 		//
 		repository::existsById, // existsByIdFunction
 		booleanResult -> booleanResult, // existsEntityFunction
 		//
 		repository::findById, // findByIdFunction
 		repository::findAll, // findAllFunction
 		repository::count // countAllFunction
 	);
 	
 	this.interfaceSpringRepository = repository;
     }    
    
    // ---------------------------------------------------------------------------
    
    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Entity> findBy(final Id id) {
        return super.findBy(id);
    }
    
    /**
     * {@inheritDoc}
     */    
    @Override
    @Transactional(readOnly = true)
    public Iterable<Entity> findAll(final Map<String, String[]> directives) {
        return super.findAll(directives);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Boolean existsBy(final Id id) {
	return entityQueryFacade.existsBy(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Long count() {
	return entityQueryFacade.count();
    }
    
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    @Transactional(readOnly = false)
//    public Entity save(final Entity entity) {
//	return super.save(entity);
//    }
//    
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    @Transactional(readOnly = false)
//    public Iterable<Entity> saveAll(final Iterable<Entity> entities) {
//	return super.saveAll(entities);
//    }
//    
//    // ---------------------------------------------------------------------------
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    @Transactional(readOnly = false)
//    public Entity update(final Entity entity) {
//	return super.update(entity);
//    }
//    
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    @Transactional(readOnly = false)
//    public Entity update(final Id id, final Entity entity) {
//	return super.update(id, entity);
//    }    
//    
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    @Transactional(readOnly = false)
//    public Iterable<Entity> updateAll(final Iterable<Entity> entities) {
//	return super.updateAll(entities);
//    }
//
//    // ---------------------------------------------------------------------------
//    
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    @Transactional(readOnly = false)
//    public Void delete(final Entity entity) {
//	return super.delete(entity);
//    }
//    
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    @Transactional(readOnly = false)
//    public Void deleteAll(final Iterable<Entity> entities) {
//	return super.deleteAll(entities);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    @Transactional(readOnly = false)
//    public Void deleteBy(Id id) {
//	return super.deleteBy(id);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    @Transactional(readOnly = false)
//    public Void deleteAllBy(final Iterable<Id> ids) {
//	return super.deleteAllBy(ids);
//    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getMultipleResultEventData(final Iterable<Entity> multipleResult) {
	return "Result size "+IterableUtils.size(multipleResult);
    }
}
