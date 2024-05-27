package org.reusablecomponent.jakarta.application.full.entity.nonpaged;

import static jakarta.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.reusablecomponent.core.application.full.entity.nonpaged.InterfaceEntityFacade;
import org.reusablecomponent.core.domain.AbstractEntity;

import jakarta.transaction.Transactional;

/**
 * @param <Entity>
 * @param <Id>
 */
@Transactional(value = SUPPORTS)
public interface InterfaceJakartaEntityFacade<Entity extends AbstractEntity<Id>, Id>
	//
	extends InterfaceEntityFacade<Entity, Id,			
	// ------------ command
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
	List<Id>, Void, // delete entities by id
	// ------------ query
	Id, // by id arg
	Optional<Entity>, // One result
	Stream<Entity>, // multiple result
	Long, // count result
	Boolean> { // exists result

}
