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
public class TextClueTabBarButton extends TabBarButtonBase {
	
	public TextClueTabBarButton() {
		super(MGWTStyle.getTheme().getMGWTClientBundle().getTabBarCss(), 
				AppBundle.INSTANCE.tabBarTextClueImage());
		setText("Clue");
	}
	
}
