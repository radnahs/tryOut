/**
 * <p>Project: org.radnahs.tryOut.thoughtworks.merchantToGalaxy.util </p>
 * <p>Package Name: org.radnahs.tryOut.thoughtworks.merchantToGalaxy.util </p>
 * <p>File Name: InputOutput.java </p>
 * <p>Create Date: Apr 18, 2017 </p>
 * <p>Create Time: 8:32:12 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.thoughtworks.merchantToGalaxy.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.radnahs.tryOut.thoughtworks.merchantToGalaxy.service.GalacticMessageParser;
import org.radnahs.tryOut.thoughtworks.merchantToGalaxy.service.IMessageParser;

/**
 * @author: Shantanu Sikdar
 */
public class InputOutput {
	
	public Map<String, String> outputMap = new LinkedHashMap<>();

	public void readFile(String inFileName){
		try {
			IMessageParser iMP = new GalacticMessageParser();
			File file = new File(inFileName);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String[] strArr = scanner.nextLine().split(" ");
				outputMap = iMP.parseMessage(strArr);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(outputMap);
	}
	
	public void writeFile(String outFileName){
		try{
		    //PrintWriter writer = new PrintWriter("D:\\Projects\\WebApplications\\rytry\\trunk\\src\\main\\java\\com\\webtual\\rytry\\tests\\thoughtworks\\merchantToGalaxy\\output.txt");
			PrintWriter writer = new PrintWriter(outFileName);
		    for (Entry<String, String> mapKey : outputMap.entrySet()) {
		    	System.out.println(mapKey.getKey() + " - " + mapKey.getValue());
		    	writer.println(mapKey.getKey() + " - " + mapKey.getValue());
			}
		    writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		/*Map<Integer, String> intStrMap = new LinkedHashMap<>();
		intStrMap.put(1, "Shantanu");
		intStrMap.put(2, "Shantanu2");
		intStrMap.put(4, "Shantanu4");
		intStrMap.put(3, "Shantanu3");
		for (Entry<Integer, String> mapIS : intStrMap.entrySet()) {
			System.out.println(mapIS.getKey()+" "+mapIS.getValue());
		}*/
	}

}
