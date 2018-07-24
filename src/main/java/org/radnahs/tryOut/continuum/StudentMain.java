/**
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.continuum </p>
 * <p>File Name: StudentMain.java </p>
 * <p>Create Date: Aug 9, 2016 </p>
 * <p>Create Time: 8:06:36 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package org.radnahs.tryOut.continuum;

public class StudentMain {

	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		studentService.readFile("enter the file name and path");
	}

}
