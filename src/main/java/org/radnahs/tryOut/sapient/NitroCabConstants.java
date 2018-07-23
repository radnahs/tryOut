/**
 *
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: org.radnahs.tryOut.sapient </p>
 * <p>File Name: NitroCabConstants.java</p>
 * <p>Create Date: Oct 12, 2015 </p>
 * <p>Create Time: 12:11:44 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.sapient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shantanu Sikdar 
 *
 */
public class NitroCabConstants {

	public static int NUM_OF_SECTORS = 100;
	public static int[] SECTORS = new int[NUM_OF_SECTORS];
	public static int AREA_CODE_START =100001;
	public static final int DISTANCE_BETWEEN_SECTOR  = 2;
	public static final int TIME_TAKEN_1KM  = 2;	
	public static final int COST_INCUR_1KM  = 5;
	public static final int CHARGE_1KM  = 10;	
	public static final double MIN_PROFIT_MARGIN = 0.8;			
	public static int BOOKING_ID = 1000;
	public static List<String> BOOKING_ID_LIST  = new ArrayList<String>();
	
	public static Calendar now = Calendar.getInstance();
	
	public static Map<String, CabDAO> cabMap= new HashMap<String, CabDAO>();//key will have the cab no. which is unique, value will be integer as the sector location.
	public static Map<String, BookingDAO> bookingMap = new HashMap<String, BookingDAO>();
	
	static{
		for(int i=0 ; i<NUM_OF_SECTORS ;i++){
			SECTORS[i]=AREA_CODE_START+i;
		}		
	}
}
