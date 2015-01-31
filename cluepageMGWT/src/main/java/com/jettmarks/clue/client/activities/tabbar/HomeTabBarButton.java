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
public class HomeTabBarButton extends TabBarButtonBase {

	/**
	 * @param css
	 * @param imageResource
	 */
	public HomeTabBarButton() {
		super(MGWTStyle.getTheme().getMGWTClientBundle().getTabBarCss(), 
				AppBundle.INSTANCE.tabBarHomeImage());
		setText("Home");
	}

}
