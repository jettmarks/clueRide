/**
 * 
 */
package com.jettmarks.clue.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * GWT Service to set and read the current Reveal Level.
 * 
 * Currently, there is a single course, but in the future, we'll have to 
 * identify the course, user, and possibly a group (when multiple riders are
 * using a single "judge" to bump the reveal level).
 * 
 * @author jett
 */
@RemoteServiceRelativePath("reveal")	// Possibly used during source generation
public interface RevealLevelService extends RemoteService {
	int getCurrentPage(int groupId);
	int bumpCurrentPage(int groupId);
	public void setCurrentPage(int groupId, int newCurrentPage);
}
