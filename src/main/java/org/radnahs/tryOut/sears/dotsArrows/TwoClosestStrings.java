/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.sears.dotsArrows;
* File Name: TwoClosestStrings.java
* Create Date: Oct 23, 2016
* Create Time: 6:17:50 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.sears.dotsArrows;

import java.util.Scanner;

/**
 * Given a string A of length N and an integer K, find the lexicographically 
 * smallest string B of the same length as A such that hamming distance between A and B is exactly K.
 * 
 * Note 
 * The final string  should have lowercase alphabetic characters.
 * 
 * Input Format
 * First line of the input contains T denoting the number of test cases. 
 * First and the only line of every test case contains a string A and an integer K separated by a single space.
 * 
 * Constraints
 * 1<=T,N,K<=10^5
 * 1<=K<=N
 * Sum of lengths of strings over all testcases does not exceed 10^5
 * A consists of lowercase alphabetic characters
 * 
 * Output Format
 * For each testcase, output the lexicographically smallest string B
 * such that hamming distance between A and B is exactly K.
 * 
 * Sample Input
 * 2
 * pqrs 1
 * pqrs 2
 * 
 * Sample Output
 * aqrs
 * aars
 * 
 * Explanation
 * For the first sample test case i.e given string A as pqrs and the required hamming distance to be 1, 
 * then the smallest lexicographically string that can be produced which has hamming distance 1 from A, will be aqrs.
 * 
 * @Shantanu Sikdar 
 */

public class TwoClosestStrings {

	//a=97, z=122
	public static void main(String[] args) {
		closestHamming("pqrs 1".toLowerCase());
		closestHamming("pqrs 2");
		closestHamming("aasrtz 1");
		closestHamming("aasrutz 3");//aaarutz->aaaratz->aaaaatz
		
	}
	
	/*2
	aasrtz 1
	pqrs 2*/
	
	private static void closestHamming(String ss ){
		Scanner in = new Scanner(System.in);
		String[] strh = ss.split(" ");
		int k= Integer.parseInt(strh[1]);
		char[] chrArrStr = strh[0].toCharArray();
		int p=0;
		for(int i = 0; i<chrArrStr.length-2;i++){
			int m = chrArrStr[i];
			int n = chrArrStr[i+1];
			if(m>n){
				chrArrStr[i]='a';
				p++;i=0;
				if(k==p){
					break;
				}
			}
		}
		System.out.println(p+" "+k);
		for(int j = 0; p<k && j<k;j++){
			int m = chrArrStr[j];
			if(m==97){
				chrArrStr[j]='b';
				p++;
			}else{
				chrArrStr[j]='a';
				p++;
			}
			
		}
		System.out.println(p+" "+k);
		System.out.println(String.valueOf(chrArrStr));
	}
	
	private static void closestHamming1(String ss ){
		Scanner in = new Scanner(System.in);
		String[] strh = ss.split(" ");
		int k= Integer.parseInt(strh[1]);
		char[] chrArrStr = strh[0].toCharArray();
		for(int i = 0; i<k;i++){
			/*int m = chrArrStr[i];
			System.out.println(m+" "+chrArrStr[i] );
			char cc = ++chrArrStr[i];
			System.out.println(cc);*/
			int m = chrArrStr[i];
			if(m==122){
				
			}else if(m==97){
				
			}else{
				chrArrStr[i]='a';
			}
		}
		System.out.println(String.valueOf(chrArrStr));
		
	}
	
	/*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int _a_size = Integer.parseInt(in.nextLine());
        for(int _a_i = 0; _a_i < _a_size; _a_i++ ) {
            String str1 = in.nextLine();
            subsequence(str1);
        }    
    }*/
	

}
