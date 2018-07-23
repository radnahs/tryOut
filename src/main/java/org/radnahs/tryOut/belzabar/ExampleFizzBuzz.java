/**
 *
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: org.radnahs.tryOut.belzabar </p>
 * <p>File Name: ExampleFizzBuzz.java</p>
 * <p>Create Date: Jan 7, 2016 </p>
 * <p>Create Time: 1:32:54 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package org.radnahs.tryOut.belzabar;
/**
 * https://www.interviewzen.com/apply/7Hsdt3
 * 
 * Write a program that prints the numbers from 1 to 100. 
 * But for multiples of three print "Fizz" instead of the 
 * number and for the multiples of five print "Buzz". 
 * For numbers which are multiples of both three and five print "FizzBuzz".
 */

/**
 * @author Shantanu Sikdar 
 *
 */
public class ExampleFizzBuzz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			if(i%3==0 && i%5==0){
				System.out.println(i+ " is multiple of 3 and 5 thus, FizzBuzz");
			}else if(i%3==0){
				System.out.println(i+ " is multiple of 3 thus, Fizz");
			}else if(i%5==0){
				System.out.println(i+ " is multiple of 5 thus, Buzz");
			}else{
				System.out.println(i+", ");
			}
		}
	}

}
