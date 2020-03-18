/**
 * <p>Project: tryout </p>
 * <p>Package Name: com.shandar.tryout.aqr </p>
 * <p>File Name: RearrangeTheSentence.java </p>
 * <p>Create Date: 26-Jan-2020 </p>
 * <p>Create Time: 10:06:31 am </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package com.shandar.tryout.aqr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * codewriting 
 * You are given a string sentence representing a valid sentence. A valid
 * sentence consists of words separated by single-spaces, ending with a period.
 * Each word contains only latin letters. The first word in the sentence always
 * starts with capital letter, and all others are lowercase. 
 * 
 * In other words, a sentence is a string matching the regex ^[A-Z][a-z]*( [a-z]+)*\.$. 
 * 
 * Your task is to rearrange the words in the sentence in ascending order of their length.
 * 
 * In the case of a tie, the words should be ordered according to their relative
 * order in the initial sentence. The final sequence should be formatted to be a
 * valid sentence as well (ie: match the regex ^[A-Z][a-z]*( [a-z]+)*\.$).
 * 
 * Example 
 * For sentence = "Houston we have a problem.", the output should be
 * rearrangeTheSentence(sentence) = "A we have houston problem.". 
 * In this case there are no ties, so we simply rearrange the words in ascending 
 * order of length. We'll need to capitalize the first letter of the first word ("A"),
 * and uncapitalize the first letter of "Houston" in order to match the sentence
 * format. 
 * 
 * For sentence = "I love to code.", the output should be 
 * rearrangeTheSentence(sentence) = "I to love code.". The words "love" and
 * "code" have the same length, so we'll keep them in the relative order in
 * which they originally appeared. 
 * 
 * For sentence = "Ok is ok.", the output should be rearrangeTheSentence(sentence) = "Ok is ok.". 
 * Since all of the words are of the same length, this sentence does not change 
 * at all. 
 * 
 * For sentence = "It is the hottest sun in the beach.", the output should be
 * rearrangeTheSentence(sentence) = "It is in the sun the beach hottest.". Since
 * this sentence began with the shortest-length word already, no capitalization
 * changes will be required, but some of the words are rearranged. 
 * 
 * Input/Output
 * [execution time limit] 3 seconds (java) [input] string sentence A string
 * beginning with a capital letter, ending with a period, and containing only
 * lowercase letters and spaces in between. Guaranteed constraints: 2 ≤
 * sentence.length ≤ 105. [output] string The resulting sentence after the
 * transformation described above. [Java] Syntax Tips // Prints help message to
 * the console // Returns a string // // Globals declared here will cause a
 * compilation error, // declare variables inside the function instead! String
 * helloWorld(String name) { System.out.println("This prints to the console when
 * you Run Tests"); return "Hello, " + name; }
 * 
 * @author : Shantanu Sikdar
 * 
 *
 */
public class RearrangeTheSentence {

	public static void main(String[] args) {
		RearrangeTheSentence rts = new RearrangeTheSentence();
		//rts.rearrangeSentenceUsingMap("Houston we have a problem.");
		//rts.rearrangeSentenceUsingMap("I love to code.");
		rts.rearrangeSentenceUsingMap("It is the hottest sun in the beach.");
		rts.rearrangeSentenceUsingSelectionSort("It is the hottest sun in the beach.");
	}
	
	private String rearrangeSentenceUsingSelectionSort(String inpt) {
		String[] strArr = inpt.split(" ");
		StringBuffer btrBffr = new StringBuffer();
		int out, in, min;
		for (out = 0; out < strArr.length-1; out++) {
			min=out;
			for (in = out+1; in < strArr.length; in++) {
				if (strArr[in].length() < strArr[min].length()) {
					min = in;
				}
			}
			swap(strArr, out, min);
			btrBffr.append(strArr[out]+" ");
		}
		System.out.println(btrBffr.toString());
		return btrBffr.toString();
	}
	
	private void swap(String[] strArr, int one, int two) {
		String tmp = strArr[one];
		strArr[one] = strArr[two];
		strArr[two] = tmp;
	}
	
	private String rearrangeSentenceUsingMap(String inpt){
		String[] strArr = inpt.split(" ");
		Map<Integer, List<String>> mapLst = new HashMap<Integer, List<String>>();
		for(String str : strArr) {
			if(mapLst.containsKey(str.length())) {
				List<String> strLst = mapLst.get(str.length());
				strLst.add(str);
				mapLst.put(str.length(), strLst);
			}else {
				List<String> strLst = new ArrayList<String>();
				strLst.add(str);
				mapLst.put(str.length(), strLst);
			}
		}
		System.out.println(mapLst);
		int i=0;
		for(Map.Entry<Integer, List<String>> entMap: mapLst.entrySet()) {
			System.out.println(entMap.getKey() + ""  + entMap.getValue());
			StringBuffer strBffr = new StringBuffer();
			for (int j = 0; j < entMap.getValue().size(); j++) {
				strBffr.append(entMap.getValue().get(j));
				
			}
		}
		
		return null;
	}

}
