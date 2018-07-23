/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.tomtom;
* File Name: WordMachineStackOfIntegers.java
* Create Date: Aug 30, 2016
* Create Time: 12:47:57 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.tomtom;

import java.util.Stack;

/**
 * 
A word machine is a system that performs a sequence of simple operations on a stack of integers. 
Initially the stack is empty. The sequence of operations is given as a string. Operations are 
separated by single spaces. The following operations may be specified:
 an integer X (between 0 and 2 20 − 1): the machine pushes X onto the stack;
POP: the machine removes the topmost number from the stack;
DUP: the machine pushes a duplicate of the topmost number onto the stack;
+ : the machine pops the two topmost elements from the stack, adds them together and pushes the sum onto the stack;
- : the machine pops the two topmost elements from the stack, subtracts the second one from the first (topmost) 
	one and pushes the difference onto the stack.

After processing all the operations, the machine returns the topmost value from the stack.
The machine processes 20-bit unsigned integers (numbers between 0 and 2 20 − 1). An overflow in 
addition or underflow in subtraction causes an error. The machine also reports an error when it 
tries to perform an operation that expects more numbers on the stack than the stack actually contains. 
Also, if, after performing all the operations, the stack is empty, the machine reports an error.

For example, 
given a string "13 DUP 4 POP 5 DUP + DUP + - ", the machine performs the following operations:
operation | comment             | stack
 --------------------------------------------------
            |                     | [empty]
 "13"       | push 13             |
            |                     | 13
 "DUP"      | duplicate 13        |
            |                     | 13, 13
 "4"        | push 4              |
            |                     | 13, 13, 4
 "POP"      | pop 4               |
            |                     | 13, 13
 "5"        | push 5              |
            |                     | 13, 13, 5
 "DUP"      | duplicate 5         |
            |                     | 13, 13, 5, 5
 "+"        | add 5 and 5         |
            |                     | 13, 13, 10
 "DUP"      | duplicate 10        |
            |                     | 13, 13, 10, 10
 "+"        | add 10 and 10       |
            |                     | 13, 13, 20
 "-"        | subtract 13 from 20 |
            |                     | 13, 7
Finally, the machine will return 7.
Given a string "5 6 + -", the machine reports an error, since, after the addition, there is 
only one number on the stack, but the subtraction operation expects two.
Given a string "3 DUP 5 - -", the machine reports an error, since the second subtraction yields a negative result.
Write a function: 
	class Solution { 
		public int solution(String S); 
	}
that, given a string S containing a sequence of operations for the word machine, returns the result 
the machine would return after processing the operations. The function should return −1 if the 
machine would report an error while processing the operations. 
For example, given string S = " 13 DUP 4 POP 5 DUP + DUP + -" the function should return 7, 
as explained in the example above. Given string S = "5 6 + -" or S = " 3 DUP 5 - -" the function should return −1
Assume that:
the length of S is within the range [0 .. 2,000];
S is a valid sequence of word machine operations.

In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

 * @author ssikdar
 *
 */

public class WordMachineStackOfIntegers {

	public static void main(String[] args) {
		WordMachineStackOfIntegers ct = new WordMachineStackOfIntegers();
		System.out.println(ct.solution("13 DUP 4 POP 5 DUP + DUP + - "));
		System.out.println(ct.solution("5 6 + -"));
		System.out.println(ct.solution("3 DUP 5 - -"));
	}
	
	public int solution(String S){
		String[] strArr = S.split("\\s");
		System.out.println("len = "+strArr.length);
		Stack<String> stkStr =  new Stack<>();
		int retrn = -1;
		try {
			for (String string : strArr) {
				//System.out.println(string);
				if (string.equalsIgnoreCase("POP")) {
					stkStr.pop();
				} else if (string.equalsIgnoreCase("DUP")) {
					String strDup = stkStr.pop();
					stkStr.push(strDup);
					stkStr.push(strDup);
				} else if (string.equalsIgnoreCase("+")) {
					int kA = Integer.parseInt(stkStr.pop());
					int lA = Integer.parseInt(stkStr.pop());
					int mA = kA + lA;
					stkStr.push(mA + "");
				} else if (string.equalsIgnoreCase("-")) {
					int kS = Integer.parseInt(stkStr.pop());
					int lS = Integer.parseInt(stkStr.pop());
					int mS = kS - lS;
					stkStr.push(mS + "");
				} else {
					stkStr.push(string);
				}
			}
			int t = Integer.parseInt(stkStr.pop());
			retrn=t>-1?t:-1;
		} catch (Exception e) {
			retrn=-1;
		}
		//System.out.println(stkStr);
		return retrn ;
	}

}
