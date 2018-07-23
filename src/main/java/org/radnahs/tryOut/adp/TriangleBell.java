/**
 *
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: org.radnahs.tryOut.adp </p>
 * <p>File Name: TriangleBell.java</p>
 * <p>Create Date: Oct 22, 2014 </p>
 * <p>Create Time: 3:04:35 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.adp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shantanu Sikdar
 * 
 */
public class TriangleBell {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		triangleBell(10,1);
		//triangleBell(10,2);
	}
	
	public static void triangleBell(int numOfRows, int beginWith) {
		Map<Integer, List<Integer>> mapRow = new HashMap<Integer, List<Integer>>(numOfRows);
		for (int i = 0; i < numOfRows; i++) {
			List<Integer> currLst = new ArrayList<Integer>();
			if(i == 0){
				currLst.add(i,beginWith);
			}else{
				List<Integer> prevLst = mapRow.get(i-1);
				for (int j = 0; j < i; j++) {
					if(j == 0)
						currLst.add(j,prevLst.get(prevLst.size()-1));
					else						
						currLst.add(j,currLst.get(j-1)+prevLst.get(j-1));					
				}
			}			
			mapRow.put(i, currLst);
		}
		display(mapRow);
	}
	
	private static void display(Map<Integer, List<Integer>> mapRow){
		for (Map.Entry<Integer, List<Integer>> entMap: mapRow.entrySet()) {
			//System.out.println(entMap.getKey());
			System.out.println(entMap.getValue());
		}
		
	}
	
	
	//by Kanchan
	public static void main1(String[] args) {
		int[] currentRow = new int[20];
		int[] previousRow = new int[20];
		int previousRowIndex = 1;
		previousRow[0] = 1;
		
		for (int row = 0; row < 10; row++) {
			System.out.println();
			for (int col = 0; col <= row; col++) {
				if (col == 0) {
					currentRow[col] = previousRow[previousRowIndex - 1];
				} else {
					currentRow[col] = currentRow[col - 1] + previousRow[col - 1];
				}
				System.out.print(currentRow[col] + " ");
			}
			previousRowIndex = 0;
			for (int i = 0; i < currentRow.length; i++) {
				if (currentRow[i] != 0) {
					previousRow[i] = currentRow[i];
					previousRowIndex++;
				}
			}
		}
	}
}
