/**
 * 
 */
package com.jettmarks.clue.client.util;

import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.mgwt.ui.client.animation.AnimationHelper;

/**
 * @author jett
 *
 */
public class Globals {

	private static AnimationHelper animationHelper = null;

	public static AnimationHelper getAnimationHelper() {
		if (animationHelper == null) {
			initAnimationHelper();
		}
		return animationHelper;
	}

	public static void setAnimationHelper(AnimationHelper animationHelper) {
		Globals.animationHelper = animationHelper;
	}
	
	public static void initAnimationHelper() {
		animationHelper = new AnimationHelper();
		RootPanel.get().clear();
		RootPanel.get().add(animationHelper);
	}
}
