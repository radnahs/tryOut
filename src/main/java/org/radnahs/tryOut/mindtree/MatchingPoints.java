/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: com.webtual.tryOut.utils.tests.mindtree </p>
 * <p>File Name: MatchingPoints.java</p>
 * <p>Create Date: Mar 10, 2015 </p>
 * <p>Create Time: 5:08:12 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.mindtree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shantanu Sikdar 
 *
 */
public class MatchingPoints {
	
	public static void main(String[] args) {
		//int[] input1 = {15,3,15,5,3,1,15};
		//int[] input1 = {15,3,15,3,1,13,15};
		int[] input1 = {15,3,15,3};
		int size = input1.length;
		//Map<Integer, Integer> mapCnt1 = new HashMap<Integer, Integer>(size); 
		Map<Integer, Integer> mapCnt2 = new HashMap<Integer, Integer>(size);
		int[] output1 = new int[size];
		for (int i = 0; i < size; i++) {
			int cnt1=1;
			int cnt2=1;
			for (int j = 0; j < size; j++) {
				if(input1[j]==input1[i]){
					//mapCnt1.put(i, cnt1++);
					mapCnt2.put(j, cnt2++);
				}				
			}			
		}		
		//System.out.println(mapCnt1);
		System.out.println(mapCnt2);
		StringBuilder strOp=new StringBuilder();
		for (int i = 0; i < size; i++) {
			int p=mapCnt2.get(i);
			int cnt=0;
			for (int j = 0; j <= i; j++) {				
				System.out.println(p+" -- "+mapCnt2.get(j));
				if(p==mapCnt2.get(j)){
					strOp.append(cnt++);
					strOp.append("||");
					System.out.println(strOp.toString());
				}
				
			}			
		}
		System.out.println(strOp.toString());
		/*for (Map.Entry<Integer, Integer> entryMap: mapCnt2.entrySet()) {
			entryMap.getKey();
		}*/
		
	}
	
	/*public static void main(String[] args) {
		int[] input1 = {15,3,15,3};
		int size = input1.length;
		int[] input1Temp = new int[size];
		int[] output1 = new int[size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < input1Temp.length; j++) {
				if(input1Temp[j]==input1[i]){
					
				}
			}
			input1Temp[i]=input1[i];			
		}
		
	}*/

}
