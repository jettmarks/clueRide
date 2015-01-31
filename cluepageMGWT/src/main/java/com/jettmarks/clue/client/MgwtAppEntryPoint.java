/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.jettmarks.clue.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.animation.AnimationHelper;
import com.googlecode.mgwt.ui.client.dialog.TabletPortraitOverlay;
import com.googlecode.mgwt.ui.client.layout.MasterRegionHandler;
import com.googlecode.mgwt.ui.client.layout.OrientationRegionHandler;
import com.jettmarks.clue.client.css.AppBundle;
import com.jettmarks.clue.client.nav.IntroPanel;
import com.jettmarks.clue.client.util.Globals;

/**
 * @author Daniel Kurka
 * 
 */
public class MgwtAppEntryPoint implements EntryPoint {

	private void start() {

		// set viewport and other settings for mobile
		MGWT.applySettings(MGWTSettings.getAppSetting());

//		RootPanel.get().add(new IntroPanel());
		helloWorldEntryPoint();
		
		// originalEntryPoint();
	}

	/**
	 * 
	 */
	private void helloWorldEntryPoint() {
		// build animation helper and attach it
		final AnimationHelper animationHelper = new AnimationHelper();
		Globals.setAnimationHelper(animationHelper);
		RootPanel.get().add(animationHelper);

//		ClientFactory clientFactory = new ClientFactoryImpl();
//		TabBarView tabBarView = clientFactory.getTabBarView();
		
		final List<IntroPanel> introPanels = new ArrayList<IntroPanel>();
		for (int i=0; i<6; i++) {
			IntroPanel introPanel = new IntroPanel(i);
			introPanels.add(introPanel);
		}

		// this will create a link element at the end of head
		MGWTStyle.getTheme().getMGWTClientBundle().getMainCss()
				.ensureInjected();
		
		MGWTStyle.injectStyleSheet("workaround.css");
		
		// Client Bundle way of adding CSS
		StyleInjector.inject(AppBundle.INSTANCE.cssClueRide().getText());

		// animate
//		animationHelper.goTo(tabBarView, Animation.SLIDE);
		animationHelper.goTo(introPanels.get(5), Animation.DISSOLVE);
		
//		new Timer() {
//			int index = 0;
//			@Override
//			public void run() {
//				animationHelper.goTo(introPanels.get(index++), 
//						Animation.DISSOLVE);
//				if (index == 6) {
//					this.cancel();
//				}
//			}
//		}.scheduleRepeating(1500);
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private void originalEntryPoint() {
		final ClientFactory clientFactory = new ClientFactoryImpl();

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT
				.create(AppPlaceHistoryMapper.class);
		final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);

		historyHandler.register(clientFactory.getPlaceController(),
				clientFactory.getEventBus(),
				new com.jettmarks.clue.client.activities.HomePlace());

		if ((MGWT.getOsDetection().isTablet())) {
			// very nasty workaround because GWT does not corretly support
			// @media
			StyleInjector.inject(AppBundle.INSTANCE.css().getText());

			createTabletDisplay(clientFactory);
		} else {
			createPhoneDisplay(clientFactory);

		}
		historyHandler.handleCurrentHistory();
	}

	private void createPhoneDisplay(ClientFactory clientFactory) {
		AnimatableDisplay display = GWT.create(AnimatableDisplay.class);

		PhoneActivityMapper appActivityMapper = new PhoneActivityMapper(
				clientFactory);

		PhoneAnimationMapper appAnimationMapper = new PhoneAnimationMapper();

		AnimatingActivityManager activityManager = new AnimatingActivityManager(
				appActivityMapper, appAnimationMapper,
				clientFactory.getEventBus());

		activityManager.setDisplay(display);

		RootPanel.get().add(display);

	}

	private void createTabletDisplay(ClientFactory clientFactory) {
		SimplePanel navContainer = new SimplePanel();
		navContainer.getElement().setId("nav");
		navContainer.getElement().addClassName("landscapeonly");
		AnimatableDisplay navDisplay = GWT.create(AnimatableDisplay.class);

		final TabletPortraitOverlay tabletPortraitOverlay = new TabletPortraitOverlay();

		new OrientationRegionHandler(navContainer, tabletPortraitOverlay,
				navDisplay);
		new MasterRegionHandler(clientFactory.getEventBus(), "nav",
				tabletPortraitOverlay);

		ActivityMapper navActivityMapper = new TabletNavActivityMapper(
				clientFactory);

		AnimationMapper navAnimationMapper = new TabletNavAnimationMapper();

		AnimatingActivityManager navActivityManager = new AnimatingActivityManager(
				navActivityMapper, navAnimationMapper,
				clientFactory.getEventBus());

		navActivityManager.setDisplay(navDisplay);

		RootPanel.get().add(navContainer);

		SimplePanel mainContainer = new SimplePanel();
		mainContainer.getElement().setId("main");
		AnimatableDisplay mainDisplay = GWT.create(AnimatableDisplay.class);

		TabletMainActivityMapper tabletMainActivityMapper = new TabletMainActivityMapper(
				clientFactory);

		AnimationMapper tabletMainAnimationMapper = new TabletMainAnimationMapper();

		AnimatingActivityManager mainActivityManager = new AnimatingActivityManager(
				tabletMainActivityMapper, tabletMainAnimationMapper,
				clientFactory.getEventBus());

		mainActivityManager.setDisplay(mainDisplay);
		mainContainer.setWidget(mainDisplay);

		RootPanel.get().add(mainContainer);

	}

	@Override
	public void onModuleLoad() {

		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				// TODO put in your own meaningful handler
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

}
