/**
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.continuum </p>
 * <p>File Name: C.java </p>
 * <p>Create Date: Jun 9, 2017 </p>
 * <p>Create Time: 2:56:38 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.continuum;

/**
 * @author: Shantanu Sikdar
 */
interface X {
	String f();
}

class X1 implements X {
	@Override
	public String f() {
		return "x1";
	}
}

class X2 implements X {
	@Override
	public String f() {
		return "x2";
	}
}

public class Continuum1 {
	public static X createX(String itype) {
		if (itype.equalsIgnoreCase("X1")) {
			return new X1();
		} else if (itype.equalsIgnoreCase("X2")) {
			return new X2();
		} else {
			throw new IllegalArgumentException("No such type");
		}
	}
	
	public static void main(String[] args) {
		createX("X1");
	}
}