/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.tomtom;
* File Name: OptimizeTicketBuys.java
* Create Date: Aug 30, 2016
* Create Time: 12:48:25 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.tomtom;


/**
 * 
 * 
You want to buy public transport tickets for the upcoming month. You know exactly 
the days on which you will be traveling. The month has 30 days and there are three 
types of ticket:
1-day ticket, costs 2, valid for one day;
7-day ticket, costs 7, valid for seven consecutive days (e.g. if the first valid day is X, then the last valid day is X+6);
30-day ticket, costs 25, valid for all thirty days of the month.

You want to pay as little as possible.
You are given a sorted (in increasing order) array A of dates when you will be traveling. For example, given:
	A[0] = 1
    A[1] = 2
    A[2] = 4
    A[3] = 5
    A[4] = 7
    A[5] = 29
    A[6] = 30
you can buy one 7-day ticket and two 1-day tickets. The two 1-day tickets should be used on days 29 and 30. 
The 7-day ticket should be used on the first seven days of the month. The total cost is 11 and there is no 
possible way of paying less.
Write a function:
	class Solution { public int solution(int[] A); }
	that, given a zero-indexed array A consisting of N integers that specifies days on which you will be 
	traveling, returns the minimum amount of money that you have to spend on tickets for the month.
For example, given the above data, the function should return 11, as explained above.</p>
Assume that:
	N is an integer within the range [0 .. 30];
	each element of array A is an integer within the range [1 .. 30 ];
	array A is sorted in increasing order;	
    the elements of A are all distinct.
 In your solution, focus on  correctness. The performance of your solution will not be the focus of the assessment.
 *  
 * @author ssikdar
 *
 */

public class OptimizeTicketBuys {
	
	public static void main(String[] args) {
		OptimizeTicketBuys otb = new OptimizeTicketBuys();
		//int k = otb.solution(new int[]{1,2,4,5,7,29,30});
		//int k = otb.solution(new int[]{1,29,30});
		int k = otb.solution(new int[]{1,2,4,5,7,19,20,21,22,23,24,29,30});
		System.out.println("K = " +k);
		//System.out.println(otb.getConsecutiveNumbers(new int[]{1,2,4,5,7,29,30}));
		//System.out.println(otb.getConsecutiveNumbers(new int[]{1,2,4,5,7,19,20,21,22,23,24,29,30}));
	}
	
	//https://discuss.leetcode.com/topic/41061/tickets-needed-to-get-minimum-cost/5
	public int solution(int days[]) {
		int n = days.length;
		int cost[] = new int[n];
		int oneDayCost = 2, sevenDayCost = 7, thirtyDayCost = 25;
		cost[0] = oneDayCost;
		for (int i = 1; i < n; i++) {
			cost[i] = cost[i - 1] + oneDayCost;
			int diff = days[i] - days[0];
			if (i >= 12) {
				int pass30Cost = ((diff + 1) / 30) * thirtyDayCost;
				int pass30RemainsCost1DayPass = ((diff + 1) % 30) * oneDayCost;
				int pass30RemainsCost7DayPass = ((diff + 1) % 30) / 7 * sevenDayCost;
				int pass30RemainsCost7DayPassRemain1DayPass = ((diff + 1) % 30) % 7 * oneDayCost;
				int pass30RemainsCost7DayTot = pass30RemainsCost7DayPass
						+ (pass30RemainsCost7DayPassRemain1DayPass < sevenDayCost ? pass30RemainsCost7DayPassRemain1DayPass
								: sevenDayCost);
				int pass30orPass7 = (pass30RemainsCost7DayTot < pass30RemainsCost1DayPass ? pass30RemainsCost7DayTot
						: pass30RemainsCost1DayPass);
				int pass30CostFinal = pass30Cost + (pass30orPass7 < thirtyDayCost ? pass30orPass7 : thirtyDayCost);
				cost[i] = cost[i] > pass30CostFinal ? pass30CostFinal : cost[i];
			} else if (i >= 3) {
				int pass7Cost = ((diff + 1) / 7) * sevenDayCost;
				int pass7RemainDaysCost = (((diff + 1) % 7) * oneDayCost) < sevenDayCost ? (((diff + 1) % 7) * oneDayCost)
						: sevenDayCost;
				pass7Cost += pass7RemainDaysCost;
				cost[i] = cost[i] > pass7Cost ? pass7Cost : cost[i];
			}
		}
		System.out.println("Total Cost " + cost[n - 1]);
		return cost[n - 1];
	}
	
	public int solution1(int[] A){
		int k = 0;		
		int oneDayPrice = 2,sevenDaysPrice = 7,thirtyDaysPrice = 25;
		if(A.length>22){
			k=thirtyDaysPrice;
		}else if(A.length<4){
			k=oneDayPrice*A.length;
		}else{
			for(int p=0;p<A.length;p++){
				
			}
		}
		return 1 ;
	}
	
	public int getConsecutiveNumbers(int [] lottoNumbers) {
	    int consecutives = 0;
	    for(int i = 0; i < lottoNumbers.length-1; i++) {
	        if(lottoNumbers[i+1] - lottoNumbers[i] == 1){
	            consecutives++; // Numbers were consecutive
	            System.out.println(lottoNumbers[i]+"-" +lottoNumbers[i+1]);
	        }

	    }
	    return consecutives;
	}

}
