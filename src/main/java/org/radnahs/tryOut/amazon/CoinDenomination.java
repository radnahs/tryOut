/**
 * Project: rytry
 * Package Name:package org.radnahs.tryOut.amazon;
 * File Name: CoinDenomination.java
 * Create Date: Jun 29, 2016
 * Create Time: 4:51:56 PM
 * Copyright: Copyright (c) 2016
 * @author: Shantanu Sikdar, ssikdar
 * @version 1.0
 */
package org.radnahs.tryOut.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinDenomination {
	
	private void display1DArray(int[] array1D) {
		for (int i : array1D) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

	static int getCount(int[] A, int S) {
		int num = minCoins(A, A.length, S);
		System.out.println(num);
		return num;
	}

	static int minCoins(int coins[], int m, int V) {
		if (V == 0)
			return 0;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			if (coins[i] <= V) {
				int sub_res = minCoins(coins, m, V - coins[i]);
				if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
					res = sub_res + 1;
			}
		}
		return res;
	}
	
	Map<Integer, Integer> coinDenomMap = new HashMap<Integer, Integer>();
	private void minCoins(int[] coinDenomination, int val){
		System.out.println(val);
		//display1DArray(coinDenomination);
		Arrays.sort(coinDenomination);
		display1DArray(coinDenomination);
		int cnt=0;
		for (int i = coinDenomination.length-1; i > -1; i--) {
			int den = coinDenomination[i];
			if(val > den && val%den>0){
				cnt+=val/den;
				coinDenomMap.put(den, val/den);
				val=val%den;
			}else if(val%den==0){
				cnt+=val/den;
				coinDenomMap.put(den, val/den);
				val=0;
				break;
			}
		}
		System.out.println("Minimum number of coins needed are "+cnt+" of these denomination = "+coinDenomMap);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello amazon");
		//getCount(new int[] { 1, 3, 5, 10 }, 43);
		//getCount(new int[] { 1, 2, 5, 10 }, 53);
		CoinDenomination cd = new CoinDenomination();
		//System.out.println(3%5);
		cd.minCoins(new int[] { 1, 10, 5, 2 }, 4);
		cd.minCoins(new int[] { 1, 10, 5, 2 }, 154);
		cd.minCoins(new int[] { 1, 10, 5, 2 }, 43);
		cd.minCoins(new int[] { 1, 10, 5, 2 }, 18);
	}
}
