/**
 *
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: com.webtual.rytry.utils.tests.sapient </p>
 * <p>File Name: NitroCab.java</p>
 * <p>Create Date: Oct 13, 2015 </p>
 * <p>Create Time: 8:30:58 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.sapient;

import static org.radnahs.tryOut.sapient.NitroCabConstants.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @author Shantanu Sikdar 
 *
 */
public class NitroCabBusinessCalculation {
	
	/**
	 * Calculate the distance between two sectors
	 * @param startAreaCode
	 * @param endAreaCode
	 * @return
	 * @throws Exception
	 */
	private static int calculateDistance(int startAreaCode, int endAreaCode) throws Exception{
		int sectorDiff = 0;		
		if(!(endAreaCode==startAreaCode)){
			sectorDiff = endAreaCode>startAreaCode?endAreaCode-startAreaCode:-(endAreaCode-startAreaCode);
		}else{
			throw new Exception("Zero Distance");
		}
		return DISTANCE_BETWEEN_SECTOR*sectorDiff;
	}
		
	private static int calculateTimeTaken(int distance){		
		return distance>0?TIME_TAKEN_1KM*distance:0;
	}
		
	private static int costIncur(int distance){				
		return distance>0?COST_INCUR_1KM*distance:0;
	}
	
	/**
	 * Total cost incur for a cab. Considering that the cost incur to reach the pickup and from the pickup to the destination. 
	 * @param currentAreaCode
	 * @param pickUpAreaCode
	 * @param dropAreaCode
	 * @return
	 */
	private static int totalCostIncur(int currentAreaCode, int pickUpAreaCode, int dropAreaCode){
		int distanceToReachPickup=0;
		int distancePickupToDestination=0;
		try{
			distanceToReachPickup = calculateDistance(currentAreaCode, pickUpAreaCode);
			distancePickupToDestination = calculateDistance(pickUpAreaCode, dropAreaCode);
		}catch(Exception e){
			e.printStackTrace();
		}		
		int totalD=distancePickupToDestination + distanceToReachPickup;
		return costIncur(totalD);
	}
	
	/**
	 * Fare to be charged for the commute.
	 * @param pickUpAreaCode
	 * @param dropAreaCode
	 * @return
	 */
	private static int fare(int pickUpAreaCode, int dropAreaCode){		
		int distancePickupToDestination=0;
		try{			
			distancePickupToDestination = calculateDistance(pickUpAreaCode, dropAreaCode);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return distancePickupToDestination>0?CHARGE_1KM*distancePickupToDestination:0;
	}
	
	/**
	 * 
	 * @param totalCostIncur
	 * @param fare
	 * @return
	 */
	private boolean isMinProfitMargin(int totalCostIncur,int fare){		
		return 	fare*MIN_PROFIT_MARGIN>totalCostIncur;
	}
	
	private String getBookingId(){		
		BOOKING_ID_LIST.add("BR1000");
		String bookingIdKey = "BR"+	BOOKING_ID;
		while(BOOKING_ID_LIST.contains(BOOKING_ID)){
			BOOKING_ID++;
		}
		BOOKING_ID_LIST.add(bookingIdKey);
		return bookingIdKey;
	}
	
	public String orderBooking(int pickUpAreaCode, int dropAreaCode, Date pickUpTime ){
		String bookingId = getBookingId();
		BookingDAO bookingDAO = new BookingDAO();		
		bookingDAO.setPickUpAreaCode(pickUpAreaCode);
		bookingDAO.setDropAreaCode(dropAreaCode);
		bookingDAO.setPickUpTime(pickUpTime);
		bookingDAO.setOrderStatus("1");// status field will take care of the booking statu like  open=1, closed=2, cancelled=3
		
		bookingMap.put(bookingId, bookingDAO);
		return bookingId;
	}

	public void cabAllottment(){
		now.add(Calendar.HOUR, -2);
		for(Map.Entry<String, BookingDAO> booking : bookingMap.entrySet()){
			BookingDAO bookingDAO =booking.getValue();
			if("1".equals(bookingDAO.getOrderStatus())){
				//check for pickup time with the current time
				if (now.getTime()==bookingDAO.getPickUpTime()){
					CabDAO cabDAO =   findCab(bookingDAO.getPickUpAreaCode(),bookingDAO.getDropAreaCode());					
					bookingDAO.setCabDAO(cabDAO);
				}
				
			}
		}
	}
	
	public CabDAO findCab(int pickUp, int drop){		
		for(Map.Entry<String, CabDAO> cabStatus : cabMap.entrySet()){
			CabDAO cabDAO = cabStatus.getValue();		
			if("2".equals(cabDAO.getCabStatus())){
				int totalCostIncur = totalCostIncur(cabDAO.getCurrentAreaCode(),pickUp,drop);
				int fare = fare(pickUp,drop);
				if(isMinProfitMargin(totalCostIncur,fare)){
					cabDAO.setCabStatus("1");
					return cabDAO;
				}
			}
		}
		return null;
	}
	
	public void assignCab(String cabNumber, Integer pickupAreaCode, Integer dropAreaCode){		
		CabDAO cabDAO = new CabDAO();
		cabDAO.setCabNumber(cabNumber);
		cabDAO.setCurrentAreaCode(dropAreaCode);
		cabDAO.setCabStatus("1"); //cab status will be engage=1 and free=2
		cabMap.put(cabNumber, cabDAO);
	}
	

}
