/**
 * 
 */
package com.jettmarks.clue.client.ad;

import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.jettmarks.clue.client.util.ImageLoader;

/**
 * @author jett
 *
 */
public class AdPanel extends LayoutPanel {

	public AdPanel() {
		createGreyPanel();
		this.setWidth("0px");
	}
	
	protected void createGreyPanel() {
		this.add(ImageLoader.getTestImage());
	}
	
	public AdPanel(int index) {
		createGreyPanel(index);
		this.setWidth("0px");
	}
	
	protected void createGreyPanel(int index) {
		this.add(ImageLoader.getAdImage(index));
	}
	
	

}
