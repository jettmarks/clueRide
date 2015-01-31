/**
 * 
 */
package com.jettmarks.clue.client.nav;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.ui.client.animation.AnimationHelper;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.touch.TouchPanel;
import com.jettmarks.clue.client.ClientFactory;
import com.jettmarks.clue.client.ClientFactoryImpl;
import com.jettmarks.clue.client.activities.tabbar.GameView;
import com.jettmarks.clue.client.config.ClueRideSettings;
import com.jettmarks.clue.client.css.AppBundle;
import com.jettmarks.clue.client.game.GameList;
import com.jettmarks.clue.client.group.GroupPanel;
import com.jettmarks.clue.client.nav.home.HomeUIBinder;
import com.jettmarks.clue.client.service.SessionManagerAsync;
import com.jettmarks.clue.client.util.Globals;
import com.jettmarks.clue.client.util.ScreenSize;

/**
 * Summary of the session status as presented to the user.
 * 
 * @author jett
 */
public class HomePanel extends LayoutPanel {

	final ListBox gameListBox = new ListBox();
	
	public HomePanel() {
//		oldMethod();
		
		TouchPanel touchPanel = new TouchPanel();
		Widget imgPanel = new HomeUIBinder();
//		LayoutPanel imgPanel = ImageLoader.getContaineredImage("logo_blank.png");
//		imgPanel.addStyleName(AppBundle.INSTANCE.cssClueRide().touchPanel());
		touchPanel.add(imgPanel);
		touchPanel.setHeight("100%");
		touchPanel.addTapHandler(new TapHandler(){
			@Override
			public void onTap(TapEvent event) {
				double fractionalWidth = (event.getStartX() * 1.0) / 
						(ScreenSize.getWidth() * 1.0);
//				double fractionalHeight = (event.getStartY() * 1.0) /
//						(ScreenSize.getHeight() * 1.0);
				
				if (event.getStartY() > 240) {
					Window.alert("Play");
				} else if (fractionalWidth > 0.5) {
					Window.alert("Select Group");
				} else {
					Window.alert("Select Game");
				}
				// Pull from HTML page and tell rest of the GWT JavaScript
				ClueRideSettings.setLeaderMode(getLeaderMode());
//				showHomePage();
			}

			public native boolean getLeaderMode() /*-{
		        return $wnd.leaderMode;
			}-*/;
		}); 
		this.addStyleName(AppBundle.INSTANCE.cssClueRide().introPanel());
		
//		Label node1Label = new Label("Course:");
//		node1Label.addStyleName(AppBundle.INSTANCE.cssClueRide().node1Text());
//		touchPanel.add(node1Label);
//		imgPanel.add(node1Label);
		this.add(touchPanel);
	}

	/**
	 * 
	 */
	protected void oldMethod() {
		buildGameSelection();
		buildGroupSelection();
		
		Button playGameButton = new Button("Play Game");
		playGameButton.addTapHandler(new TapHandler(){

			@Override
			public void onTap(TapEvent event) {
				if (State.isReadyToPlay()) {
					showGame(State.getGameName());
				}
			}});
		
		this.add(playGameButton);
		
		Button showGameDetailsButton = new Button("Show Game Details");
		this.add(showGameDetailsButton);
		
		this.addStyleName(AppBundle.INSTANCE.cssClueRide().introPanel());
	}

	/**
	 * 
	 */
	protected void buildGameSelection() {
		
		Label sectionLabel = new Label("Selected Game: ");
		String selectedGame = State.getGameName();
		if (selectedGame == null) {
			gameListBox.addItem("Choose Game");
		}
		for (String item : GameList.getGameList()) {
			gameListBox.addItem(item);
		}
		gameListBox.addChangeHandler(new ChangeHandler(){

			@Override
			public void onChange(ChangeEvent event) {
				String selectedGame = gameListBox.getItemText(
						gameListBox.getSelectedIndex());
				State.setGameName(selectedGame);
			}});
		
		this.add(sectionLabel);
		this.add(gameListBox);
	}
	
	/**
	 * Sets up to handle user's choice to join a group or as a default, sets
	 * up an anonymous ("null") group with it's own individual group ID.
	 */
	protected void buildGroupSelection() {
		Label groupLabel = new Label("Choose a Group to Join");
		final TextBox groupBox = new TextBox();
		if (State.getGroup() != null) {
			groupBox.setText(State.getGroup());
		}
		Button submitButton = new Button("Join Group");
		submitButton.addTapHandler(new TapHandler() {
			@Override
			public void onTap(TapEvent event) {
				String groupName = groupBox.getText();
				State.setGroup(groupName);
				requestGroup(groupName);
			}
		});
		
		this.add(groupLabel);
		this.add(groupBox);
		this.add(submitButton);
		
		// Kick off anonymous group creation
		requestGroup(null);
	}

	/**
	 * Sets up the panels for following the course.
	 * @param gameName 
	 */
	private void showGame(String gameName) {
		// build animation helper and attach it
		AnimationHelper animationHelper = Globals.getAnimationHelper();
	
		ClientFactory clientFactory = new ClientFactoryImpl();
		GameView gameView = clientFactory.getGameView();
		gameView.setGameName(gameName);
	
		// animate
		animationHelper.goTo(gameView, Animation.POP_REVERSE);
	}

	/**
	 * Sets up the panels for choosing a Group.
	 */
	private void showGroupSelection() {
		// build animation helper and attach it
		AnimationHelper animationHelper = Globals.getAnimationHelper();
	
		GroupPanel groupPanel = new GroupPanel();
	
		// animate
		animationHelper.goTo(groupPanel, Animation.SLIDE);
	}

	/**
	 * Make call over to server to register a Group and return a Group ID we
	 * can use for future calls to the server identifying our session.
	 * 
	 * @param groupName
	 */
	protected void requestGroup(String groupName) {
		SessionManagerAsync service = SessionManagerAsync.Util
				.getInstance();
		AsyncCallback<Integer> callback = new SessionManagerAsyncCallback();
		service.joinGroup(groupName, callback);
	}

	/**
	 * @author jett
	 * 
	 */
	public class SessionManagerAsyncCallback implements AsyncCallback<Integer> {

		/**
		 * Nothing to be done upon failure.
		 * 
		 * @see
		 * com.google.gwt.user.client.rpc.AsyncCallback#onFailure(java.lang.
		 * Throwable)
		 */
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
		}

		/**
		 * Record our Group as offered by the server.
		 * 
		 * @see
		 * com.google.gwt.user.client.rpc.AsyncCallback#onSuccess(java.lang.
		 * Object)
		 */
		@Override
		public void onSuccess(Integer result) {
			if (result == null) {
				Window.alert("Got a null Result from Group Request");
			}
			State.setId(result);
		}
	}
}
