/**
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: com.webtual.rytry.utils.tests.thoughtworks </p>
 * <p>File Name: ChennaiLocalMain.java</p>
 * <p>Create Date: Mar 31, 2016 </p>
 * <p>Create Time: 8:25:35 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package org.radnahs.tryOut.thoughtworks;

import static org.radnahs.tryOut.thoughtworks.ChennaiRlyStation.*;

import java.util.Calendar;

public class ChennaiLocalMain {

	public void printTicket(ChennaiRlyStation start, ChennaiRlyStation end, boolean isReturn){
		System.out.println("Chennai Local");
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		ChennaiLocalService clbl = new ChennaiLocalService();
		int fare = clbl.journeyFare(start.getKey(),end.getKey(), isReturn);
		System.out.println(start.getName());
		System.out.println(end.getName());
		System.out.println("Stops "+clbl.numStations(start.getKey(),end.getKey()));
		System.out.println("Rs. "+fare);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChennaiLocalMain clm = new ChennaiLocalMain();
		clm.printTicket(Guindy,Chennai_Fort, false);
		clm.printTicket(Guindy,Chennai_Fort, true);
		clm.printTicket(Kodambakkam,Guindy, false);
	}
	
}
