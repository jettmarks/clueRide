/**
 * 
 */
package com.jettmarks.clue.client.clue;

/**
 * Domain object for the clues to get to the next point on a route.
 * 
 * @author jett
 */
public class Clue {
	private String clueImageName = null;
	private String routeImageName = null;
	private String textClueName = null;
	
	public Clue(String clueImageName, String routeImageName, 
			String textClueName) {
		this.clueImageName = clueImageName;
		this.routeImageName = routeImageName;
		this.textClueName = textClueName;
	}

	public String getClueImageName() {
		return clueImageName;
	}

	public void setClueImageName(String clueImageName) {
		this.clueImageName = clueImageName;
	}

	public String getRouteImageName() {
		return routeImageName;
	}

	public void setRouteImageName(String routeImageName) {
		this.routeImageName = routeImageName;
	}

	public String getTextClueName() {
		return textClueName;
	}

	public void setTextClueName(String textClueName) {
		this.textClueName = textClueName;
	}
	
}
