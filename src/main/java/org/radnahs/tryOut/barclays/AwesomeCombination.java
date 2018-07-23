/**
* Project: tryOut
* Package Name:package org.radnahs.tryOut.barclays;
* File Name: AwesomeCombination.java
* Create Date: Feb 15, 2017
* Create Time: 4:09:09 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.barclays;

/**
 * Problem description:-https://en.wikipedia.org/wiki/Bell_triangle
 * 
 * @author Shantanu Sikdar
 * 
 */
public class AwesomeCombination {

	public static void main(String[] args) {
		int N=3;
		int X=1,Y=1,Z=1;
		//int[] arr = new int[4];
		//List<Integer[]> arrList=new ArrayList<Integer[]>();
		for (int A=0; A <= X; A++) {
			for (int B=0; B <= Y; B++) {
				for (int C=0; C <= Z; C++) {
					//Integer[] arr = new Integer[3];
					if(A+B+C<N){
						//System.out.println("success A = "+ A + " B ="+ B + " C ="+C);
						//arr[0]=A; arr[1]=B; arr[2]=C;
						//arrList.add(arr);
						System.out.println("["+A+", "+B+", "+C+"]");
					}
				}
			}
		}
		
		/*for (Integer[] arrInt:arrList) {
			//System.out.println(arrList);
			System.out.println("[");
			for (int i = 0; i < arrInt.length; i++) {
				System.out.print(arrInt[i]);
			}
			System.out.println("]");
		}*/
		
	}

}
