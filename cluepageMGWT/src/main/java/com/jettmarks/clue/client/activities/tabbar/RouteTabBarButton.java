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
public class RouteTabBarButton extends TabBarButtonBase {
	
	public RouteTabBarButton() {
		super(MGWTStyle.getTheme().getMGWTClientBundle().getTabBarCss(), 
				AppBundle.INSTANCE.tabBarRouteImage());
		setText("Route");
	}
	
}
