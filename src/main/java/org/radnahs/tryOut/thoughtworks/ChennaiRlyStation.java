/**
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: com.webtual.rytry.utils.tests.thoughtworks </p>
 * <p>File Name: ChennaiRlyStation.java</p>
 * <p>Create Date: Mar 31, 2016 </p>
 * <p>Create Time: 12:25:35 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */

package org.radnahs.tryOut.thoughtworks;

public enum ChennaiRlyStation {
	Chennai_Beach(1,"Chennai Beach"),
	Chennai_Fort(2,"Chennai Fort"),
	Chennai_Park(3,"Chennai Park"),
	Chennai_Egmore(4,"Chennai Egmore"),
	Chetpet(5,"Chetpet"),
	Nungambakkam(6,"Nungambakkam"),
	Kodambakkam(7,"Kodambakkam"),
	Mambalam(8,"Mambalam"),
	Saidapeth(9,"Saidapeth"),
	Guindy(10,"Guindy"),
	St_Thomas_Mount(11,"St Thomas Mount"),
	Pazhavanthangal(12,"Pazhavanthangal"),
	Meenambakkam(13,"Meenambakkam"),
	Trisulam(14,"Trisulam"),
	Pallavaram(15,"Pallavaram"),
	Chromepet(16,"Chromepet"),
	Tambaram_Sanatorium(17,"Chennai Sanatorium"),
	Tambaram(18,"Tambaram");
	
	private final int key;
	private final String name;

	ChennaiRlyStation(int intKey, String rlyStnName){
		this.key=intKey;
		this.name=rlyStnName;
	}
	
	public int getKey(){ return key;	}
	public String getName(){ return name;	}
	
}
