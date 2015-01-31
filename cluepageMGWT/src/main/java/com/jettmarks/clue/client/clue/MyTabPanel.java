/**
 * 
 */
package com.jettmarks.clue.client.clue;

import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.ui.client.theme.base.TabBarCss;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;
import com.jettmarks.clue.client.activities.tabbar.HomeTabBarButton;
import com.jettmarks.clue.client.activities.tabbar.ImageTabBarButton;
import com.jettmarks.clue.client.activities.tabbar.RouteTabBarButton;
import com.jettmarks.clue.client.activities.tabbar.TextClueTabBarButton;
import com.jettmarks.clue.client.config.Constants;
import com.jettmarks.clue.client.css.AppBundle;
import com.jettmarks.clue.client.util.ImageLoader;
import com.jettmarks.clue.client.util.ScreenSize;

/**
 * @author jett
 *
 */
public class MyTabPanel extends TabPanel {

	/** Name of this particular Course. */
	protected static final String courseName = "free5";
	protected final MyTabPanel thisTabPanel;

	/**
	 * 
	 */
	public MyTabPanel() {
		super();
		thisTabPanel = this;
	}

	/**
	 * @param css
	 */
	public MyTabPanel(TabBarCss css) {
		super(css);
		thisTabPanel = this;
	}

	/**
	 * @return
	 */
	protected static Label getTextClue() {
		Label label = new Label();
		label.setText("Width: "+ScreenSize.getWidth()
				     +" Height: "+ScreenSize.getHeight());
		return label;
	}

	/**
	 * Creates the four tabs for a given node.
	 * 
	 * Three are particular to the node, and the help page is common to all.
	 * 
	 * @param clueImageString
	 * @param textFileNameString
	 * @param routeImageString
	 */
	protected void createTabPanel(String clueImageString, String textFileNameString, String routeImageString) {
		this.add(new ImageTabBarButton(), 
				new TabContent(ImageLoader.getImage(courseName, clueImageString)));
		String documentSource = Constants.IMG_SERVER_URL+"/"+courseName
				+"/"+textFileNameString;
		boolean isCentered = false;
		TabContent textPane = new TabContent(new TextCluePanel(documentSource), 
				isCentered);
		textPane.addStyleName(AppBundle.INSTANCE.cssClueRide().textFrame());
		this.add(new TextClueTabBarButton(), textPane);
		this.add(new RouteTabBarButton(), 
				new TabContent(ImageLoader.getImage(courseName, routeImageString)));
		String helpDocSource = Constants.IMG_SERVER_URL+"/../shared/help.html";
		TabContent helpPane = new TabContent(new TextCluePanel(helpDocSource),
				isCentered);
		helpPane.addStyleName(AppBundle.INSTANCE.cssClueRide().textFrame());
		this.add(new HomeTabBarButton(), helpPane);
	}

}