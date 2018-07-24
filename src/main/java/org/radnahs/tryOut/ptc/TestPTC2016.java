/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.ptc </p>
 * <p>File Name: TestPTC2016.java</p>
 * <p>Create Date: Feb 5, 2016 </p>
 * <p>Create Time: 5:00:38 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ptc;

import java.util.HashSet;

/**
 * @author Shantanu Sikdar 
 *
 */
public class TestPTC2016 {

	public static void main(String[] args) {
		
	}
	
	public static void main6(String[] args) {
		HashSet hs = new HashSet();
		NamePTC namePTC = new NamePTC("PTC");
		hs.add("namePTC");
		namePTC.setName("PTC Software");
		System.out.println(hs.contains(namePTC));
	}
	
	public static void main5(String[] args) {
		Base1 chil1 = new Child1();
		System.out.println("");
		Base1 base = new Base1();
	}
	
	public static void main3(String[] args) {
		TestPTC2016 p = new TestPTC2016();
		p.start();
	}
	void start(){
		long[] a1 = {3,4,5};
		long[] a2 = fix(a1);
		System.out.print(a1[0]+a1[1]+a1[2]+" ");
		System.out.println(a2[0]+a2[1]+a2[2]+" ");
	}
	long[] fix(long[] a3){
		a3[1]=7;
		return a3;
	}
	
	public static void main2(String[] args) {
		boolean a= false;
		if(a=true)
			System.out.println("Hello");
		else
			System.out.println("Goodbye");
	}
	
	public static void main1(String[] args) {
		int[] a={1};
		TestPTC2016 t = new TestPTC2016();
		t.increment1(a);
		System.out.println(a[a.length-1]);
	}
	void increment1(int[] i){
		i[i.length-1]++;
	}
	
	public static void main10(String[] args) {
		String string1 = "Hello PTC";
		String string2 = new String("Hello PTC");
		String string3 = string2.intern();
		System.out.println(string1==string2?"true":"false");
		System.out.println(string1==string3?"true":"false");
		System.out.println(string2==string3?"true":"false");
		System.out.println(string2.equals(string3)?"true":"false");
	}

}
class Base1{
	static{
		System.out.print("Static block base||");
	}
	public Base1(){
		System.out.print("Constructor Base");
	}
}
class Child1 extends Base1{
	static{
		System.out.print("Static block child||");
	}
	public Child1(){
		System.out.print("Constructor child");
	}
}

class NamePTC{
	private String name;
	
	public NamePTC(String name) {
		super();
		name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NamePTC other = (NamePTC) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}