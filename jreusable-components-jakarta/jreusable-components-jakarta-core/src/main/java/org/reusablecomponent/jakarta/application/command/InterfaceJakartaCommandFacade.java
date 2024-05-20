package org.reusablecomponent.jakarta.application.command;

import static jakarta.transaction.Transactional.TxType.REQUIRED;

import java.util.List;

import org.reusablecomponent.core.application.command.entity.InterfaceEntityCommandFacade;
import org.reusablecomponent.core.domain.AbstractEntity;

import jakarta.transaction.Transactional;

public interface InterfaceJakartaCommandFacade<Entity extends AbstractEntity<Id>, Id>
		//
		extends InterfaceEntityCommandFacade<Entity, Id,
				// save
				Entity, Entity, // save a entity
				List<Entity>, List<Entity>, // save entities
				// update
				Entity, Entity, // update a entity
				List<Entity>, List<Entity>, // update entities
				// delete entity
				Entity, Void, // delete a entity
				List<Entity>, Void, // delete entities
				// delete by id
				Id, Void, // delete a entity by id
				List<Id>, Void> { // delete entities by id		

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(value = REQUIRED)
    Entity save(final Entity entity);

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(value = REQUIRED)
    List<Entity> saveAll(final List<Entity> entities);
    
    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(value = REQUIRED)
    Entity update(final Entity entity);

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(value = REQUIRED)
    List<Entity> updateAll(final List<Entity> entities);

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(value = REQUIRED)
    Void delete(final Entity entity);

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(value = REQUIRED)
    Void deleteAll(final List<Entity> entities);

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(value = REQUIRED)
    Void deleteBy(final Id id);

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(value = REQUIRED)
    Void deleteAllBy(final List<Id> ids);

}
