/**
 * <p>Project: org.radnahs.tryOut.thoughtworks.ConfTrackMgmt </p>
 * <p>Package Name: org.radnahs.tryOut.thoughtworks.ConfTrackMgmt </p>
 * <p>File Name: ConferenceTrackManagement.java </p>
 * <p>Create Date: May 19, 2017 </p>
 * <p>Create Time: 8:47:34 AM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.thoughtworks.ConfTrackMgmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Shantanu Sikdar
 */
public class ConferenceTrackManagement {

	static Map<String, Integer> mapInpt =  new HashMap<>();
	static int totalSessionTime=0;
	static int mornSession=180;
	static int postLunchSession=240;
	static int noOfSessionTracks=1;
	public static void main(String[] args) {
		ConferenceTrackManagement ctm = new ConferenceTrackManagement();
		ctm.readFile("D:\\Projects\\WebApplications\\rytry\\trunk\\src\\main\\java\\com\\webtual\\rytry\\tests\\thoughtworks\\ConfTrackMgmt\\input.txt");
		noOfSessionTracks=(totalSessionTime|(mornSession+postLunchSession))>0?totalSessionTime/(mornSession+postLunchSession)+1:totalSessionTime/(mornSession+postLunchSession);
		System.out.println(noOfSessionTracks);
		System.out.println(totalSessionTime);
		System.out.println(mapInpt);
	}
	
	public void readFile(String inFileName){
		try {
			ConferenceTrackManagement ctm = new ConferenceTrackManagement();
			File file = new File(inFileName);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				ctm.parseMessage(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void parseMessage(String strInpt){
		String[] strArr = strInpt.split(" ");
		int timeStr = Integer.parseInt(strArr[strArr.length-1].endsWith("min")?strArr[strArr.length-1].replace("min", ""):"5");
		totalSessionTime+=timeStr;
		mapInpt.put(strInpt, timeStr);
	}

}
