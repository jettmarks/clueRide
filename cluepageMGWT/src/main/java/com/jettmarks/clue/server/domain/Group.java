/**
 * 
 */
package com.jettmarks.clue.server.domain;

/**
 * Represents a group of individuals participating in a game simultaneously
 * sharing the same reveal level for a shared game.
 * 
 * @author jett
 */
public class Group {

	private String groupName;
	private int id;
	private boolean active;
	
	// May be factored into a separate class
	private int revealLevel = 0;
	
	public int getRevealLevel() {
		return revealLevel;
	}

	public void setRevealLevel(int revealLevel) {
		this.revealLevel = revealLevel;
	}

	/**
	 * 
	 * @param groupName
	 */
	public Group(String groupName) {
		this.groupName = groupName;
		active = true;
	}
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * 
	 */
	public void bumpCurrentPage() {
		revealLevel++;
	}
	
}
