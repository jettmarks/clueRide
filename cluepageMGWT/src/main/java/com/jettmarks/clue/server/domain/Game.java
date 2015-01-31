/**
 * 
 */
package com.jettmarks.clue.server.domain;

/**
 * @author jett
 *
 */
public class Game {
	private String gameName;

	public Game(String gameName) {
		this.setGameName(gameName);
	}
	
	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
}
