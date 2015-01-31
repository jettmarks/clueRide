/**
 * 
 */
package com.jettmarks.clue.client.nav;

import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.ui.client.animation.AnimationHelper;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.touch.TouchPanel;
import com.jettmarks.clue.client.config.ClueRideSettings;
import com.jettmarks.clue.client.css.AppBundle;
import com.jettmarks.clue.client.util.Globals;
import com.jettmarks.clue.client.util.ImageLoader;

/**
 * Landing spot for the application.
 * 
 * @author jett
 */
public class IntroPanel extends LayoutPanel {

	public IntroPanel() {
		boolean hasGroupId = State.lookForId();
		TouchPanel touchPanel = new TouchPanel();
		touchPanel.setHeight("100%");
		touchPanel.addTapHandler(new TapHandler(){
			@Override
			public void onTap(TapEvent event) {
				// Pull from HTML page and tell rest of the GWT JavaScript
				ClueRideSettings.setLeaderMode(getLeaderMode());
				showHomePage();
			}

			public native boolean getLeaderMode() /*-{
		        return $wnd.leaderMode;
			}-*/;
		}); 
		
		touchPanel.add(ImageLoader.getImage("logo_2.png"));
		this.addStyleName(AppBundle.INSTANCE.cssClueRide().introPanel());
		this.add(touchPanel);
	}
	
	/**
	 * @param i
	 */
	public IntroPanel(int i) {
		TouchPanel touchPanel = new TouchPanel();
		touchPanel.setHeight("100%");
		touchPanel.addTapHandler(new TapHandler(){
			@Override
			public void onTap(TapEvent event) {
				// Pull from HTML page and tell rest of the GWT JavaScript
				ClueRideSettings.setLeaderMode(getLeaderMode());
				showHomePage();
			}

			public native boolean getLeaderMode() /*-{
		        return $wnd.leaderMode;
			}-*/;
		}); 
		touchPanel.add(ImageLoader.getImage("logo_"+i+".png"));
		this.addStyleName(AppBundle.INSTANCE.cssClueRide().introPanel());
		this.add(touchPanel);
	}

	/**
	 * Prepares the panels for showing the Home Page. 
	 */
	private void showHomePage() {
		// build animation helper and attach it
		AnimationHelper animationHelper =  Globals.getAnimationHelper();

		HomePanel homePanel = new HomePanel();
		
		// animate
		animationHelper.goTo(homePanel, Animation.DISSOLVE);
	}
}
