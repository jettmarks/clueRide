/**
 * 
 */
package com.jettmarks.clue.client.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds list of Games for presenting to the user.
 * 
 * @author jett
 */
public class GameList {

	private static List<String> gameList = new ArrayList<String>();
	
	static {
		gameList.add("free5");
		gameList.add("sample");
	}
	
	public static List<String> getGameList() {
		return gameList;
	}

	
	public GameList() {
		// Eventually the static list will be picked up via a service call 
		// to the server
	}
}
