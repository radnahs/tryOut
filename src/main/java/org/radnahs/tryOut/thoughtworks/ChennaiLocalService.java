/**
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: com.webtual.rytry.utils.tests.thoughtworks </p>
 * <p>File Name: ChennaiLocalBL.java</p>
 * <p>Create Date: Mar 31, 2016 </p>
 * <p>Create Time: 12:25:35 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package org.radnahs.tryOut.thoughtworks;

public class ChennaiLocalService {
	
	public static int basePrice =10;
	public static int baseDist =5;
	public static int priceRise =5;
	public static int priceRiseDist =5;
	
	public int numStations(int start, int end){
		return Math.abs(start-end);
	}
	
	private int fareCalculation(int start, int end){
		int returnVal=0;
		int dist = numStations(start, end);
		//System.out.println("dist = "+dist);
		if(dist<=baseDist){
			returnVal=basePrice;
		}else{
			if(dist%priceRiseDist>0){
				return basePrice+priceRise*(dist/priceRiseDist);
			}
		}
		return returnVal;
	}
	
	public int journeyFare(int start, int end, boolean isReturn){
		int fare =0;
		//System.out.println("start"+start);
		//System.out.println("end "+end);
		if(isReturn){
			// as there is no clause mention I assume that its twice the one way journey.
			fare= fareCalculation(start, end)*2;
		}else{
			fare= fareCalculation(start, end);
		}
		return fare;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChennaiLocalService clbl = new ChennaiLocalService();
		/*System.out.println(clbl.numStations(2, 9));
		System.out.println(clbl.numStations(18, 9));
		System.out.println(14%5);
		System.out.println(14/5);*/
		//System.out.println("fare ="+clbl.journeyFare(7,10,false));
		//System.out.println("fare ="+clbl.journeyFare(10,2,false));
	}

}
