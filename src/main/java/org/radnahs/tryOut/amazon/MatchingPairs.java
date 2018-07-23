/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.amazon;
* File Name: MatchingPairs.java
* Create Date: Jul 5, 2016
* Create Time: 7:06:06 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.amazon;

/**
 * 
 * Check out the resources on the page's right side to learn more about stacks. 
 * The video tutorial is by Gayle Laakmann McDowell, author of the best-selling interview book Cracking the Coding Interview.
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 * 
 * Two brackets are considered to be a matched pair if the an opening bracket 
 * (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. 
 * There are three types of matched pairs of brackets: [], {}, and ().
 * 
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. 
 * For example, {[(])} is not balanced because the contents in between { and } are not balanced. 
 * The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of 
 * parentheses encloses a single, unbalanced closing square bracket, ].
 * 
 * By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:
 * 
 * 		It contains no unmatched brackets.
 * 		The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 * 
 * Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, 
 * print YES on a new line; otherwise, print NO on a new line.
 * 
 * Input Format
 * 
 * The first line contains a single integer, , denoting the number of strings.
 * Each line  of the  subsequent lines consists of a single string, , denoting a sequence of brackets.
 * 
 * Constraints
 * 		1<=n<=10^3
 * 		1<=length(s)<=10^3, where length(s) is the length of the sequence.
 * 		Each character in the sequence will be a bracket (i.e., {, }, (, ), [, and ]). 
 * 
 * Output Format
 * 
 * For each string, print whether or not the string of brackets is balanced on a new line. 
 * If the brackets are balanced, print YES; otherwise, print NO.
 * 
 * Sample Input
 * 
 * 3
 * {[()]}
 * {[(])}
 * {{[[(())]]}}
 * 
 * Sample Output
 * YES
 * NO
 * YES
 * 
 * Explanation
 * The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
 * The string {[(])} is not balanced, because the brackets enclosed by the matched pairs [(] and (]) 
 * are not balanced. Thus, we print NO on a new line.
 * 
 * sThe string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MatchingPairs {
	
	
	public static void main(String[] args) {
		System.out.println(isBalanced("[{()}]"));
		System.out.println(isBalanced("{[(])}"));
	}
	
	 public static boolean isBalanced(String expression) {
		 if (expression.isEmpty())
			 return true;
	    Stack<Character> stack = new Stack<Character>();
	    for (int i = 0; i < expression.length(); i++){
	        char current = expression.charAt(i);
	        if (current == '{' || current == '(' || current == '['){
	            stack.push(current);
	        }
	        if (current == '}' || current == ')' || current == ']')		        {
	            if (stack.isEmpty())
	                return false;
	            char last = stack.peek();
	            if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
	                stack.pop();
	            else 
	                return false;
	        }
	    }
	    return stack.isEmpty();
	 }
	
	private static boolean braceMatcher(String input){
		boolean isBool=false;
		char[] chrArr = input.toCharArray();
		for (int i = 0, j = chrArr.length-1 ; i < j; i++,j--) {
			if(chrArr[i]=='['){
				isBool = chrArr[j]==']'?true:false;
			}else if(chrArr[i]=='{'){
				isBool = chrArr[j]=='}'?true:false;
			}else if(chrArr[i]=='('){
				isBool = chrArr[j]==')'?true:false;
			}/*else{
				break;
			}*/
			//System.out.println(chrArr[i] + " " + isBool);
		}
		return isBool;
	}
	

	public static void main1(String[] args) {
		String input="{adad[{ad[ad}as()dasd{asda]d]";
		System.out.println(isMatchingBraces(input));
		input="{}()";
		System.out.println(isMatchingBraces(input));
		input="((})[]{)";
		System.out.println(isMatchingBraces(input));
		input="{[(])}";
		System.out.println(isMatchingBraces(input));
		/*input="[]";
		System.out.println(isMatchingBraces(input));*/
	}
	
	static private boolean isMatchingBraces(String str){
		char[] chrArr = str.toCharArray();
		boolean isMatch = false;
		Map<Character, List<Integer>> mapChar = new HashMap<Character, List<Integer>>();
		for (int i=0;i<chrArr.length;i++) {
			if(chrArr[i]=='{'){
				buildCharStructure(mapChar,'{',i);
			}else if(chrArr[i]=='}'){
				buildCharStructure(mapChar,'}',i);
			}else if(chrArr[i]=='['){
				buildCharStructure(mapChar,'[',i);
			}else if(chrArr[i]==']'){
				buildCharStructure(mapChar,']',i);
			}else if(chrArr[i]=='('){
				buildCharStructure(mapChar,'(',i);
			}else if(chrArr[i]==')'){
				buildCharStructure(mapChar,')',i);
			}
		}
		System.out.println(mapChar);
		int[] isBool = {0,0,0};//new int[3];
		if(mapChar.containsKey('[') && mapChar.containsKey(']')){
			if(checkBracePair(mapChar, '[', ']')){
				isBool[0]=2;
			}else{
				isBool[0]=1;
			}			
		}else if(mapChar.containsKey('[') || mapChar.containsKey(']')){
			isBool[0]=1;
		}
		if(mapChar.containsKey('(') && mapChar.containsKey(')')){
			if(checkBracePair(mapChar, '(', ')')){
				isBool[1]=2;
			}else{
				isBool[1]=1;
			}
		}else if(mapChar.containsKey('(') || mapChar.containsKey(')')){
			isBool[1]=1;
		}
		if(mapChar.containsKey('{') && mapChar.containsKey('}')){
			if(checkBracePair(mapChar, '{', '}')){
				isBool[2]=2;
			}else{
				isBool[2]=1;
			}
		}else if(mapChar.containsKey('{') || mapChar.containsKey('}')){
			isBool[2]=1;
		}
		for(int ib : isBool){
			if(ib==1){
				isMatch=false;
				break;
			}else{
				isMatch=true;
			}				
		}
		System.out.println("final "+isMatch);
		return isMatch;
	}
	
	private static void buildCharStructure(Map<Character, List<Integer>> mapChahr, Character chr, Integer i){
		List<Integer> lst = new ArrayList<>();
		lst = (List<Integer>) (mapChahr.get(chr)!=null?mapChahr.get(chr):new ArrayList<>());
		lst.add(i);
		mapChahr.put(chr, lst);
	}
	
	private static boolean checkBracePair(Map<Character, List<Integer>> mapChar, Character chr1, Character chr2){
		boolean isMatch = false;
		if(mapChar.containsKey(chr1) && mapChar.containsKey(chr2)){
			if(mapChar.get(chr1).size()==mapChar.get(chr2).size()){
				isMatch = true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		return isMatch;
	}
	
}
