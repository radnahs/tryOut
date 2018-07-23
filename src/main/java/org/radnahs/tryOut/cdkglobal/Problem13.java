/**
 * <p>Project: org.radnahs.tryOut.cdkglobal </p>
 * <p>Package Name: org.radnahs.tryOut.cdkglobal </p>
 * <p>File Name: Problem13.java </p>
 * <p>Create Date: May 10, 2017 </p>
 * <p>Create Time: 9:18:43 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.cdkglobal;

/**
 * @author: Shantanu Sikdar
 */
public class Problem13 {

	public static void main(String[] args) {
		
		class Fun{
			int i=0;
			public int fun(int n){
				System.out.println("hello " + i++);
				return (n<3)?1:fun(n-1)+fun(n-2);
			}
		}
		//Fun f = new Fun();
		new Fun().fun(8);
	}

}
