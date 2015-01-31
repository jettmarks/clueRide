/**
 * 
 */
package com.jettmarks.clue.client.clue;

import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;
import com.jettmarks.clue.client.activities.tabbar.ImageTabBarButton;
import com.jettmarks.clue.client.activities.tabbar.RouteTabBarButton;
import com.jettmarks.clue.client.activities.tabbar.TextClueTabBarButton;
import com.jettmarks.clue.client.util.ImageLoader;

/**
 * @author jett
 *
 */
public class CluePanel extends MyTabPanel {
	
	/**
	 * @param string
	 * @param string2
	 */
	public CluePanel(String clueImageString, String routeImageString) {
		super();
		createTabPanel(clueImageString, "1.html", routeImageString);
	}
	
	/**
	 * @param nextClue
	 */
	public CluePanel(Clue nextClue) {
		super();
		createTabPanel(nextClue.getClueImageName(), nextClue.getTextClueName(), 
				nextClue.getRouteImageName());
	}


	public static TabPanel buildCluePanel(String clueImageString, String routeImageString) {
		TabPanel tabPanel = new TabPanel();
		tabPanel.add(new ImageTabBarButton(),
				ImageLoader.getImage(courseName, clueImageString));
		tabPanel.add(new TextClueTabBarButton(), getTextClue());
		tabPanel.add(new RouteTabBarButton(), 
				ImageLoader.getImage(courseName, routeImageString));
		return tabPanel;
	}
}
