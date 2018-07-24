/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.ideas </p>
 * <p>File Name: MainTest.java</p>
 * <p>Create Date: Feb 19, 2016 </p>
 * <p>Create Time: 9:57:17 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ideas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Shantanu Sikdar 
 *
 */
public class MainTest {

	/**
	 * Test method for {@link org.radnahs.tryOut.ideas.Main#processData(java.util.ArrayList)}.
	 */
	@Test
	public void testProcessData() {
		//fail("Not yet implemented");
		ArrayList<String> inputData = new ArrayList<String>();
		inputData.add("22|Data Structures|45");
    	inputData.add("23|English|52");
    	inputData.add("22|English|51");
    	inputData.add("26|Data Structures|72");
    	inputData.add("23|Data Structures|61");
    	inputData.add("21|English|81"); 
    	Main.processData(inputData);
    	assertEquals(2, inputData.size());
    	assertEquals(4, inputData.size());
	}

}
