/**
 * <p>Project: org.radnahs.tryOut.thoughtworks.merchantToGalaxy.service </p>
 * <p>Package Name: org.radnahs.tryOut.thoughtworks.merchantToGalaxy.service </p>
 * <p>File Name: IMessageParser.java </p>
 * <p>Create Date: Apr 18, 2017 </p>
 * <p>Create Time: 6:03:35 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.thoughtworks.merchantToGalaxy.service;

import java.util.Map;

/**
 * @author: Shantanu Sikdar
 */
public interface IMessageParser {
	
	public Map<String, String> parseMessage(String[] message);
	
}
