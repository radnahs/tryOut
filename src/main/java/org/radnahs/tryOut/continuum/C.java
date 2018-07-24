/**
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.continuum </p>
 * <p>File Name: C.java </p>
 * <p>Create Date: Jun 9, 2017 </p>
 * <p>Create Time: 3:06:36 PM </p>
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
public class C {
    static void m(Object o) {
            System.out.println("m(o)");
    }
    static void m(String s) {
            System.out.println("m(s)");
    }
    static void m(Integer i) {
            System.out.println("m(i)");
    }
    static <T> void f(T t) {
            m(t) ;
    }

    public static void main(String[] args) {
    	f("abc");
    	f(100);
    }
}
