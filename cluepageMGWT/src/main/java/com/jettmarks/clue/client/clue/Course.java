/**
 * 
 */
package com.jettmarks.clue.client.clue;

import java.util.ArrayList;
import java.util.List;

/**
 * Domain object for a Clue Ride Route from start, through via points with 
 * clues, to a final destination, with recommended path back to start.
 * 
 * @author jett
 */
public class Course {
	private String courseName;
	private List<Clue> clueSequence = new ArrayList<Clue>();
	/** Track how many clues are visible so far. */
	private int revealDepth = 0;
	private String returnRouteName;
	
	public Course(String courseName) {
		setCourseName(courseName);
	}
	
	/**
	 * Number of clues in this course.
	 * 
	 * @return
	 */
	public int getSize() {
		return clueSequence.size();
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
		
		this.addClue(new Clue("peace.jpg", "route-3968059-map-full-start.png", "1.html"));
		this.addClue(new Clue("rhino.jpg", "route-3853854-map-full-leg1.png", "2.html"));
		this.addClue(new Clue("ghandi.jpg", "route-3853959-map-full-leg2.png", "3.html"));
		this.addClue(new Clue("muni-auburn.jpg", "route-3935787-map-full-leg3.png", "4.html"));
		this.addClue(new Clue("oakland.jpg", "route-3935800-map-full-leg4.png", "5.html"));
		this.addReturn("route-3935810-map-full-legReturn.png");
	}

	public List<Clue> getClueSequence() {
		return clueSequence;
	}

	public void setClueSequence(List<Clue> clueSequence) {
		this.clueSequence = clueSequence;
	}

	public void addClue(Clue clue) {
		clueSequence.add(clue);
	}
	
	public Clue revealNext() {
		if (revealDepth < clueSequence.size()) {
			return clueSequence.get(revealDepth++);
		} else {
			return null;
		}
	}

	/**
	 * @param page
	 * @return
	 */
	public Clue getClue(int page) {
		return clueSequence.get(page);
	}

	/**
	 * @param string
	 */
	public void addReturn(String returnRouteName) {
		this.returnRouteName = returnRouteName;
	}

	/**
	 * @return
	 */
	public String getReturnRouteName() {
		return returnRouteName;
	}
}
