/**
 * 
 * 
 */
package org.radnahs.tryOut.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * A binary gap within a positive integer N is any maximal sequence of
 * consecutive zeros that is surrounded by ones at both ends in the binary
 * representation of N.
 * 
 * For example, number 9 has binary representation 1001 and contains a binary
 * gap of length 2. The number 529 has binary representation 1000010001 and
 * contains two binary gaps: one of length 4 and one of length 3. The number 20
 * has binary representation 10100 and contains one binary gap of length 1. The
 * number 15 has binary representation 1111 and has no binary gaps. The number
 * 32 has binary representation 100000 and has no binary gaps.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int N); }
 * 
 * that, given a positive integer N, returns the length of its longest binary
 * gap. The function should return 0 if N doesn't contain a binary gap.
 * 
 * For example, given N = 1041 the function should return 5, because N has
 * binary representation 10000010001 and so its longest binary gap is of length
 * 5. Given N = 32 the function should return 0, because N has binary
 * representation '100000' and thus no binary gaps.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..2,147,483,647].
 * 
 * @author G01157921
 *
 */
public class BinaryGap {

	public static void main(String[] args) {
		int intVal = 10410; //529;
		System.out.println(Integer.toBinaryString(intVal));

		usingJava8Way(intVal);
		priorToJava8(intVal);
	}

	private static void priorToJava8(int intVal) {
		char[] intChrArr = Integer.toBinaryString(intVal).toCharArray();
		int count = 0;
		List<String> strLst = new ArrayList<String>();
		for (char c : intChrArr) {
			if ((c + "").equalsIgnoreCase("1")) {
				int temp = count;
				count = 0;
				strLst.add(temp + "");
			} else {
				count++;
			}
		}
		//System.out.println(strLst);
		int max = Integer.valueOf(Collections.max(strLst));
		System.out.println(max);
	}

	private static void usingJava8Way(int intVal) {
		Character[] intChrArr = Integer.toBinaryString(intVal).chars().mapToObj(chr -> (char)chr).toArray(Character[]::new);
		int[] count = new int[1];
		List<String> strLst = new ArrayList<String>();
		Arrays.stream(intChrArr).forEach(elem -> {
			if ((elem + "").equalsIgnoreCase("1")) {
				int temp = count[0];
				count[0] = 0;
				strLst.add(temp + "");
			} else {
				count[0]++;
			}
		});
		//System.out.println(strLst);
		int max = Integer.valueOf(Collections.max(strLst));
		System.out.println(max);

	}

}
