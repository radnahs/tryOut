/**
 * <p>Project: org.radnahs.tryOut.amazon </p>
 * <p>Package Name: org.radnahs.tryOut.amazon </p>
 * <p>File Name: CommonPointInLine.java </p>
 * <p>Create Date: Jun 14, 2017 </p>
 * <p>Create Time: 6:08:55 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.amazon;

/**
 * @author: Shantanu Sikdar
 */
public class CommonPointInLine {
	
	private boolean isIntersecting(int x1,int x2, int y1, int y2){
		if(x1<y1 && x2>y1){
			return true;
		}else if(x1<y2 && x2>y2){
			return true;
		}else if(x1>y1 && x1<y2){
			return true;
		}else if(x2>y1 && x2<y2){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		CommonPointInLine cpl = new CommonPointInLine();
		System.out.println(cpl.isIntersecting(2, 5, 6, 12));
	}

}
