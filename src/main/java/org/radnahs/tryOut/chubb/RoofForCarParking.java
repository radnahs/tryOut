/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.chubb </p>
 * <p>File Name: RoofForCarParking.java</p>
 * <p>Create Date: 10-Mar-2021 </p>
 * <p>Create Time: 8:50:07 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.chubb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 */
public class RoofForCarParking {
	
	public static void main(String[] args) {

		List<Long> cars = Arrays.asList(6l, 2l, 12l, 7l);

//		List<Long> cars = new ArrayList<Long>();
//		cars.add(2l);
//		cars.add(10l);
//		cars.add(17l);
//		cars.add(8l);

		int k = 3;
		System.out.println(carParkingRoof(cars, k));

	}

	private static long carParkingRoof(List<Long> cars, int k) {
		List<Long> carss = cars.stream().sorted().collect(Collectors.toList());
		List<Long> carsss = new ArrayList<Long>();
		for (int i = 0; i < carss.size() - k + 1; i++) {
			long temp = 0;
			for (long j = carss.get(i); j <= carss.get(i + k - 1); j++) {
				System.out.println(j);
				temp += 1;
			}
			carsss.add(temp);
		}
		Collections.sort(carsss);
		return carsss.get(0);
	}

}
