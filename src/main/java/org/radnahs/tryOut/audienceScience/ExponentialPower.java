/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.audienceScience;
* File Name: ExponentialPower.java
* Create Date: Sep 2, 2016
* Create Time: 2:47:12 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.audienceScience;

import java.math.BigDecimal;

public class ExponentialPower {

	int p = 1;
	private int powerRecursive(int x, int y){
		p=p*x;
		if(y==1){
			return p;
		}		
		return powerRecursive(x, y-1);
	}
	
	private void powerFor(int to, int pow){
		int two=1;
		for(int i=0;i<pow;i++){
			two=to*two;
		}
		System.out.println("two = "+ two);
	}
	
	private BigDecimal powerBigDecimal(String val, String pow){
		BigDecimal bd = new BigDecimal(val);
		BigDecimal result = bd.pow(new Integer(pow));
		System.out.println(result);
		return result;
	}
	
	/*public void power(String val, String pow){
		if(new Integer(pow)<0){
			pow=""+Math.abs(new Integer(pow));
			BigDecimal result = new BigDecimal("");
			result.  
					1/powerBigDecimal(val, pow);
			System.out.println(result);
		}else{
			powerBigDecimal(val, pow);
		}
	}*/
	
	public static void main(String[] args) {
		ExponentialPower ep = new ExponentialPower();
		System.out.println(ep.powerRecursive(3,3));
		ep.powerFor(5, 5);
		ep.powerBigDecimal("5", "-2");
	}
	
	
	
	
}
