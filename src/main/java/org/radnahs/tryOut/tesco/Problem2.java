/**
 * <p>Project: org.radnahs.tryOut.tesco </p>
 * <p>Package Name: org.radnahs.tryOut.tesco </p>
 * <p>File Name: Problem2.java </p>
 * <p>Create Date: Apr 28, 2017 </p>
 * <p>Create Time: 11:27:22 AM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.tesco;

/**
 * @author: Shantanu Sikdar
 */
public class Problem2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem2 problem2 = new Problem2();
		int[][] input3 = new int[][]{{75,76,65,87,87},
									{78,76,68,56,89},
									{67,87,78,77,65}};
									
		int[] sumAllSubExceptLeast = SortStudentMarks(3,5,input3);
		for(int k=0; k<3 ;k++){
			System.out.println(sumAllSubExceptLeast[k]);
		}
	}

	public static int[] SortStudentMarks(int input1,int input2,int[][] input3){
		// Read only region end
		// Write code here...
		int[] sumLeastScoredSub = new int[input2];
		/*for(int k=0; k<input2 ;k++){
			sumLeastScoredSub[k]=0;
		}*/
		int[] sumAllSub = new int[input1];
		for(int i=0;i<input1;i++){
			for(int j=0; j<input2; j++){
			     //sumLeastScoredSub[j] = sumLeastScoredSub[j] + input3[i][j];
				sumLeastScoredSub[j]+=input3[i][j];
				sumAllSub[i]+=input3[i][j];
			}
		}
		int indexLeastScored=0;
		int temp=sumLeastScoredSub[0];
		for(int k=0; k<input2 ;k++){
			if(temp>sumLeastScoredSub[k]){
				temp=sumLeastScoredSub[k];
				indexLeastScored=k;
			}
		}
		
		int[] sumAllSubExceptLeast = new int[input1];
		/*for(int k=0; k<input2 ;k++){
			sumAllSubExceptLeast[k]=0;
		}*/
		for(int i=0;i<input1;i++){
			for(int j=0; j<input2; j++){
				if(j!=indexLeastScored){
				    sumAllSubExceptLeast[i]+=input3[i][j];	
				}
			}
		}
		
		return sumAllSubExceptLeast;
		//return new int[]{325,299,296};
		//throw new UnsupportedOperationException("SortStudentMarks(int input1,int input2,int[][] input3)");
	}
	
	
	
	public static int[] SortStudentMarksTest1(int input1,int input2,int[][] input3){
		// Read only region end
		// Write code here...
		int[] sumLeastScoredSub = new int[input2];
		for(int k=0; k<input2 ;k++){
			sumLeastScoredSub[k]=0;
		}
		
		for(int i=0;i<input1;i++){
			for(int j=0; j<input2; j++){
			     //sumLeastScoredSub[j] = sumLeastScoredSub[j] + input3[i][j];
				sumLeastScoredSub[j]+=input3[i][j];
			}
		}
		int indexLeastScored=-1;
		int temp=sumLeastScoredSub[0];
		for(int k=0; k<input2 ;k++){
			if(temp>sumLeastScoredSub[k]){
				temp=sumLeastScoredSub[k];
				indexLeastScored=k;
			}
		}
		System.out.println(" least "+ temp);
		System.out.println(indexLeastScored);
		int[] sumAllSubExceptLeast = new int[input2];
		
		return new int[]{325,299,296};
		//throw new UnsupportedOperationException("SortStudentMarks(int input1,int input2,int[][] input3)");
	}
	
}
/*
import java.io.*;
import  java.util.*;

// Read only region start
class UserMainCode
{

	public int[] SortStudentMarks(int input1,int input2,int[][] input3){
		// Read only region end
		// Write code here...
		int[] sumLeastScoredSub = new int[input2];
		for(int k=0; k<input2 ;k++){
			sumLeastScoredSub[k]=0;
		}
		
		for(int i=0;i<input1;i++){
			for(int j=0; j<input2; j++){
			     //sumLeastScoredSub[j] = sumLeastScoredSub[j] + input3[i][j];
				sumLeastScoredSub[j]+=input3[i][j];
			}
		}
		int indexLeastScored=0;
		int temp=sumLeastScoredSub[0];
		for(int k=0; k<input2 ;k++){
			if(temp>sumLeastScoredSub[k]){
				temp=sumLeastScoredSub[k];
				indexLeastScored=k;
			}
		}
		
		int[] sumAllSubExceptLeast = new int[input1];
		for(int k=0; k<input2 ;k++){
			sumAllSubExceptLeast[k]=0;
		}
		for(int i=0;i<input1;i++){
			for(int j=0; j<input2; j++){
				if(j!=indexLeastScored){
				    sumAllSubExceptLeast[i]+=input3[i][j];	
				}
			}
		}
		
		return sumAllSubExceptLeast;
		//return new int[]{325,299,296};
		//throw new UnsupportedOperationException("SortStudentMarks(int input1,int input2,int[][] input3)");
	}
}*/