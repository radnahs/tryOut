/**
 * Project: rytry
 * Package Name:package org.radnahs.tryOut.belzabar;
 * File Name: BorderMatrix.java
 * Create Date: Dec 7, 2016
 * Create Time: 3:09:48 PM
 * Copyright: Copyright (c) 2016
 * @author: Shantanu Sikdar, ssikdar
 * @version 1.0
 */
package org.radnahs.tryOut.belzabar;

/**
 * input will be 4 
 * output will be 
 * 4444444 
 * 4333334 
 * 4322234 
 * 4321234 
 * 4322234
 * 4333334
 * 4444444
 * 
 * @author ssikdar
 * 
 */

public class BorderMatrix {

	public static void main(String[] args) {
		BorderMatrix bm = new BorderMatrix();
		bm.matrixPrint(4);
		/*int inpt=3;
		int size = inpt+(inpt-1);
		int[][] intArr={{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};
		bm.display(intArr);
		bm.spiralPrint(size,size,intArr);*/
	}

	public void spiralPrint(int xSize, int ySize, int matrix[][]){
	    int i,  k = 0, l = 0;
	    xSize--;  ySize--;      

	    while(k <= xSize && l <= ySize){
	        for(i = l; i <= ySize; ++i) {
	            System.out.print(matrix[k][i]+ " ");
	        }           
	        k++;
	        for(i = k; i <= xSize; ++i) {
	            System.out.print(matrix[i][ySize] + " ");
	        }
	        ySize--;
	        for(i = ySize; i >= l; --i) {
	                System.out.print(matrix[xSize][i] + " ");
	        }
	        xSize--;
	        for(i = xSize; i >= k; --i) {
	            System.out.print(matrix[i][l] + " ");
	        }
	        l++;
	    }
	}
	
	private void matrixPrint(int inpt){ 
		int size = inpt+(inpt-1);
		int[][] intArr = new int[size][size];
		int i,kS=0,kE=size-1,lS=0,lE=size-1;
		while(inpt>=-1){
			for(i=kS;i<size;i++){
				intArr[kS][i]=inpt;
			}
			kS++;
			
			for(i=kS;i<size;i++){
				intArr[i][lE]=inpt;
			}			
			lE--;
			
			for(i=lE;i>-1;i--){
				intArr[kE][i]=inpt;
			}
			kE--;
					
			for(i=kE;i>kS;i--){
				intArr[i][lS]=inpt;
			}
			lS++;
						
			inpt--;
		}
		display(intArr);
	}
	
	private void display(int[][] intArr){
		int size = intArr.length;
		for(int m=0;m<size;m++){
			for(int n=0;n<size;n++){
				System.out.print(intArr[m][n]);
			}
			System.out.println("");
		}
	}

	
	/*
	 * public void recursionMatrixPrint(int inpt){ if(inpt==1){ return }
	 * 
	 * }
	 */

}
