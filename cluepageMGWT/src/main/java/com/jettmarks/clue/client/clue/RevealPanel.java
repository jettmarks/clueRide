/**
 * 
 */
package com.jettmarks.clue.client.clue;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.Carousel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.jettmarks.clue.client.ad.AdPanel;
import com.jettmarks.clue.client.config.ClueRideSettings;
import com.jettmarks.clue.client.css.AppBundle;
import com.jettmarks.clue.client.nav.State;
import com.jettmarks.clue.client.service.RevealLevelServiceAsync;
import com.jettmarks.clue.client.util.ScreenSize;

/**
 * @author jett
 * 
 */
public class RevealPanel extends LayoutPanel {
	private Carousel carousel = null;
	private Course course = null;
	private RevealPanel instance = null;
	private Button refreshButton = null;
	private Button resetButton = null;
	private Button bumpButton = null;
	/** Tracks the current reveal level **/
	private int currentPage;

	public RevealPanel(Carousel carousel, Course course) {
		this.carousel = carousel;
		this.course = course;
		this.bumpButton = null;
		this.resetButton = null;
		this.refreshButton = new Button("Reveal next Clue");

		instance = this;
		
		this.addStyleName(AppBundle.INSTANCE.cssClueRide().revealPanel());
		this.setWidth(ScreenSize.getWidth()+"px");
		
		if (ClueRideSettings.isLeaderMode()) {
			buildBumpButton();
			buildResetButton();
		}

		// Respond to requests to refresh the set of clues
		buildRefreshButton();
	}

	/**
	 * 
	 */
	protected void buildRefreshButton() {
		refreshButton.addTapHandler(new TapHandler() {
			@Override
			public void onTap(TapEvent event) {
				// Make async call to see if we've got a new page we can show
				RevealLevelServiceAsync service = RevealLevelServiceAsync.Util
						.getInstance();
				AsyncCallback<Integer> callback = new RevealLevelAsyncCallback();
				service.getCurrentPage(State.getId(), callback);
			}
		});
		this.add(refreshButton);
	}

	/**
	 * 
	 */
	protected void buildResetButton() {
		this.resetButton = new Button("Initialize");
		// Respond to requests to bump the page
		resetButton.addTapHandler(new TapHandler() {
			@Override
			public void onTap(TapEvent event) {
				// Make async call to see if we've got a new page we can
				// show
				RevealLevelServiceAsync service = RevealLevelServiceAsync.Util
						.getInstance();
				AsyncCallback<Void> callback = new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						// Nothing to be done at this time
					}

					@Override
					public void onSuccess(Void result) {
						// Nothing to be done at this time
					}
				};
				service.setCurrentPage(State.getId(), 0, callback);
			}
		});
		this.add(resetButton);
	}

	/**
	 * 
	 */
	protected void buildBumpButton() {
		this.bumpButton = new Button("Show Next Clue");
		// Respond to requests to bump the page
		bumpButton.addTapHandler(new TapHandler() {
			@Override
			public void onTap(TapEvent event) {
				// Make async call to see if we've got a new page we can
				// show
				RevealLevelServiceAsync service = RevealLevelServiceAsync.Util
						.getInstance();
				AsyncCallback<Integer> callback = new RevealLevelAsyncCallback();
				service.bumpCurrentPage(State.getId(), callback);
			}
		});
		this.add(bumpButton);
	}

	/**
	 * Async call returns the current page and then based on that page, we
	 * refresh the carousel and reveal the appropriate set of clues.
	 */
	public void getCurrentPageAndRefreshCarousel() {
		RevealLevelServiceAsync service = RevealLevelServiceAsync.Util
				.getInstance();
		AsyncCallback<Integer> callback = new RevealLevelAsyncCallback();
		service.getCurrentPage(State.getId(), callback);
	}

	/**
	 * Performs the work of refreshing the Carousel of Clues whenever the page
	 * level changes.
	 */
	public void rebuildCarousel() {
		Carousel ourCarousel = getCarousel();
		ourCarousel.clear();

		for (int page = 0; page < course.getSize(); page++) {
			// Each page should be contained inside a LayoutPanel
			if (page <= currentPage) {
				carousel.add(new CluePanel(course.getClue(page)));
			} else if (page == (currentPage + 1)) {
				carousel.add(instance);
			} else if (page > (currentPage + 1)) {
				carousel.add(new AdPanel(page - currentPage - 1));
			}
		}
		currentPage++;
		// Show Return Route if we're at the end
		if (currentPage >= course.getSize()) {
			ourCarousel.add(new ReturnPanel(course.getReturnRouteName()));
			// Still need the leader's panel / refresh
			ourCarousel.add(this);
		}
		ourCarousel.refresh();
	}

	/**
	 * @return
	 */
	protected Course getCourse() {
		return course;
	}

	/**
	 * @return
	 */
	protected Carousel getCarousel() {
		return carousel;
	}

	/**
	 * @author jett
	 * 
	 */
	public class RevealLevelAsyncCallback implements AsyncCallback<Integer> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.google.gwt.user.client.rpc.AsyncCallback#onFailure(java.lang.
		 * Throwable)
		 */
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.google.gwt.user.client.rpc.AsyncCallback#onSuccess(java.lang.
		 * Object)
		 */
		@Override
		public void onSuccess(Integer result) {
			currentPage = result.intValue();
			rebuildCarousel();
		}

	}
}
