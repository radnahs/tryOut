/**
 * <p>Project: org.radnahs.tryOut.ubs </p>
 * <p>Package Name: org.radnahs.tryOut.ubs </p>
 * <p>File Name: MutabilityImmutability.java </p>
 * <p>Create Date: Jun 20, 2017			 </p>
 * <p>Create Time: 11:41:25 AM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ubs;

/**
 *
 * Passing mutable objects to immutable class
 * @author: Shantanu Sikdar
 */
public class MutabilityImmutability {
	

	public static void main(String[] args) {
		MutabilityImmutability mutabilityImmutability = new MutabilityImmutability();
		mutabilityImmutability.callToMutable();
		mutabilityImmutability.callToImmutable();
	}


	private void callToMutable(){
		MutableClassAge age = new MutableClassAge();
		age.setDay(1);
		age.setMonth(1);
		age.setYear(1992);
		ImmutableClassEmployee employee = new ImmutableClassEmployee(1, "Shantanu", age); 
		System.out.println("Shantanu age year before modification = " + employee.getMutableClassAge().getYear());
		age.setYear(1983);
		System.out.println("Shantanu age year after modification = " + employee.getMutableClassAge().getYear());
	}
	

	private void callToImmutable(){
		MutableClassAge age = new MutableClassAge();
		age.setDay(1);
		age.setMonth(1);
		age.setYear(1992);
		ImmutableClassEmployee employee = new ImmutableClassEmployee(1, age, "Shantanu");
		System.out.println("Shantanu age year before modification = " + employee.getMutableClassAge().getYear());
		age.setYear(1983);
		System.out.println("Shantanu age year after modification = " + employee.getMutableClassAge().getYear());
	}

}



class MutableClassAge{

	private int day;
	private int month;
	private int year;

	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}



final class ImmutableClassEmployee{

	private final int id;
	private final String name;
	private final MutableClassAge mutableClassAge;//Passing mutable objects to immutable class

	
	/**
	 * similar to default constructor only assigning the values to parameters
	 * @param id
	 * @param name
	 * @param mutableClassAge
	 */
	public ImmutableClassEmployee(int id, String name, MutableClassAge mutableClassAge) {
		super();
		this.id = id;
		this.name = name;
		this.mutableClassAge = mutableClassAge;
	}


	/**
	 * modified constructor for making the mutable object to immutable
	 * just for the sake there is a change in the constructor parameter 
	 * @param id
	 * @param age
	 * @param name
	 */
	public ImmutableClassEmployee(int id,  MutableClassAge age, String name) {
		this.name = name;
		this.id = id;
		MutableClassAge cloneAge = new MutableClassAge();
		cloneAge.setDay(age.getDay());
		cloneAge.setMonth(age.getMonth());
		cloneAge.setYear(age.getYear());
		this.mutableClassAge = cloneAge;
	}
	

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public MutableClassAge getMutableClassAge() {
		return mutableClassAge;
	}


}


