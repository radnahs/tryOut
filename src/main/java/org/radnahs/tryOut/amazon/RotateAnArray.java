/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.amazon;
* File Name: RotateAnArray.java
* Create Date: Jun 30, 2016
* Create Time: 12:42:59 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.amazon;

public class RotateAnArray {

	public static void main(String[] args) {
		int[] a = arrayLeftRotation(new int[]{1,2,3,4,5}, 5, 4);//
		for (int i : a) {
			System.out.print(i+",");
		}
	}
	
	/**
	 * Check out the resources on the page's right side to learn more about arrays. The video tutorial 
	 * is by Gayle Laakmann McDowell, author of the best-selling interview book Cracking the Coding Interview.
	 * A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. 
	 * For example, if left rotations are performed on array , then the array would become .
	 * 
	 * Given an array of  integers and a number, , perform  left rotations on the array. 
	 * Then print the updated array as a single line of space-separated integers.
	 * 
	 * Input Format
	 * The first line contains two space-separated integers denoting the respective values of  
	 * (the number of integers) and  (the number of left rotations you must perform).
	 * The second line contains  space-separated integers describing the respective elements 
	 * of the array's initial state.
	 * 
	 * Constraints
	 * 
	 * Output Format
	 * Print a single line of  space-separated integers denoting the final state of 
	 * the array after performing  left rotations.
	 * 
	 * Sample Input
	 * 5 4
	 * 1 2 3 4 5
	 * 
	 * Sample Output
	 * 5 1 2 3 4
	 * Explanation
	 * When we perform  left rotations, the array undergoes the following sequence of changes:
	 * 
	 * Thus, we print the array's final state as a single line of space-separated 
	 * values, which is 5 1 2 3 4.
	 * 
	 * 
	 * @param a
	 * @param n
	 * @param k
	 * @return
	 */
	
	public static int[] arrayLeftRotation(int[] a, int n, int k) {
		int[] newArr = new int[n];		
		for(int i=0; i<n;i++){
			int index = Math.abs(n+i-k)<n?Math.abs(n+i-k):Math.abs(i-k); 
			newArr[index]=a[i];
		}		
		return newArr;
    }
	
	private void rotate(int[][] matrix, int n){
		int[][] newMtrx = matrix;
		
	}
	

	private static void rotateMatrixClockwise(int m, int n, String mat[][]) {
		int row = 0, col = 0;
		String prev, curr;
		/*
		 * row - Staring row index m - ending row index col - starting column
		 * index n - ending column index i - iterator
		 */
		while (row < m && col < n) {
			if (row + 1 == m || col + 1 == n)
				break;
			// Store the first element of next row, this
			// element will replace first element of current
			// row
			prev = mat[row + 1][col];
			/* Move elements of first row from the remaining rows */
			for (int i = col; i < n; i++) {
				curr = mat[row][i];
				mat[row][i] = prev;
				prev = curr;
			}
			row++;
			/* Move elements of last column from the remaining columns */
			for (int i = row; i < m; i++) {
				curr = mat[i][n - 1];
				mat[i][n - 1] = prev;
				prev = curr;
			}
			n--;

			/* Move elements of last row from the remaining rows */
			if (row < m) {
				for (int i = n - 1; i >= col; i--) {
					curr = mat[m - 1][i];
					mat[m - 1][i] = prev;
					prev = curr;
				}
			}
			m--;
			/* Move elements of first column from the remaining rows */
			if (col < n) {
				for (int i = m - 1; i >= row; i--) {
					curr = mat[i][col];
					mat[i][col] = prev;
					prev = curr;
				}
			}
			col++;
		}
		//display(mat);
	}

}
