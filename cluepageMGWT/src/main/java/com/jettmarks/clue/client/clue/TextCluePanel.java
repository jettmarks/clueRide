/**
 * 
 */
package com.jettmarks.clue.client.clue;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.jettmarks.clue.client.service.RSSProxy;
import com.jettmarks.clue.client.service.RSSProxyAsync;

/**
 * Loads a document from the String URL asynchronously and places it into the
 * Text Clue tab of a Clue.
 * 
 * @author jett
 */
public class TextCluePanel extends HTMLPanel {
	
	final TextCluePanel instance;
	
	public TextCluePanel(String documentSource) {
		super("Loading ...");
		
		this.setHeight("100%");
//		this.addStyleName(AppBundle.INSTANCE.cssClueRide().textFrame());
		this.instance = this;
		RSSProxyAsync service = RSSProxy.Util.getInstance();
		AsyncCallback<String> callback = new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(String result) {
				instance.getElement().setInnerHTML(result);
			}
		};
		service.getFeed(documentSource, callback);
	}
}
