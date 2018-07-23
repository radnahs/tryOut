package org.radnahs.tryOut.ubs;

import java.util.HashMap;
import java.util.Map;

//import com.ibm.icu.text.NumberFormat;

public class Test extends A{
	
	{System.out.println("1");}

	static{System.out.println("2");}
	public Test(){System.out.println("3");}
	public static void main(String[] args) throws Exception{
		/*Test t = new Test();
		
		short s =9;
		System.out.println(add(s,6));*/
		Object obj = new Object();
		
		/*synchronized (Thread.currentThread()) {
			//obj.wait();
			obj.notify();
		}*/
		
		/*main(args);
		Thread.sleep(100000);*/
		/*Map<B, String> map = new HashMap<>();
		map.put(new B("roose"), "b212");
		B b = new B("roose");
		System.out.println(map.get(b));*/
		String s= "123.45sfs";
		//NumberFormat n = NumberFormat.getInstance();
	}

}
class A{
	int add(int i, int j){
		return i+j;
	}
}
class B{
	String name;
	public B(String name){
		this.name=name;
	}
}