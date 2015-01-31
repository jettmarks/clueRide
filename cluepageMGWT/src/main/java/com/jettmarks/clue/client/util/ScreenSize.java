/**
 * 
 */
package com.jettmarks.clue.client.util;

import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;

/**
 * @author jett
 * 
 */
public class ScreenSize {
	private int height;
	private int width;
	
	private static ScreenSize instance = new ScreenSize();
	
	private ScreenSize() {
		setHeight(Window.getClientHeight());
		setWidth(Window.getClientWidth());
		
		Window.addResizeHandler(new ResizeHandler() {

			@Override
			public void onResize(ResizeEvent event) {
				setHeight(event.getHeight());
				setWidth(event.getWidth());
			}
		});
	}

	public static int getHeight() {
		return instance.height;
	}

	protected void setHeight(int height) {
		this.height = height;
	}

	public static int getWidth() {
		return instance.width;
	}

	protected void setWidth(int width) {
		this.width = width;
	}
}
