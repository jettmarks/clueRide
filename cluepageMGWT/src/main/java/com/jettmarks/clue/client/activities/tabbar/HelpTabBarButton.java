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
public class HelpTabBarButton extends TabBarButtonBase {

	/**
	 * @param css
	 * @param imageResource
	 */
	public HelpTabBarButton() {
		super(MGWTStyle.getTheme().getMGWTClientBundle().getTabBarCss(), 
				AppBundle.INSTANCE.tabBarHelpImage());
		setText("Help");
	}

}
