/**
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.continuum </p>
 * <p>File Name: StudentService.java </p>
 * <p>Create Date: Aug 9, 2016 </p>
 * <p>Create Time: 8:17:36 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.continuum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class StudentService {

	private Map<Integer, List<StudentData>> studentDataMap = new HashMap<>();
	
	public Map<Integer, List<StudentData>> readFile(String fileName){
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String[] strArr = scanner.nextLine().split("|");
				makingStudentDataMap(strArr);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentDataMap;
	}
	
	private void makingStudentDataMap(String[] strArr){
		List<StudentData> lst;
		if(studentDataMap.containsKey(strArr[0])){
			lst = studentDataMap.get(strArr[0]);
		}else{
			lst = new ArrayList<>();
		}
		StudentData studentData  = new StudentData();
		studentData.setRollNum(Integer.parseInt(strArr[0]));
		studentData.setSubject(strArr[1]);
		studentData.setMarks(Integer.parseInt(strArr[2]));
		lst.add(studentData);
		studentDataMap.put(Integer.parseInt(strArr[0]), lst);
	}
	
	public void writeFile(){
		try{
		    PrintWriter writer = new PrintWriter("C:\\Data\\misc\\sikdar.txt");
		    for (Entry<Integer, List<StudentData>> mapKey : studentDataMap.entrySet()) {
		    	writer.println(mapKey.getKey() + " - " + mapKey.getValue());
			}
		    writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
