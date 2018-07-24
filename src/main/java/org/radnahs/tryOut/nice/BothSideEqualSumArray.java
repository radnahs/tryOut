/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.nice </p>
 * <p>File Name: BothSideEqualSumArray.java</p>
 * <p>Create Date: Feb 1, 2016 </p>
 * <p>Create Time: 8:09:59 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.nice;

/**
 * @author Shantanu Sikdar 
 *
 */
public class BothSideEqualSumArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bool = isBothSideEqual(new int[]{3,7,13,10,15,8});
		System.out.println(bool);
		bool = isBothSideEqual(new int[]{19,7,1,10,1,7});
		System.out.println(bool);
		bool = isBothSideEqual(new int[]{17,7,-1,10,1,7});
		System.out.println(bool);
		bool = isBothSideEqual(new int[]{17,-7,-1,10,1,7,-7});//need to test this condition
		System.out.println(bool);
	}
	
	private static boolean isBothSideEqual(int[] intArr){
		int size = intArr.length;
		for(int i=0; i<intArr.length;i++){
			int leftSum=0, rightSum=0;
			for (int j=0, k=size-1; j <i || k>i ; j++, k--) {
				if(j <i){
					leftSum+=intArr[j];
				}
				if(k>i){
					rightSum+=intArr[k];
				}
				if(leftSum==rightSum){
					System.out.println(intArr[i]+" -- " +i );
					return true;
				}
			}
		}
		return false;
	}

}
