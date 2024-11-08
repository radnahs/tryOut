/**
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.logicMonitor </p>
 * <p>File Name: LogicMonitorPracticeProblem.java </p>
 * <p>Create Date: 03-Mar-2020 </p>
 * <p>Create Time: 9:46:51 pm </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package org.radnahs.tryOut.logicMonitor;

/**
 * @author : Shantanu Sikdar
 *
 */
public class LogicMonitorPracticeProblem {

	public static void main(String[] args) {
		System.out.println(sayHello("Shantanu"));
		System.out.println(sayHello(""));
		System.out.println(sayHello("      "));
		System.out.println(sayHello(" "));
	}

	public static String sayHello(String name) {
		String str = "";
		if(name==null || name.isEmpty() || name.contains(" ") ) {
			str = "Hello there!";
		}else {
			str = "Hello, "+ name+"!";
		}

		return str; 
	}
}
