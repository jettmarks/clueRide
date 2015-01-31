/**
 * 
 */
package com.jettmarks.clue.server.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jettmarks.clue.client.service.SessionManager;
import com.jettmarks.clue.server.domain.Game;
import com.jettmarks.clue.server.domain.Group;

/**
 * @author jett
 *
 */
public class SessionManagerImpl extends RemoteServiceServlet implements
		SessionManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1183490342619769433L;
	
	private static List<Game> gameList = new ArrayList<Game>();
	private static Map<String, Group> groupByNameMap = new HashMap<String, Group>();
	private static Map<Integer, Group> groupByIdMap = new HashMap<Integer, Group>();
	private static int lastSessionId = 0;
	
	static {
		gameList.add(new Game("free5"));
	}
	
	/**
	 * @see com.jettmarks.clue.client.service.SessionManager#getGameList()
	 */
	@Override
	public String[] getGameList() {
		List<String> nameList = new ArrayList<String>();
		for (Game game : gameList) {
			nameList.add(game.getGameName());
		}
		return nameList.toArray(new String[nameList.size()]);
	}

	/**
	 * @see com.jettmarks.clue.client.service.SessionManager#joinGroup(java.lang.String)
	 */
	@Override
	public int joinGroup(String groupName) {
		Group group = null;
		
		if (groupName != null) {
			// Trying to find existing group
			if (groupByNameMap.containsKey(groupName)) {
				// Found existing Group; join it
				group = groupByNameMap.get(groupName);
			} else {
				// Need to create new Group and list under it's name
				group = new Group(groupName);
				group.setId(++lastSessionId);
				groupByNameMap.put(groupName, group);
				groupByIdMap.put(group.getId(), group);
			}
		} else {
			group = new Group("individual");
			group.setId(++lastSessionId);
			groupByIdMap.put(group.getId(), group);
		}
		return group.getId();
	}

	/**
	 * @see com.jettmarks.clue.client.service.SessionManager#selectGame(java.lang.String)
	 */
	@Override
	public int selectGame(String gameName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Group getGroup(Integer groupId) {
		return groupByIdMap.get(groupId);
	}
}
