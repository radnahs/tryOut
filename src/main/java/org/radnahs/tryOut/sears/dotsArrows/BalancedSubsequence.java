/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.sears.dotsArrows;
* File Name: BalancedSubsequence.java
* Create Date: Oct 23, 2016
* Create Time: 6:26:32 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.sears.dotsArrows;

import java.util.Stack;

/**
 * Given a string S, find the length of longest balanced subsequence in it. 
 * A balanced string is defined as :-
 * 1. A Null string is a balanced string.
 * 2. If X and Y are balanced strings, then (X)Y and XY are balanced strings.
 * 
 * Input Format
 * First line of the input contains an integer T denoting the number of test cases.
 * Next T lines will contain a string S.
 * 
 * Constraints
 * 1<=T<=10
 * 1<=|S|<=300
 * S consists of '(' and ')' only.
 * 
 * Output Format
 * For each test case, print a single line containing the length of longest balanced subsequence.
 * 
 * Sample Input
 * 3
 * ()())
 * ))))(((
 * ()(((((()
 * 
 * Sample Output
 * 4
 * 0
 * 4
 * 
 * Explanation
 * In first and third sample case, ()() is the longest balanced subsequence of length 4. 
 * 
 * @author ssikdar
 *
 */


public class BalancedSubsequence {

	
	public static int isSubsequence(String expression) {
		int subsqnce=0;
		 /*if (expression.isEmpty())
			 return true;*/
	    Stack<Character> stack = new Stack<Character>();
	    for (int i = 0; i < expression.length(); i++){
	        char current = expression.charAt(i);
	        if (current == '(' ){
	            stack.push(current);
	        }
	        if (current == ')' ){
	            /*if (stack.isEmpty())
	                return false;*/
	            char last = stack.peek();
	            if (current == ')' && last == '('){
	                stack.pop();
	                subsqnce+=2;
	            }/*else{ 
	                return false;
	            }*/
	        }
	    }
	    //return stack.isEmpty();
	    return subsqnce;
	 }
	
	
	public static void main(String[] args) {
		System.out.println(isSubsequence("()())"));
		isSubsequence("))))(((");
		isSubsequence("()(((((()");
	}
	
	/*private static void subsequence(String str){
		char[] chrStrArr = str.toCharArray();
		int size = chrStrArr.length;
		int subsqn=0;
		for (int i = 0; i < size-1 ; i++) {
			if(chrStrArr[i]=='(' && chrStrArr[i+1]==')'){
				subsqn=subsqn+2;
				i++;
			}
		}
		System.out.println(subsqn);
	}*/
	
	/*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int _a_size = Integer.parseInt(in.nextLine());
        for(int _a_i = 0; _a_i < _a_size; _a_i++ ) {
            String str1 = in.nextLine();
            subsequence(str1);
        }    
    }*/
	

}
