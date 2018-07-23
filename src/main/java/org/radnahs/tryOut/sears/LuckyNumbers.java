/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.sears;
* File Name: LuckyNumbers.java
* Create Date: Oct 20, 2016
* Create Time: 7:11:13 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.sears;

import java.math.BigDecimal;

/**
 * A number is called lucky if the sum of its digits, as well as the sum of the squares 
 * of its digits is a prime number. How many numbers between A and B(both inclusive) are lucky?
 * Lucky numbers are not to be confused with Lucky Numbers
 * 
 * Input:
 * The first line contains the number of test cases T. Each of the next T lines contains 
 * two integers, A and B.
 * 
 * Output:
 * Output T lines. Each line contains the required answer for the corresponding test case.
 * 
 * Constraints:
 * 1 <= T <= 10000
 * 1 <= A <= B <= 10^18
 * 
 * Sample Input:
 * 2
 * 1 20 
 * 120 130
 * 
 * Sample Output:
 * 4
 * 1
 * 
 * Explanation:
 * For the first case, the lucky numbers are 11, 12, 14, 16.
 * For the second case, the only lucky number is 120.
 * 
 * @author ssikdar
 *
 */
public class LuckyNumbers {

	public static void main(String[] args) {
		System.out.println("hell ya = " + BigDecimal.valueOf(Math.pow(6, 6)));
		BigDecimal bd = new BigDecimal(Math.pow(9, 9));
		System.out.println(bd);
		System.out.println(luckyNumberRange(1, 20));
		System.out.println(luckyNumberRange(120, 130));
		//System.out.println(luckyNumberRange(990, 1000));
	}
	//774840978+387420489
	
	
	private static long luckyNumberRange(long a, long b){
		long countLckyNmbr=0;
		for(long k =a; k<=b; k++){
			char[] intChr = (k+"").toCharArray();
			long sumA=0, sumB=0;
			for (int m = 0; m < intChr.length; m++) {
				long val =  new Long(String.valueOf(intChr[m]));
				sumA = sumA + val;
				long valSqr = val==0?0:val*val;
				sumB = sumB + valSqr;
			}
			if(isPrimeNumber(sumA)&&isPrimeNumber(sumB) ){
				countLckyNmbr++;
			}
		}
		return countLckyNmbr;
	}
	
	/**
	 * crude method written 
	 * @param a
	 * @param b
	 * @return
	 */
	/*private static long luckyNumberRange1(long a, long b){
		long countLckyNmbr=0;
		for(long k =a; k<=b; k++){
			//System.out.print(k+" = ");
			char[] intChr = (k+"").toCharArray();
			double sumA=0, sumB=0;
			for (int m = 0; m < intChr.length; m++) {
				//System.out.print(String.valueOf(intChr[m])+", ");
				Double val =  new Double(String.valueOf(intChr[m]));
				sumA = sumA + val;
				//Double valSqr = val==0?0:Math.pow(val, val);//written keeping in mind but the velow condition in what is asked
				Double valSqr = val==0?0:Math.pow(val, 2);
				//Double valSqr = Math.pow(val, val);
				sumB = sumB + valSqr;
			}
			//System.out.println(" SumA=" + sumA +" SumB=" + BigDecimal.valueOf(sumB));
			//System.out.println(" is SumA prime=" + isPrimeNumber(sumA) +" is SumB prime=" + isPrimeNumber(sumB));
			if(isPrimeNumber(sumA)&&isPrimeNumber(sumB) ){
				//System.out.print(k+" = ");
				//System.out.println(" SumA=" + sumA +" SumB=" + BigDecimal.valueOf(sumB));
				//System.out.println(" is SumA prime=" + isPrimeNumber(sumA) +" is SumB prime=" + isPrimeNumber(sumB));
				countLckyNmbr++;
			}
		}
		//System.out.println("countLckyNmbr =  "+ countLckyNmbr);
		return countLckyNmbr;
	}*/
	
	private static boolean isPrimeNumber(Long  nmbr){
		if(nmbr==1){
			return false;
		}
        for(int i=2; i<=nmbr/2 ; i++){
            if(nmbr % i == 0){
                return false;
            }
        }
        return true;
    }

}
