/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.tomtom;
* File Name: BinomialCoefficient.java
* Create Date: Nov 21, 2016
* Create Time: 2:03:35 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.tomtom;

import java.math.BigInteger;

/**
 * The binomial coefficient B(N, K) is defined for integers N and K such that 0 <= K <= N as follows:
 * B(N, K) = factorial(N) / (factorial(K) * factorial(N-K))
 * factorial(0) = 1
 * factorial(L) = 1 * 2 * 3 * ... * (L-1) * L if L > 0
 * For example, B(5, 3) = 10, because:
 * B(5, 3) = factorial(5) / (factorial(3) * factorial(2))
 *         = (1*2*3*4*5) / ((1*2*3) * (1*2))
 *         = 120 / (6 * 2)
 *         = 120 / 12
 *         = 10
 * Write a function:
 * class Solution { public int solution(int N, int K); }
 * that, given two integers N and K, returns the value of B(N, K).
 * The function should return -1 if the result exceeds 1,000,000,000.
 * The function should return -1 if the result is undefined.
 * For example, given N = 5 and K = 3 the function should return 10, as explained above. 
 * Given N = 40 and K = 20, the function should return -1, because B(40, 20) exceeds 1,000,000,000 
 * (indeed, B(40, 20) = 137,846,528,820).
 * Given N = 3 and K = 5, the function should return -1, because the result is undefined.
 * Assume that:
 * N and K are integers within the range [-2,147,483,648..2,147,483,647].
 * Complexity:
 * expected worst-case time complexity is O(N*min(K, N-K));
 * expected worst-case space complexity is O(min(K, N-K)).
 * 
 * @author ssikdar
 *
 */
public class BinomialCoefficient {

	public static void main(String[] args) {
		BinomialCoefficient bc = new BinomialCoefficient();
		//int result = bc.solution(5, 3);
		//int result = bc.solution(40, 20);
		int result = bc.solution(3, 5);
		System.out.println(result);
	}
	
	public int solution(int N, int K){
		if(N<K){
			return -1;
		}
		BigInteger Nfact = factorial(new BigInteger(String.valueOf(N)));
		BigInteger Kfact = factorial(new BigInteger(String.valueOf(K)));
		BigInteger NKfact = factorial(new BigInteger(String.valueOf(N-K)));
		BigInteger result = Nfact.divide((Kfact.multiply(NKfact)));
		boolean correct = false;
		if (BigInteger.valueOf(1000000000).compareTo(result) > 0) {
			System.out.println("result INT= " + result);
			correct=true;
		}else if (BigInteger.valueOf(1000000000).compareTo(result) == 0) {
			System.out.println("result INT= " + result);
			correct=false;
		}else{
			System.out.println("result Out= " + result);
			correct=false;
		}
		return correct?result.intValue():-1;
	}
	
	public static BigInteger factorial(BigInteger n) {
	    BigInteger factorial = BigInteger.valueOf(1);
	    for (int i = 1; i <= n.intValue(); i++) {
	        factorial = factorial.multiply(BigInteger.valueOf(i));
	    }
	    return factorial;
	} 
	

}
