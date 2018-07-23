/**
 *
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: com.webtual.rytry.utils.tests.sapient </p>
 * <p>File Name: SapientMain.java</p>
 * <p>Create Date: Jul 27, 2015 </p>
 * <p>Create Time: 5:31:29 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.sapient;

import java.util.Calendar;

/**
 * @author Shantanu Sikdar 
 *
 */
public class SapientMain {
	
	public static void main(String[] args){
		NitroCabBusinessCalculation nitroCab = new NitroCabBusinessCalculation();
		String bookingid = nitroCab.orderBooking(100001, 100001, Calendar.getInstance().getTime());
		System.out.println("bookingid = "+bookingid);
	}
	
}
