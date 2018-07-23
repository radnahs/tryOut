/**
 *
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: org.radnahs.tryOut.resilinc </p>
 * <p>File Name: PascalTriangle.java</p>
 * <p>Create Date: Aug 21, 2015 </p>
 * <p>Create Time: 8:33:57 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.resilinc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shantanu Sikdar 
 *
 */
public class PascalTriangle {

	/**
	 * @param args
	 * 1
	 * 1 1
	 * 1 2 1
	 * 1 3 3 1
	 * 1 4 6 4 1
	 * 1 5 10 10 5 1
	 * 1 6 15 20 15 6 1
	 */
	public static void main(String[] args) {
		//pascalTriangle(7,1);
		pascalTriangle(3,3);
	}
	
	private static void pascalTriangle(int numOfRows, int beginWith){
		Map<Integer, List<Integer>> mapRow = new HashMap<Integer, List<Integer>>(numOfRows);
		for (int i = 0; i < numOfRows; i++) {
			List<Integer> currLst = new ArrayList<Integer>();
			if(i == 0){
				currLst.add(i,beginWith);
			}else{
				List<Integer> prevLst = mapRow.get(i-1);
				for (int j = 0; j <= i; j++) {
					if(j == 0){
						currLst.add(j,prevLst.get(j));
					}else{						
						if(j==i){
							currLst.add(j,(prevLst.get(j-1)));
						}else{
							currLst.add(j,(prevLst.get(j-1)+prevLst.get(j)));
						}
					}
				}
			}			
			mapRow.put(i, currLst);
		}
		display(mapRow);
	}
	
	private static void display(Map<Integer, List<Integer>> mapRow){
		for (Map.Entry<Integer, List<Integer>> entMap: mapRow.entrySet()) {
			System.out.println(entMap.getValue());
		}
		
	}

}
