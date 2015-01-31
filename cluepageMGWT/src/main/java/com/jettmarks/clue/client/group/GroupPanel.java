/**
 * 
 */
package com.jettmarks.clue.client.group;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.jettmarks.clue.client.css.AppBundle;
import com.jettmarks.clue.client.nav.State;
import com.jettmarks.clue.client.service.SessionManagerAsync;

/**
 * @author jett
 *
 */
public class GroupPanel extends LayoutPanel {

	public GroupPanel() {
		Label statusLabel = new Label("Choose a Group to Join");
		final TextBox groupBox = new TextBox();
		Button submitButton = new Button("Join Group");
		submitButton.addTapHandler(new TapHandler(){
			@Override
			public void onTap(TapEvent event) {
				String groupName = groupBox.getText();
				SessionManagerAsync service = SessionManagerAsync.Util.getInstance();
				AsyncCallback<Integer> callback = new SessionManagerAsyncCallback();
				service.joinGroup(groupName, callback);
			}});
		this.add(statusLabel);
		this.add(groupBox);
		this.add(submitButton);
		this.addStyleName(AppBundle.INSTANCE.cssClueRide().introPanel());
	}

	/**
	 * @author jett
	 *
	 */
	public class SessionManagerAsyncCallback implements AsyncCallback<Integer> {

		/* (non-Javadoc)
		 * @see com.google.gwt.user.client.rpc.AsyncCallback#onFailure(java.lang.Throwable)
		 */
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub

		}

		/* (non-Javadoc)
		 * @see com.google.gwt.user.client.rpc.AsyncCallback#onSuccess(java.lang.Object)
		 */
		@Override
		public void onSuccess(Integer result) {
			State.setId(result);
		}
	}
}
