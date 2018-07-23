/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.amazon;
* File Name: SocialNetworkTraversal.java
* Create Date: Jun 24, 2016
* Create Time: 12:34:07 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/

package org.radnahs.tryOut.amazon;

/**
 * Suppose you are an engineer on the Amazon student team.
 * Your team wants to launch a new feature called "Course your Social Network
 * have Attended," that lists all courses that your social network is taking 
 * sorted by popularity.
 * A social network is defined as all direct friends and all direct friends of
 * direct friends.People three level deep are not part of the social circle as illustrated
 * below.
 * 
 * The recommendation logic is based on the following rules:
 * 1. A user should only be recommended a course that their social network 
 * have attended but they have not attened.
 * 2. The recommendations priority is driven by how many people have attend the 
 * same course - if multiple people attended the same course, it should be higher 
 * in the recommendation than a course that only one person attended.
 * 
 * You are provided two library functions to help you.
 * 1. getDirectFriendsForUser - returns a list of customer IDs (Strings that uniquely identify an 
 * Amazon user) representing the direct friend of an Amazon user.
 * 2. getAttendedCourseForUser - returns a list of course IDs (Strings that uniquely identify a
 * course) for an Amazon user ordered by attendance time with newest course first in list and 
 * oldest course last in list.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialNetworkTraversal {

	public static void main(String[] args) {
		SocialNetworkTraversal snt = new SocialNetworkTraversal();
	}
	
	private void eligibleFriendsList(){
		Map<String, List<String>> friendMap = new HashMap<String, List<String>>();
	}
	
	private List<String> getDirectFriendsForUser(){
		return new ArrayList<>();
	}

	private List<String> getAttendedCourseForUser(){
		return new ArrayList<>();
	}
}