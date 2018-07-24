/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: com.webtual.tryOut.utils.pubmatic </p>
 * <p>File Name: Problematic.java</p>
 * <p>Create Date: Oct 20, 2014 </p>
 * <p>Create Time: 2:56:52 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.pubmatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * @author Shantanu Sikdar 
 *
 */
public class Problematic {

	public static int[] getMaximumToysWithMinSaving(int input1,int[] input2) {
		int[] output=new int[2];		
		int toyCount=0;
		//int[] remainToys=new int[input2.length];
		List<Integer> maxNumToysLst = new ArrayList<Integer>(); 
		Arrays.sort(input2);
		int temp=0;
		for (int i = 0; i < input2.length; i++) {
			if(input2[i]>input1){				
				for(Integer ii:maxNumToysLst){
					System.out.println("ii="+ii+" input2[i] =" +input2[i]);
					if((input2[i]-ii)<=input1){
						//temp=input2[i]-ii;
						input1=input1-(input2[i]-ii);
						//temp=input1-(input2[i]-ii);
						System.out.println("input1 = "+input1);
					}/*else if((input2[i]-ii)==input1){
						temp=input1-(input2[i]-ii);
						System.out.println("0 temp = "+temp);
						break;
					}*/
				}
				//break;			
			}else{
				input1-=input2[i];				
				toyCount++;
				//remainToys[i]=input2[i];
				maxNumToysLst.add(input2[i]);
			}
		}
		
		
		output[0]=toyCount;
		output[1]=input1;
		//output[1]=input1-temp;
		for (int i = 0; i < output.length; i++) {
			System.out.println("in = "+output[i]);
			//System.out.println("rem = "+remainToys[i]);			
		}
		return output;
    }
	
	
	private static int[] getMaximumToysWithMaxSaving(int input1,int[] input2){
		int[] output=new int[2];
		Integer toyCount=0;
		Arrays.sort(input2);
		for(int ii:input2){
			if(ii>input1){				
				break;
			}else{
				input1-=ii;
				toyCount++;
			}
		}
		output[0]=toyCount;
		output[1]=input1;
		for(int ii:output){
			System.out.println(ii);
		}
		return output;
	}
	
	private static void sortArray(Integer[] toyArr){
		List<Integer> lstInt=Arrays.asList(toyArr);
		//System.out.println(lstInt);
		Collections.sort(lstInt);
		//System.out.println(lstInt);
		Integer sum=50;
		Integer toyCount=0;
		for(Integer ii:lstInt){
			if(ii>sum){				
				break;
			}else{
				sum-=ii;
				toyCount++;
			}
			System.out.println(sum);
		}
		System.out.println(sum);
		System.out.println(toyCount);
		
	}
	
	public static void main(String[] args) {
		//int[] toyArr=new int[]{1,12,5,111,200,1000,10,9,6,7,4};
		int[] toyArr=new int[]{1,12,8,111,200,1000,10,9,6,7,8};
		System.out.println("shantanu is here");
		//sortArray(toyArr);
		getMaximumToysWithMaxSaving(50,toyArr);
		//getMaximumToysWithMinSaving(50,toyArr);
	}

	

}
