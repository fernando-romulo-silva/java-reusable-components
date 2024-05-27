package org.reusablecomponent.core.infra.security;

/**
 * 
 */
public interface InterfaceSecurityService {

    /**
     * @return
     */
    String getUserName();
    
    /**
     * @return
     */
    String getUserRealm();
    
    /**
     * @return
     */
    String getSession();
    
    /**
     * @return
     */
    String getApplication();
}