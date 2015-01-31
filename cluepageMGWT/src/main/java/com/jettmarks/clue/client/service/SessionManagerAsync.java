package com.jettmarks.clue.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface SessionManagerAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.jettmarks.clue.client.service.SessionManager
     */
    void getGameList( AsyncCallback<java.lang.String[]> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.jettmarks.clue.client.service.SessionManager
     */
    void selectGame( java.lang.String p0, AsyncCallback<java.lang.Integer> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.jettmarks.clue.client.service.SessionManager
     */
    void joinGroup( java.lang.String p0, AsyncCallback<java.lang.Integer> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static SessionManagerAsync instance;

        public static final SessionManagerAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (SessionManagerAsync) GWT.create( SessionManager.class );
                ServiceDefTarget target = (ServiceDefTarget) instance;
                target.setServiceEntryPoint( GWT.getModuleBaseURL() + "SessionManager" );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
