/**
 * 
 */
package com.jettmarks.clue.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jettmarks.clue.client.service.RevealLevelService;
import com.jettmarks.clue.server.domain.Group;

/**
 * @author jett
 *
 */
public class RevealLevelServiceImpl extends RemoteServiceServlet implements
		RevealLevelService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5943620817773835942L;
	
	private int currentPage = 0;
	
	/**
	 * Implementation of service that returns the current page that can be
	 * revealed in the application.
	 * 
	 * The groupId identifies which instance of the game is being played by the
	 * group.
	 * 
	 * @see com.jettmarks.clue.client.service.RevealLevelService#getCurrentPage()
	 */
	@Override
	public int getCurrentPage(int groupId) {
		Group group = SessionManagerImpl.getGroup(groupId);
		return group.getRevealLevel();
	}
	
	public int bumpCurrentPage(int groupId) {
		Group group = SessionManagerImpl.getGroup(groupId);
		group.bumpCurrentPage();
		return group.getRevealLevel();
	}
	
	public void setCurrentPage(int groupId, int newCurrentPage) {
		Group group = SessionManagerImpl.getGroup(groupId);
		group.setRevealLevel(newCurrentPage);
	}

}
