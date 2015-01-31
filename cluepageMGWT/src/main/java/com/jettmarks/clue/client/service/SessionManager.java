/**
 * 
 */
package com.jettmarks.clue.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Interacts with the user to setup the game and optional group for playing 
 * this instance of the game.
 * 
 * @author jett
 */
@RemoteServiceRelativePath("manageSession")
public interface SessionManager extends RemoteService {
	public String[] getGameList();
	public int joinGroup(String groupName);
	public int selectGame(String gameName);
}
