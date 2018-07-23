package org.radnahs.tryOut.amazon;

/**
 * You are given a string S and a set of n substrings. 
 * You are supposed to remove every instance of those 
 * n substrings from S so that S is of the minimum length 
 * and output this minimum length.
 * Eg: 
 * S- ccdaabcdbb
 * n=2 - substrings-- ab, cd
 * Output: 2
 * Explanation:
 * ccdaabcdbb -> ccdacdbb -> cabb -> cb (length=2)
 * 
 */

public class SubstringRemovalFromString {

	public static void main(String[] args) {
		String str = "ccdaabcdbb";
		System.out.println(str);
		str=str.replace("cd", "");
		System.out.println(str);
		str = str.replace("ab", "");
		System.out.println(str);
	}
	
	private int processStringRemoval(String str, String[] strArr){
		
		return 2;
	}
	
	
}
