/**
 *
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: com.webtual.rytry.utils.varian </p>
 * <p>File Name: Varian.java</p>
 * <p>Create Date: Nov 17, 2014 </p>
 * <p>Create Time: 6:57:06 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.varian;

/**
 * @author Shantanu Sikdar 
 *
 */
public class Varian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		minimumCost(new String[]{"A","B","C","D"}, new int[]{2,3,1,5,4,3});
	}
	
	public static int minimumCost(String[] input1,int[] input2)    {
		int lent =input1.length;		
		int[][] graph = new int[lent][lent];
		
		int p=0;
		for (int k=0;k<lent;k++){			
			for (int j = k; j < lent; j++){
				if(j != k){
					graph[k][j]=input2[p];
					graph[j][k]=input2[p];					
					p++;
				}
			}
		}
		displayAdjMatrix(graph);
		
		int min=0;
		for (int k=0;k<lent;k++){			
			int tmp=0;			
			for (int j = 0; j < lent; j++){
				tmp+=graph[k][j];
			}
			if(k==0)
				min=tmp;
			if(tmp<=min)
				min=tmp;			
		}
		System.out.println(min);
		return 0;
    }
	
	public static void displayAdjMatrix(int[][] adjMat){
		int lent = adjMat.length;
		System.out.println(adjMat.length);
		for (int p = 0; p < lent; p++) {			
			for (int i = 0; i < lent; i++){
				System.out.print(adjMat[p][i]);
			}
			System.out.println();
		}
		
	}

}