/**
 * 
 */
package com.jettmarks.clue.client.nav;

import java.util.Date;

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;

/**
 * Tracks details regarding the State of the user's session.
 * 
 * @author jett
 */
public class State { 
	private static int groupId;
	private static String groupName = null;
	private static String gameName = null;
	
	public static String getGroup() {
		return groupName;
	}
	public static void setGroup(String groupName) {
		State.groupName = groupName;
	}
	public static String getGameName() {
		return gameName;
	}
	public static void setGameName(String gameName) {
		State.gameName = gameName;
	}
	/**
	 * @return
	 */
	public static boolean isReadyToPlay() {
		if (gameName == null) {
			Window.alert("Choose a Game first");
			return false;
		}
		return true;
	}
	/**
	 * @return
	 */
	public static int getId() {
		return groupId;
	}
	/**
	 * 
	 */
	public static boolean lookForId() {
		String groupIdStr = Cookies.getCookie("group_id");
		if (groupIdStr != null) {
			groupId = Integer.parseInt(groupIdStr);
		}
		return (groupId > 0);
	}
	/**
	 * @param result
	 */
	public static void setId(Integer id) {
		groupId = id;
		Date cookieExpiration = new Date();
		long millis = cookieExpiration.getTime()+(12 * 3600 * 1000);
		cookieExpiration.setTime(millis);
		Cookies.setCookie("group_id", ""+id, cookieExpiration);
	}
}
