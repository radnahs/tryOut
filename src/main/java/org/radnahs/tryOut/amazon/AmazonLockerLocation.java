/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.amazon;
* File Name: AmazonLockerLocation.java
* Create Date: Jun 24, 2016
* Create Time: 12:34:07 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/

/**
 * Amazon is currently underway putting amazon lockers across the country.
 * The locker teams wants to ensure that lockers are placed  so that the
 * customer in the city are always within a short distance from a n amazon
 * locker. To account for this, they need a way to model locker placements
 * and distances from lockers.
 * 
 * For this task you are provided:
 * 1. A positive whole number range 1-9 representing the length of your city in city blocks.
 * 2. A positive whole number range 1-9 representing the width of your city in city blocks.
 * 3. An array containing all X coordinates representing Amazon locker locations, each X cordinate range 1-9.
 * 4. An array containing all Y coordinates representing Amazon locker locations, each Y cordinate range 1-9.
 * 
 *  Your job is to construct a 2-d grid of the city. Each element of the grid should be a positive whole number
 *  that specifies the number of blocks to the closest locker. The distance between two blocks is the sum of their
 *  horizontal and vertical distance (a move in the diagonal direction is therefore considered a distance of 2). Return
 *	your grid as 2d array of integers where the first index corresponds to the X dimension and the second index corresponds to the Y direction.
 * 
 * Example #1;
 * Given 
 * 1. 3
 * 2. 5
 * 3. [0]
 * 4. [0]
 * Return
 * 0	1	2
 * 1	2	3
 * 2	3	4
 * 3	4	5
 * 4	5	6
 * 
 *
 * Example #2;
 * Given 
 * 1. 5
 * 2. 7
 * 3. [1,5]
 * 4. [1,3]
 * Return
 * 2	1	2	3	4
 * 1	0	1	2	3
 * 2	1	2	3	4
 * 3	2	3	2	3
 * 4	3	2	1	2
 * 3	2	1	0	1
 * 4	3	2	1	2
 *
 */

package org.radnahs.tryOut.amazon;

public class AmazonLockerLocation {

	//private static void gridOfCity(int horizontal, int vertical){
	private static void gridOfCity(int horizontal, int vertical, int[][] indexesLocations){
		//int[] indexesLocations={0,0};
		//int[][] indexesLocations={{1,1},{5,3}};
		//int[][] indexesLocations={{0,0}};
		//int[][] indexesLocations={{1,1},{5,3},{9,8}};
		int[][] intArr = new int[vertical][horizontal];
		for(int i = 0; i<vertical; i++){
			for(int j=0;j<horizontal;j++){
				//System.out.print("arr["+i+","+j+"]");
/*				int m = Math.abs(indx1[0]-j);
				int n = Math.abs(indx1[0]-i);
				intArr[i][j]=m+n;*/
				intArr[i][j] = distanceCnt(indexesLocations,i,j);
				
			}
			//System.out.println();
		}
		display2DArray(intArr,horizontal, vertical);
	}
	
	private static int distanceCnt(int[][] indx1,int i, int j){
		int sum=0;
		for (int l = 0; l < indx1.length; l++) {
			int[] js = indx1[l];
			int temp =0;
				/*int q=js[0];
				int r=js[1];
				System.out.println(q+"   "+r);*/
			temp = Math.abs(js[0]-i)+Math.abs(js[1]-j);
			
			if(l==0){
				sum = temp;
			}
			//System.out.println("temp = "+temp);
			if(sum>temp){
				sum = temp;
			}
			//System.out.println("sum = "+sum);
		}
		return sum;
	}
	
	private static void display2DArray(int[][] intArr, int horizontal, int vertical){
		//System.out.println("display2DArray");
		for(int i = 0; i<vertical; i++){
			for(int j=0;j<horizontal;j++){
				System.out.print(intArr[i][j]+"	 ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		//gridOfCity(3,5);
		//gridOfCity(5,7, new int[][]{{1,1},{5,3}});
		gridOfCity(9,11,new int[][]{{1,1},{5,3},{9,8}});
	}
	
}
