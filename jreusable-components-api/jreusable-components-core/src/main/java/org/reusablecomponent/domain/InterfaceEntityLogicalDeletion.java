package org.reusablecomponent.domain;

public interface InterfaceEntityLogicalDeletion<Id, Entity extends InterfaceEntityLogicalDeletion<Id, Entity>>  {

    default boolean isLogicalDeletion() {
	return true;
    }
    
    boolean isDeleted();
    
    void delete();
}
