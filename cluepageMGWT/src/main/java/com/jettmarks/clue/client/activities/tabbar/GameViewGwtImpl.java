/*
 * 
 */
package com.jettmarks.clue.client.activities.tabbar;

import com.googlecode.mgwt.ui.client.widget.Carousel;
import com.jettmarks.clue.client.DetailViewGwtImpl;
import com.jettmarks.clue.client.clue.Course;
import com.jettmarks.clue.client.clue.RevealPanel;

/**
 * 
 * @author Jett Marks
 */
public class GameViewGwtImpl extends DetailViewGwtImpl implements GameView {

	private RevealPanel revealPanel = null;
	
	public GameViewGwtImpl() {

//		TouchDelegate longTapHandler = new TouchDelegate(carousel);
//		longTapHandler.addLongTapHandler(new LongTapHandler(){
//
//			@Override
//			public void onLongTap(LongTapEvent event) {
//				Window.alert("Whoo hoo!");
//			}});

	}

	/* (non-Javadoc)
	 * @see com.jettmarks.clue.client.activities.tabbar.GameView#setGameName(java.lang.String)
	 */
	@Override
	public void setGameName(String gameName) {
		Carousel carousel = new Carousel();
		
		Course course = new Course(gameName);
		
		revealPanel = new RevealPanel(carousel, course);
		revealPanel.getCurrentPageAndRefreshCarousel();
		
		main.add(carousel);
		main.remove(scrollPanel);
	}
}
