package com.jettmarks.clue.client.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

public interface AppBundle extends ClientBundle {
	//This is a very nasty workaround because GWT CssResource does not support @media correctly!
	@Source("app.css")
	TextResource css();

	public static final AppBundle INSTANCE = GWT.create(AppBundle.class);

	@Source("image.png")
	ImageResource tabBarImageImage();

	@Source("route.png")
	ImageResource tabBarRouteImage();

	@Source("textClue.png")
	ImageResource tabBarTextClueImage();
	
	@Source("home.png")
	ImageResource tabBarHomeImage();
	
	@Source("help.png")
	ImageResource tabBarHelpImage();
	
	@Source("clueRide.css")
	ClueRideStyle cssClueRide();
}
