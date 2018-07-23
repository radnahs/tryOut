/**
 * <p>Project: org.radnahs.tryOut.amazon </p>
 * <p>Package Name: org.radnahs.tryOut.amazon </p>
 * <p>File Name: BinaryTreeLeftView.java </p>
 * <p>Create Date: Jun 20, 2017 </p>
 * <p>Create Time: 10:59:32 AM </p>
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
public class BinaryTreeLeftView {

	public static void main(String[] args) {
		String str = "shantanu is java developer";
		String[] strArr = str.split(" ");
		StringBuilder sb = new StringBuilder(str);
		System.out.println(sb.reverse());
		for (String string : strArr) {
			System.out.println(string);
		}
	}

}
class Node{
	int iData;
	double fData;
	Node leftChild;
	Node rightChild;
	
}
