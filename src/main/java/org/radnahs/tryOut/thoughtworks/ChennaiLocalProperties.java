package org.radnahs.tryOut.thoughtworks;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ChennaiLocalProperties {

	private static Logger logger = Logger.getLogger(ChennaiLocalProperties.class.getName());
	private static Properties properties = new Properties();
	private static InputStream in = ChennaiLocalProperties.class.getResourceAsStream("/ChennaiLocal.properties");
	
	static {
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			logger.error(e);			
		} finally {

		}
	}

	public static String Chennai_Beach = properties.getProperty("ChennaiLocal.Chennai_Beach");
	public static String Chennai_Fort = properties.getProperty("ChennaiLocal.Chennai_Fort");
	public static String Chennai_Park = properties.getProperty("ChennaiLocal.Chennai_Park");
	public static String Chennai_Egmore = properties.getProperty("ChennaiLocal.Chennai_Egmore");
	public static String Chetpet = properties.getProperty("ChennaiLocal.Chetpet");
	public static String Nungambakkam = properties.getProperty("ChennaiLocal.Nungambakkam");
	public static String Kodambakkam = properties.getProperty("ChennaiLocal.Kodambakkam");
	public static String Mambalam = properties.getProperty("ChennaiLocal.Mambalam");
	public static String Saidapeth = properties.getProperty("ChennaiLocal.Saidapeth");
	public static String St_Thomas_Mount = properties.getProperty("ChennaiLocal.St_Thomas_Mount");
	public static String Pazhavanthangal = properties.getProperty("ChennaiLocal.Pazhavanthangal");
	public static String Meenambakkam = properties.getProperty("ChennaiLocal.Meenambakkam");
	public static String Trisulam = properties.getProperty("ChennaiLocal.Trisulam");
	public static String Pallavaram = properties.getProperty("ChennaiLocal.Pallavaram");
	public static String Chromepet = properties.getProperty("ChennaiLocal.Chromepet");
	public static String Tambaram_Sanatorium = properties.getProperty("ChennaiLocal.Tambaram_Sanatorium");
	public static String Tambaram = properties.getProperty("ChennaiLocal.Tambaram");
	
	//add station code in order of their up and down positions
	public static String[] ChennaiLocalRlyStations = {Chennai_Beach,Chennai_Fort,Chennai_Park,Chennai_Egmore,Chetpet,Nungambakkam,
			Kodambakkam,Mambalam,Saidapeth,St_Thomas_Mount,Pazhavanthangal,Meenambakkam,Trisulam,Pallavaram,Chromepet,
			Tambaram_Sanatorium,Tambaram}; 
	 
	
	public static void main(String[] args) {
		//System.out.println(ChennaiLocalProperties.Nungambakkam);
		//System.out.println(ChennaiLocalProperties.Chennai_Egmore);
		for (String string : ChennaiLocalRlyStations) {
			System.out.print(string +" = ");
			System.out.println(Arrays.binarySearch(ChennaiLocalRlyStations, string));
		}
	}

}
