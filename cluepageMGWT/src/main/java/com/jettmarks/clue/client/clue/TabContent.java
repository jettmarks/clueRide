/**
 * 
 */
package com.jettmarks.clue.client.clue;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.orientation.OrientationChangeEvent;
import com.googlecode.mgwt.dom.client.event.orientation.OrientationChangeHandler;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.jettmarks.clue.client.css.AppBundle;
import com.jettmarks.clue.client.util.ScreenSize;

/**
 * Holds the stuff to be displayed inside one of the tabs.
 * 
 * Can be extended to include different types of clues.
 * 
 * @author jett
 */
public class TabContent extends LayoutPanel implements OrientationChangeHandler  {

	public TabContent(Widget w) {
		this(w, true);
	}
	/**
	 * @param w
	 */
	public TabContent(Widget w, boolean isCentered) {
		if (isCentered) {
			this.addStyleName(AppBundle.INSTANCE.cssClueRide().clueContentPanel());
		}
		this.setHeight((ScreenSize.getHeight()-64)+"px");
		this.add(w);
	}

	/**
	 * When screen size changes, we want to adjust the size of our content to
	 * fit the screen.
	 * 
	 * @see com.googlecode.mgwt.dom.client.event.orientation.OrientationChangeHandler#onOrientationChanged(com.googlecode.mgwt.dom.client.event.orientation.OrientationChangeEvent)
	 */
	@Override
	public void onOrientationChanged(OrientationChangeEvent event) {
		this.setHeight((ScreenSize.getHeight()-64)+"px");
	}
}
