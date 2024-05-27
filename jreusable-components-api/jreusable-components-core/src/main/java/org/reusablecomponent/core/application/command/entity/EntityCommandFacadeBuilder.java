package org.reusablecomponent.core.application.command.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.function.Consumer;
import java.util.function.Function;

import org.reusablecomponent.core.domain.AbstractEntity;
import org.reusablecomponent.core.infra.exception.ExceptionTranslatorService;
import org.reusablecomponent.core.infra.i18n.InterfaceI18nService;
import org.reusablecomponent.core.infra.security.InterfaceSecurityService;
import org.reusablecomponent.messaging.InterfacePublisherSerice;

public final class EntityCommandFacadeBuilder < // Generics spec
            Entity extends AbstractEntity<Id>, Id, // basic
            // save
            SaveEntityIn, SaveEntityOut, // save a entity
            SaveEntitiesIn, SaveEntitiesOut, // save entities
            // update
            UpdateEntityIn, UpdateEntityOut, // update a entity
            UpdateEntitiesIn, UpdateEntitiesOut, // update entities
            // delete
            DeleteEntityIn, DeleteEntityOut, // delete a entity
            DeleteEntitiesIn, DeleteEntitiesOut, // delete entities
            // delete by id
            DeleteIdIn, DeleteIdOut, // delete entity by id
            DeleteIdsIn, DeleteIdsOut > {// delete entities by ids
    
    public InterfacePublisherSerice publisherSerice;

    public InterfaceSecurityService securityService;

    public InterfaceI18nService i18nService;
    
    public ExceptionTranslatorService exceptionTranslatorService;
    
    public Function<SaveEntityIn, SaveEntityOut> saveFunction;
    public Function<SaveEntitiesIn, SaveEntitiesOut> saveAllFunction;
    
    public Function<UpdateEntityIn, UpdateEntityOut> updateFunction;
    public Function<UpdateEntitiesIn, UpdateEntitiesOut> updateAllFunction;    
    
    public Function<DeleteEntityIn, DeleteEntityOut> deleteFunction;
    public Function<DeleteEntitiesIn, DeleteEntitiesOut> deleteAllFunction;
    
    public Function<DeleteIdIn, DeleteIdOut> deleteByIdFunction;
    public Function<DeleteIdsIn, DeleteIdsOut> deleteAllByIdFunction;

    public EntityCommandFacadeBuilder(
		    final Consumer<EntityCommandFacadeBuilder<
		    		     Entity, Id, //
		    		     //
		    		     SaveEntityIn, SaveEntityOut, 
		    		     SaveEntitiesIn, SaveEntitiesOut,
		    		     //
		    		     UpdateEntityIn, UpdateEntityOut, 
		    		     UpdateEntitiesIn, UpdateEntitiesOut,
		    		     //
		    		     DeleteEntityIn, DeleteEntityOut, 
		    		     DeleteEntitiesIn, DeleteEntitiesOut, 
		    		     DeleteIdIn, DeleteIdOut, 
		    		     DeleteIdsIn,DeleteIdsOut>> function) {
	super();
	
	// load the functions
	function.accept(this);

	checkNotNull(publisherSerice, "Please pass a non-null 'publisherService'");
	checkNotNull(securityService, "Please pass a non-null 'securityService'");
	checkNotNull(i18nService, "Please pass a non-null 'i18nService'");
	checkNotNull(exceptionTranslatorService, "Please pass a non-null 'exceptionTranslatorService'");
	
	checkNotNull(saveFunction, "Please pass a non-null 'saveFunction'");
	checkNotNull(saveAllFunction, "Please pass a non-null 'saveAllFunction'");
	
	checkNotNull(updateFunction, "Please pass a non-null 'updateFunction'");
	checkNotNull(updateAllFunction, "Please pass a non-null 'updateAllFunction'");
	
	checkNotNull(deleteFunction, "Please pass a non-null 'deleteFunction'");
	checkNotNull(deleteAllFunction, "Please pass a non-null 'deleteAllFunction'");
	checkNotNull(deleteByIdFunction, "Please pass a non-null 'deleteByIdFunction'");
	checkNotNull(deleteAllByIdFunction, "Please pass a non-null 'deleteAllByIdFunction'");
    }
}
