/**
 * 
 */
package com.jettmarks.clue.client.util;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.jettmarks.clue.client.config.Constants;
import com.jettmarks.clue.client.css.AppBundle;

/**
 * @author jett
 *
 */
public class ImageLoader {

	/**
	 * @return
	 */
	public static Image getTestImage() {
		return getTestImage(1);
	}

	/**
	 * @param fileName
	 * @return
	 */
	public static Widget getImage(String courseName, String fileName) {
		Image img = new Image();
		img.addStyleName(AppBundle.INSTANCE.cssClueRide().clueImage());
		img.setUrl(Constants.IMG_SERVER_URL+"/"+courseName+"/400/"+fileName);
		return img;
	}

	/**
	 * @param index
	 * @return
	 */
	public static Image getTestImage(int index) {
		Image img = new Image();
		if (index < 1) index = 1;
		if (index > 3) index = 3;
		
		img.setUrl(Constants.IMG_SERVER_URL+"/test/image"+index+".png");
		img.addStyleName(AppBundle.INSTANCE.cssClueRide().clueImage());
		return img;
	}

	public static Image getAdImage(int index) {
		Image img = new Image();
		if (index < 1) index = 1;
		if (index > 3) index = 3;
		
		String courseName = "free5";
		
		img.setUrl(Constants.IMG_SERVER_URL+"/"+courseName+"/400/sampleAd0"+index+".png");
		img.addStyleName(AppBundle.INSTANCE.cssClueRide().clueImage());
		return img;
	}

	/**
	 * @param fileName
	 * @return
	 */
	public static Widget getImage(String fileName) {
		Image img = new Image();
		img.setUrl(Constants.IMG_SERVER_URL+"/../img/"+fileName);
		img.addStyleName(AppBundle.INSTANCE.cssClueRide().clueImage());
		return img;
	}

	/**
	 * @param string
	 * @return
	 */
	public static LayoutPanel getContaineredImage(String fileName) {
		LayoutPanel panel = new LayoutPanel();
		Image img = new Image();
		img.setUrl(Constants.IMG_SERVER_URL+"/../img/"+fileName);
		panel.addStyleName(AppBundle.INSTANCE.cssClueRide().clueImage());
		panel.add(img);
		return panel;
	}
}
