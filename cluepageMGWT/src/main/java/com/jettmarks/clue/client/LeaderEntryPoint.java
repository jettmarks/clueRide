/**
 * 
 */
package com.jettmarks.clue.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.animation.AnimationHelper;
import com.jettmarks.clue.client.config.ClueRideSettings;
import com.jettmarks.clue.client.css.AppBundle;

/**
 * @author jett
 * @deprecated
 */
public class LeaderEntryPoint implements EntryPoint {

	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	@Override
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				// TODO put in your own meaninful handler
				Window.alert("uncaught: " + e.getMessage());
				e.printStackTrace();

			}
		});

		new Timer() {
			@Override
			public void run() {
				start();

			}
		}.schedule(1);
	}

	/**
	 * 
	 */
	private void start() {

		// set viewport and other settings for mobile
		MGWT.applySettings(MGWTSettings.getAppSetting());

		leaderEntryPoint();
	}

	/**
	 * 
	 */
	private void leaderEntryPoint() {
		// build animation helper and attach it
		AnimationHelper animationHelper = new AnimationHelper();
		RootPanel.get().add(animationHelper);
		
		// this will create a link element at the end of head
		MGWTStyle.getTheme().getMGWTClientBundle().getMainCss()
				.ensureInjected();
		// Client Bundle way of adding CSS
		StyleInjector.inject(AppBundle.INSTANCE.cssClueRide().getText());
		
		ClueRideSettings.setLeaderMode(true);
//		ClientFactory clientFactory = new ClientFactoryImpl();
//		TabBarView tabBarView = clientFactory.getTabBarView();
//	
//		// animate
//		animationHelper.goTo(tabBarView, Animation.SLIDE);
		
	}
}
