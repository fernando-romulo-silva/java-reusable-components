package org.reusablecomponent.core.application.full.entity.paged;

import org.reusablecomponent.core.application.command.entity.InterfaceEntityCommandFacade;
import org.reusablecomponent.core.application.query.entity.paged.InterfaceEntityQueryPaginationFacade;
import org.reusablecomponent.core.domain.AbstractEntity;

public interface InterfaceEntityPaginationFacade<Entity extends AbstractEntity<Id>, Id, // basic
		// ------------ command
		// save
		SaveEntityIn, SaveEntityOut, // save a entity
		SaveEntitiesIn, SaveEntitiesOut, // save entities
		// update
		UpdateEntityIn, UpdateEntityOut, // update a entity
		UpdateEntitiesIn, UpdateEntitiesOut, // update entities
		// delete entity
		DeleteEntityIn, DeleteEntityOut, // delete a entity
		DeleteEntitiesIn, DeleteEntitiesOut, // delete entities
		// delete by id
		DeleteIdIn, DeleteIdOut, // delete a entity by id
		DeleteIdsIn, DeleteIdsOut, // delete entities by id
		// ------------ query
		// results
		OneResult, // one result type
		MultiplePagedResult, // multiple result type
		// Pagination
		Pageable, // pageable type
		Sort> // sort type
	extends InterfaceEntityCommandFacade<Entity, Id, SaveEntityIn, SaveEntityOut, SaveEntitiesIn, SaveEntitiesOut, UpdateEntityIn, UpdateEntityOut, UpdateEntitiesIn, UpdateEntitiesOut, DeleteEntityIn, DeleteEntityOut, DeleteEntitiesIn, DeleteEntitiesOut, DeleteIdIn, DeleteIdOut, DeleteIdsIn, DeleteIdsOut>,
		InterfaceEntityQueryPaginationFacade<Entity, Id, OneResult, MultiplePagedResult, Pageable, Sort> {

}
