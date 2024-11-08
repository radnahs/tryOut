/**
 * <p>Project: tryout </p>
 * <p>Package Name: com.radnahs.tryOut.wipro </p>
 * <p>File Name: CountingEmptyString.java </p>
 * <p>Create Date: 24-Feb-2022 </p>
 * <p>Create Time: 3:43:50 PM </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.wipro;

import java.util.Arrays;
import java.util.List;

public class CountingEmptyString {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk"); 
		//Java 8 Filter Example: c
		long count = strList.stream().filter(x -> x.isEmpty()).count();
		System.out.println(count);
	}

}
