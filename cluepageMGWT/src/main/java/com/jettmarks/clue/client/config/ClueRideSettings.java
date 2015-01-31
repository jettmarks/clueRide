/**
 * 
 */
package com.jettmarks.clue.client.config;

/**
 * Place to congregate the settings for browser-side settings for the app.
 * 
 * @author jett
 */
public class ClueRideSettings {
	private static boolean leaderMode = false;

	public static boolean isLeaderMode() {
		return leaderMode;
	}

	public static void setLeaderMode(boolean lm) {
		leaderMode = lm;
	}

}
