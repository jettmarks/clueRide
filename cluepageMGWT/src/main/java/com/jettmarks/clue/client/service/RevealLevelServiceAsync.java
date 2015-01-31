package com.jettmarks.clue.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RevealLevelServiceAsync
{

    void getCurrentPage(int groupId, AsyncCallback<Integer> callback);


    void bumpCurrentPage(int groupId, AsyncCallback<Integer> callback);


    void setCurrentPage(int groupId, int newCurrentPage,
			AsyncCallback<Void> callback);


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static RevealLevelServiceAsync instance;

        public static final RevealLevelServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (RevealLevelServiceAsync) GWT.create( RevealLevelService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
