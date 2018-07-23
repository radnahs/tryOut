/**
 * <p>Project: org.radnahs.tryOut.tesco </p>
 * <p>Package Name: org.radnahs.tryOut.tesco </p>
 * <p>File Name: SeriesCheckProblem.java </p>
 * <p>Create Date: Apr 27, 2017 </p>
 * <p>Create Time: 1:10:49 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

/**
 * A given series could be arithmetic, geometric or fibonacci.
 * we will provide you "n" numbers and you have to first decide
 * which type of series it is, and then find out the next number.
 * if you are not able to get an output return -999
 * 
 * input
 * input1: Integer value the length of the array
 * input2: INteger array. e.g{0,1,1,2,3,5}
 * 
 * output
 * for the given example, the series is a Fibonacci Series
 * and your output should be 8
 * so your function should return 8.
 * 
 *  Example1:
 *  input: 5
 *  intput2[] : {1,3,9,27,81}
 *  output:243
 *  
 *  Example2:
 *  input: 5
 *  intput2[] : {2,4,6,8,10}
 *  output:12
 *  
 */

package org.radnahs.tryOut.tesco;

public class SeriesCheckProblem {
	
	static int cmnRatio;
	static int cmnDiff;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SeriesCheckProblem prb1= new SeriesCheckProblem();
		//int[] inputArray = new int[]{2, 4, 6, 8, 10, 12};//AP
		//int[] inputArray = new int[]{-8, -6, -4, -2 };//AP
		//int[] inputArray = new int[]{1, 3, 9, 27, 81};//GP
		//int[] inputArray = new int[]{1, 2, 3, 5, 8};//fibonacci
		//int[] inputArray = new int[]{0,1,1,2,3,5};//fibonacci
		//int[] inputArray = new int[]{-5,-3,-8,-11,-19};//fibonacci
		int[] inputArray = new int[]{-1,0,-1,-1,-2};//fibonacci
		if(prb1.isArrayAP(inputArray)){
			System.out.println(inputArray[inputArray.length-1]+cmnDiff);
		}else if(prb1.isArrayGP(inputArray)){
			System.out.println(inputArray[inputArray.length-1]*cmnRatio);
		}else if(prb1.isArrayFibonacci(inputArray)){
			System.out.println(inputArray[inputArray.length-1]+inputArray[inputArray.length-2]);
		}else{
			System.out.println(-999);
		}
	}
	
	private boolean isArrayAP(int[] inputArray){
		int size = inputArray.length;
		if(size>2){
			int cmnDiff1=inputArray[size-1]-inputArray[size-2];
			int cmnDiff2=inputArray[1]-inputArray[0];
			if(cmnDiff1==cmnDiff2){
				cmnDiff=cmnDiff2;
			}
			return cmnDiff1==cmnDiff2;
		}else{
			return false;
		}
		
	}
	
	private boolean isArrayGP(int[] inputArray){
		int size = inputArray.length;
		if(size>2){
			try {
				int cmnRatio1 = inputArray[size - 1] / inputArray[size - 2];
				int cmnRatio2 = inputArray[1] / inputArray[0];
				if (cmnRatio1 == cmnRatio2) {
					cmnRatio = cmnRatio2;
				} 
				return cmnRatio1==cmnRatio2;
			} catch (Exception e) {
				return false;
			}
		}else{
			return false;
		}
	}
	
	private boolean isArrayFibonacci(int[] inputArray){
		int size = inputArray.length;
		if(size>2){
			if(inputArray[size-1]==inputArray[size-2]+inputArray[size-3])
				if(inputArray[2]==inputArray[1]+inputArray[0])
					return true;
			return false;
		}else{
			return false;
		}
	}
	
	private void least(){
		int[] leastScoredSubject=new int[5];
		//int[][]
	}
	
}




