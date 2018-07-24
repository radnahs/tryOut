/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.ptc </p>
 * <p>File Name: PatternFinderPTC.java</p>
 * <p>Create Date: Feb 5, 2016 </p>
 * <p>Create Time: 7:40:07 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ptc;

/**
 * @author Shantanu Sikdar 
 *
 */
public class PatternFinderPTC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean b  = false;
		for (int i = 1; i < "abcabcadbcabc".length()/2; i++) {
			b=matcher(splitString("abcabcabcabc", 0, i));
			if (b) {
				System.out.println(i);
				System.out.println(b);
				break;
			}
			
		}
		
	}
	
	static String[] splitString(String strToDivide,int beginIndex,int divideStrInSize){
		int szr = strToDivide.length()/divideStrInSize;
		String[] ssArr = new String[szr];
		for(int i=0; i<szr;i++){
			int t=beginIndex+divideStrInSize;
			ssArr[i]=strToDivide.substring(beginIndex,t);
			//System.out.print(ssArr[i]+" || ");
			beginIndex=beginIndex+divideStrInSize;			
		}
		return ssArr;
	}
	
	static boolean matcher(String[] ssArr){
		boolean rtrn=false;
		for (int i = 0; i < ssArr.length; i++) {
			String string = ssArr[0];
			/*System.out.println(string);
			System.out.println(ssArr[i]);*/
			if(string.equals(ssArr[i])){
				rtrn=true;
			}else{
				rtrn=false;
				break;
			}
		}
		return rtrn;
	}

}
