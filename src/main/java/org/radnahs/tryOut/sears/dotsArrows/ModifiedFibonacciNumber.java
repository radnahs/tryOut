/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.sears.dotsArrows;
* File Name: ModifiedFibonacciNumber.java
* Create Date: Oct 23, 2016
* Create Time: 6:31:00 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.sears.dotsArrows;

public class ModifiedFibonacciNumber {

	public static void main(String[] args) {
		System.out.println();
	}
	
	
	public long fibonacciSeriesNthTerm(long nTerm){
		long x=1,y=1,term=1;		
		while(1<nTerm && term<nTerm){
			long temp;
			temp = x+y;
			x=y;
			y=temp;			
			term++;
		}
		return y;
	}
	
	public int fibonacciSeriesRecursion(int nTerm,int prev,int latest){		
		if(nTerm==1){
			return prev+latest;
		}else{
			return (fibonacciSeriesRecursion(nTerm-1,latest,prev+latest));
		}
	}

}
