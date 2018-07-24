/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: com.webtual.tryOut.utils.tests.ptc </p>
 * <p>File Name: TestPTC.java</p>
 * <p>Create Date: Jun 22, 2015 </p>
 * <p>Create Time: 1:42:38 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ptc;

/**
 * @author Shantanu Sikdar 
 *
 */
public class TestPTC {

	

	public static void main(String[] args) {
		TestPTC tptc = new TestPTC();
		//tptc.telephoneNumtoWord(new int[]{2,3,4,4,7,6,6});
		//tptc.start();
		
		/*int[] a={1};
		tptc.incr(a);
		System.out.println(a[a.length-1]);*/
		
		/*Base c1 = new Child();
		Base b1 = new Base();*/
		
		/*boolean a =false;
		if(a=true)
			System.out.println("hello");
		else {
			System.out.println("bye");
		}*/
		
		/*HashSet set = new HashSet();
		Name name = new Name("shant");
		set.add(name);
		name.setName("sikdar");
		System.out.println(set.contains(name));*/
		/*String s1="hello shan";
		String s2=new String("hello shan");
		String s3 = s2.intern();
		System.out.println("s1==s2 is "+s1==s2);
		System.out.println("s1==s3 is "+s1==s3);
		System.out.println("s2==s3 is "+s2==s3);
		System.out.println("s1==s3 is "+s2.equals(s3));*/
	}
	
	void start(){
		long []a1={3,4,5};
		long []a2=fix(a1);
		
		System.out.print(a1[0] + a1[1] + a1[2] + " ");
		System.out.println(a2[0] + a2[1] + a2[2] + " ");
	}
	//optical=oia,p,t,c,l
	/*
	 * x
	 */
	long[] fix(long []a3){
		a3[1]=7;
		return a3;
	}
		
	public static void incr(int[] i){
		i[i.length-1]++;
	}
	
	
	/*
	 * 7.20/5.70=6.30
	 * 24x+19y=21(x+y)
	 * 3x=2y
	 * x/y=2/3
	 */
		
}
class Name{//020 41088600
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Name(String name) {
		super();
		this.name = name;
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
		Name other = (Name) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
