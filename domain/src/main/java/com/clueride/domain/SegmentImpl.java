/**
 *   Copyright 2015 Jett Marks
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created Jul 28, 2015
 */
package com.clueride.domain;

/**
 * Portion of a Leg with identical characteristics (and thus rating) over the
 * entire length of the Segment.
 * 
 * Consists of
 * <UL>
 * <LI>a directed list of Nodes (a Track)
 * <LI>whether it can be traversed in both directions or only one direction
 * <LI>Rating
 * <LI>Distance
 * </UL>
 *
 * @author jett
 *
 */
public class SegmentImpl implements Segment {
	private Track track;
	private boolean oneWay;
	private Rating rating;
	private double distanceMiles;

	/**
	 * @return the track
	 */
	public Track getTrack() {
		return track;
	}

	/**
	 * @param track
	 *            the track to set
	 */
	public void setTrack(Track track) {
		this.track = track;
	}

	/**
	 * @return the oneWay
	 */
	public boolean isOneWay() {
		return oneWay;
	}

	/**
	 * @param oneWay
	 *            the oneWay to set
	 */
	public void setOneWay(boolean oneWay) {
		this.oneWay = oneWay;
	}

	/**
	 * @return the rating
	 */
	public Rating getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(Rating rating) {
		this.rating = rating;
	}

	/**
	 * @return the distanceMiles
	 */
	public double getDistanceMiles() {
		return distanceMiles;
	}
}
