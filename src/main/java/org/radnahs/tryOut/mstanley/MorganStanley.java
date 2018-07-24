/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: com.webtual.tryOut.utils.mstanley </p>
 * <p>File Name: MorganStanley.java</p>
 * <p>Create Date: Jun 19, 2014 </p>
 * <p>Create Time: 3:46:19 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.mstanley;

/**
 * @author Shantanu Sikdar 
 *
 */
public class MorganStanley {
	
	private static int parity(int[] inarr){
		int prod=inarr[0];
		for (int i = 1; i < inarr.length; i++) {
			if(i%2==0)
				prod+=inarr[i];
			else
				prod*=inarr[i];
		}
		return prod;
	}
	
	private static int flip(int ii){
		String ss = Integer.toBinaryString(ii);
		//System.out.println(ss);
		char[] chrarr = ss.toCharArray();
		//System.out.println(String.valueOf(chrarr));
		char[] chrarr1 = new char[chrarr.length];
		for (int i = 0; i < chrarr.length; i++) {
			if(chrarr[i]=='0')
				chrarr1[i]='1';
			else
				chrarr1[i]='0';
		}		
		String sss = String.valueOf(chrarr1);
		//System.out.println(sss);
		return Integer.parseInt(sss, 2);
		
	}
	
	public static void main(String[] args) {
		System.out.println(flip(50));
		//System.out.println(parity(new int[]{1,2,3,4,5,6}));
	}


}
