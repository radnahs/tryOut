/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.chubb </p>
 * <p>File Name: EscapePrisonGate.java</p>
 * <p>Create Date: 26-Feb-2021 </p>
 * <p>Create Time: 9:21:21 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.chubb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Shantanu Sikdar
 * @for : Mahesh Thakur @: HackerRank
 * @link :
 *       https://www.chegg.com/homework-help/questions-and-answers/prisoner-planning-escape-prison-prison-s-gate-consists-horizontal-vertical-bars-spaced-one-q54963882
 * 
 */
public class EscapePrisonGate {

	public static void main(String[] args) {
		System.out.println("Test" + EscapePrisonGate.class.getDeclaredMethods()[0]);
		List<Integer> h = new ArrayList<Integer>();
		h.add(1);
		h.add(2);
		List<Integer> v = new ArrayList<Integer>();
		v.add(1);
		v.add(2);
		System.out.println(solution1(3, 3, h, v));
	}

	public static long solution1(int n, int m, List<Integer> h, List<Integer> v) {

		Integer[] h1 = new Integer[h.size()];
		for (int i = 0; i < h.size(); i++) {
			h1[i] = h.get(i);
		}

		Integer[] v1 = new Integer[v.size()];
		for (int i = 0; i < v.size(); i++) {
			v1[i] = v.get(i);
		}

		List<List<Long>> prison = new ArrayList<List<Long>>();
		for (int r = 0; r <= n; r++) {
			List<Long> temp = new ArrayList<Long>();
			for (int c = 0; c <= m; c++) {
				temp.add((long) 1);
			}
			prison.add(temp);
		}

		Integer[] x = h1;
		int xnum = x.length;
		Arrays.sort(x);

		Integer[] y = v1;
		int ynum = y.length;
		Arrays.sort(y);

		// removing bar i means that list at i-1 and at i
		for (int a = xnum - 1; a >= 0; a--) {
			int i = x[a];
			for (int cell = 0; cell < prison.get(i).size(); cell++) {
				prison.get(i).set(cell, prison.get(i).get(cell) + prison.get(i - 1).get(cell));
			}
			prison.remove(i - 1);
		}

		List<List<Long>> newprison = new ArrayList<List<Long>>();

		for (int col = 0; col < prison.get(0).size(); col++) {
			List<Long> temp = new ArrayList<Long>();
			for (int row = 0; row < prison.size(); row++) {
				temp.add(prison.get(row).get(col));
			}
			newprison.add(temp);
		}

		for (int b = ynum - 1; b >= 0; b--) {
			int i = y[b];
			for (int cell = 0; cell < newprison.get(i).size(); cell++) {
				newprison.get(i).set(cell, newprison.get(i).get(cell) + newprison.get(i - 1).get(cell));
			}
			newprison.remove(i - 1);
		}

		long max = 1;
		for (List<Long> arr : newprison) {
			for (long num : arr) {
				if (num > max)
					max = num;
			}
		}
		return max;

	}

}
