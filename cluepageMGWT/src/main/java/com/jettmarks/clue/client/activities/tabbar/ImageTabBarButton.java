/**
 * 
 */
package com.jettmarks.clue.client.activities.tabbar;

import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButtonBase;
import com.jettmarks.clue.client.css.AppBundle;

/**
 * @author jett
 *
 */
public class ImageTabBarButton extends TabBarButtonBase {

	public ImageTabBarButton() {
		super(MGWTStyle.getTheme().getMGWTClientBundle().getTabBarCss(), 
				AppBundle.INSTANCE.tabBarImageImage());
		setText("Image");
	}
	
}
