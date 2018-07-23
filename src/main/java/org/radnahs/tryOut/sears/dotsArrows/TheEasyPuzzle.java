/**
 * Project: rytry
 * Package Name:package org.radnahs.tryOut.sears.dotsArrows;
 * File Name: TheEasyPuzzle.java
 * Create Date: Oct 23, 2016
 * Create Time: 5:10:37 PM
 * Copyright: Copyright (c) 2016
 * @author: Shantanu Sikdar, ssikdar
 * @version 1.0
 */
package org.radnahs.tryOut.sears.dotsArrows;

import java.util.Arrays;

/**
 * 
 * Given an array of N integers and a prime number K, your task is to find out if LCM 
 * of the whole array is divisible by . Output YES in case it is divisible, NO otherwise.
 * 
 * Input Format
 * First line of the input contains an integer T denoting the number of testcases.
 * First line of each testcase contains two space separated integers N and K.
 * Second line of each testcase contains N integers separated by a single space.
 * 
 * Constraints
 * 1<=T<=5
 * 1<=N,K<=10^5
 * Each integer in the array<=10^6
 *  
 *  Output Format
 *  For each of the testcase, print YES or NO in a separate line.
 *  
 *  Sample Input
 *  
 * 1
 * 3 3
 * 2 3 12
 * 
 * Sample Output
 * YES
 * 
 * Explanation
 * For the given sample test case, LCM of the whole array will be LCM(2,3,12). LCM(2,3,12) can be written as 
 * LCM(2,LCM(3,12)) which evaluates to 12. Since, 12 is divisible be 3, answer is YES
 * 
 * @author ssikdar
 *
 */

public class TheEasyPuzzle {

	public static void main(String[] args) {
		//long gcf1 = gcd(new long[] {9,12,18});
		//long gcf = gcf(new long[] {6,30,18}); 
		//System.out.println(gcf);
		//long lcm = lcm(new long[] {6,30,18});
		long[] larrr = longStringConversion("2 3 9 15");
		long lcm = lcm(larrr);
/*		long[] larrr = longStringConversion("3 3 2");
		for (long l : larrr) {
			System.out.println(l);
		}*/
		/*long lcm = lcm(new long[] {6,9,18});*/
		System.out.println(lcm);
	}
	
	private static long[] longStringConversion(String numLng) {
		  String[] numbers = numLng.split(" ");
		  long[] result = new long[numbers.length];
		  for (int i = 0; i < numbers.length; i++)
		     result[i] = Long.parseLong(numbers[i]);
		  return result;
		}

	private static long gcf(long a, long b) {
		while (b > 0) {
			long temp = b;
			b = a % b; // % is remainder
			a = temp;
		}
		return a;
	}

	private static long gcd(long[] input) {
		long result = input[0];
		for (int i = 1; i < input.length; i++){
			result = gcf(result, input[i]);
		}
		return result;
	}
	
	private static long gcf(long[] input) {
		long result = input[0];
		for (int i = 1; i < input.length; i++){
			while (input[i] > 0) {
				long temp = input[i];
				input[i] = result % input[i]; // % is remainder
				result = temp;
			}
		}
		return result;
	}
	
	
	private static long lcm1(long[] input) {
		int size= input.length;
		long[] input1 = Arrays.copyOf(input, size);
/*		System.out.println("before");
		viewArray(input);
*/		long gcf = gcf(input);
		//System.out.println("after");
		//viewArray(input1);
		long result = input1[size-1]/gcf;
		System.out.println("result = "+result);
		for (int i = size-2; i > -1; i--){
			result=result*input1[i];
		}
		return result;
	}

	
	private static long lcm(long a, long b){
	    return a * (b / gcf(a, b));
	}

	private static long lcm(long[] input){
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) 
	    	result = lcm(result, input[i]);
	    return result;
	}
	
	private static void viewArray(long[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]+", ");
		}
	}
	
	
	
	
	
	
	
	
	
	
	/*private static boolean processInput(String aStr, String bStr) {
        long[] lineOne = longStringConversion(aStr);
        long N= lineOne[0], K = lineOne[1];    
        long[] lineTwo = longStringConversion(bStr);
        long lcm = lcm(lineTwo);
        if(lcm%K==0){
            //System.out.println(lcm);
            return true;
        }
        return false;
        
    }
        
    private static long[] longStringConversion(String numLng) {
		  String[] numbers = numLng.split(" ");
		  long[] result = new long[numbers.length];
		  for (int i = 0; i < numbers.length; i++)
		     result[i] = Long.parseLong(numbers[i]);
		  return result;
	}
    
    private static long gcf(long a, long b) {
		while (b > 0) {
			long temp = b;
			b = a % b; 
			a = temp;
		}
		return a;
	}
    
   	private static long lcm(long a, long b){
	    return a * (b / gcf(a, b));
	}

	private static long lcm(long[] input){
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) 
            result = lcm(result, input[i]);
	    return result;
	}



    public static void main(String[] args) {
         Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. 
        Scanner in = new Scanner(System.in);
        int _a_size = Integer.parseInt(in.nextLine());
        //System.out.println(_a_size);
        for(int _a_i = 0; _a_i < _a_size*2; ) {
            //System.out.println(_a_i);
            String str1 = in.nextLine();
            //System.out.println(str1);
            String str2 = in.nextLine();
            //System.out.println(str2);
            boolean ynVal = processInput(str1, str2);
            if(ynVal)
                System.out.println("YES");
            else
                System.out.println("NO");
            _a_i=_a_i+2;
        }

        
    }
*/
}
