/**
 * <p>Project: org.radnahs.tryOut.thoughtworks.merchantToGalaxy </p>
 * <p>Package Name: org.radnahs.tryOut.thoughtworks.merchantToGalaxy </p>
 * <p>File Name: MerchantsGuideToGalaxy.java </p>
 * <p>Create Date: Apr 18, 2017 </p>
 * <p>Create Time: 10:19:14 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.thoughtworks.merchantToGalaxy;

import org.radnahs.tryOut.thoughtworks.merchantToGalaxy.util.InputOutput;

/**
 * @author: Shantanu Sikdar
 */
public class MerchantsGuideToGalaxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputOutput io = new InputOutput();
		io.readFile("D:\\Projects\\WebApplications\\rytry\\trunk\\src\\main\\java\\com\\webtual\\rytry\\tests\\thoughtworks\\merchantToGalaxy\\input.txt");
		
		io.writeFile("D:\\Projects\\WebApplications\\rytry\\trunk\\src\\main\\java\\com\\webtual\\rytry\\tests\\thoughtworks\\merchantToGalaxy\\output.txt");
	}

}
