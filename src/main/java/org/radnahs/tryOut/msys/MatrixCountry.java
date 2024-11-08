/**
 * <p>Project: tryOut[] </p>
 * <p>Package Name: org.radnahs.tryOut.msys </p>
 * <p>File Name: MatrixCountry.java </p>
 * <p>Create Date: 13-Mar-2020 </p>
 * <p>Create Time: 9:24:21 am </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package org.radnahs.tryOut.msys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author : Shantanu Sikdar
 *
 */
public class MatrixCountry {

	public static void main(String[] args) {
		int[][] A =    		   {{5 ,4,4},
								{4 ,3,4},
								{3 ,2,4},
								{2 ,2,2},
								{3 ,3,4},
								{1 ,4,4},
								{4 ,1,1}};
		Map<String, List<String[]>> mapCntry = new HashMap<String, List<String[]>>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if(mapCntry.containsKey(A[i][j]+"")) {
					List<String[]> lstIndx = mapCntry.get(A[i][j]+"");
					String[] intArr = new String[] {i+"",j+""};
					lstIndx.add( intArr);
					mapCntry.put(A[i][j]+"", lstIndx);
				}else {
					List<String[]> lstIndx = new ArrayList<String[]>();
					String[] intArr = new String[] {i+"",j+""};
					lstIndx.add( intArr);
					mapCntry.put(A[i][j]+"", lstIndx);
				}
			}
		}
		for (Entry<String, List<String[]>> map : mapCntry.entrySet()) {
			countryCount(map);
		}
		
	}
	private static void countryCount(Entry<String, List<String[]>> map){
		System.out.println(map.getKey());
		List<String[]> lstIndx = map.getValue();
		int count = 1 ;
		for (int i=0 ;i<lstIndx.size();i++) {
			for (int j=1 ;j<lstIndx.size();j++) {
				if(lstIndx.get(i)[0] == lstIndx.get(j)[0] || lstIndx.get(i)[1] == lstIndx.get(j)[1]) {
					
				}else {
					count++;
				}
			}
		}
		System.out.print(" count = "+ count+"\n");
	}

}
