/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.jitterbit </p>
 * <p>File Name: FileRead.java</p>
 * <p>Create Date: 24-Apr-2025 </p>
 * <p>Create Time: 6:17:29 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.jitterbit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 */
public class FileRead {

	/**
	 * this problem is shared by Jeff Stevenson and ask me to find errors
	 * 
	 * @param args
	 */
	public static void main1(String[] args) {
		BufferedReader reeder;
		try {
			int numLines = 5;
			reeder = new BufferedReader(new FileReader("c:/temp/test.txt"));
			String l = reeder.readLine();

			numLines = 5;
			int i = 0;
			while (l != null) {
				i = i + 1;
				l = reeder.readLine();
				if (i < numLines) {
					System.out.println(l);
				}
			}
		} catch (IOException e) {
		}
	}

	/**
	 * I rewrote the problem like this
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("D:\\data\\test\\test.txt");
		try (Scanner sc = new Scanner(file);) {
			int i = 0, numLines = 5;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (i < numLines) {
					System.out.println(line);
					i++;
				} else {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
