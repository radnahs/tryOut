/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: com.webtual.tryOut.utils.tests.ptc </p>
 * <p>File Name: NumToWord.java</p>
 * <p>Create Date: Jun 22, 2014 </p>
 * <p>Create Time: 3:32:23 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ptc;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Shantanu Sikdar 
 *
 */
public class NumToWord {

	private static final char keys[][]={
	      {'0','0','0'},
	      {'1','1','1'},
	      {'A','B','C'},
	      {'D','E','F'},
	      {'G','H','I'},
	      {'J','K','L'},
	      {'M','N','O'},
	      {'P','R','S'},
	      {'T','U','V'},
	      {'W','X','Y'}
	  };
	      
	  
	  private static final char getCharKey(int telephoneKey,int place){
	    if(place <1 || place >3) throw new IllegalArgumentException("Argument 'place' is between 1-3 (both inclusive)");
	    if(telephoneKey <0 || telephoneKey >9) throw new IllegalArgumentException("Argument 'telephoneKey' is between 0-9 (both inclusive)");
	   	
	    return keys[telephoneKey][place-1]; 
	  }
	  
	 static private void teleNumWords(int[] teleNum){
		 TreeSet<String> ts = new TreeSet<>(); 		  
		 for(int k=0;k<3;k++){
			 //StringBuilder telNum = new StringBuilder();
			 List<Character> charLst = new ArrayList<Character>();
			 for (int i = 0; i < teleNum.length; i++) {
				 int j = teleNum[i];
				 char c = getCharKey(j,k+1);
				 charLst.add(getCharKey(j,k+1));
			 }		
			 System.out.println(charLst);
		 }		  		  
	  
	 }
	 
	 
	 static private void teleNumWords1(int[] teleNum){
		 TreeSet<String> ts = new TreeSet<>(); 		  
		 for (int i = 0; i < teleNum.length; i++) {
			 //StringBuilder telNum = new StringBuilder();
			 List<Character> charLst = new ArrayList<Character>();
			 for(int k=0;k<3;k++){
				 int j = teleNum[i];
				 char c = getCharKey(j,k+1);
				 charLst.add(getCharKey(j,k+1));
			 }		
			 System.out.println(charLst);
			 //combinationWithoutRepetition(7,i,i+"",charLst);
		 }		  		  
	  }
	 
	 private static String combinationWithoutRepetition(int n, int index, String prefix, List<Character>...incrList){		
		 if(n >= incrList.length){
	            //System.out.println(prefix);
	            return prefix;
	     }
	    for(int i=index;i<incrList[n].size();i++){
	    	combinationWithoutRepetition(n+1, i, prefix+incrList[n].get(i)+" || ", incrList);
	    }
	    return prefix;		
	}
	 
	public static void main(String[] args) {
		System.out.println(NumToWord.getCharKey(4, 2));
		//System.out.println();
		//NumToWord.teleNumWords(new int[]{9,2,5,6,7,8});
		NumToWord.teleNumWords1(new int[]{8,6,6,2,6,6,5});
		
	}

}
