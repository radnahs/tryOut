/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: org.radnahs.tryOut.ideas </p>
 * <p>File Name: Main.java</p>
 * <p>Create Date: Feb 19, 2016 </p>
 * <p>Create Time: 8:34:33 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.ideas;

/**
 * @author Shantanu Sikdar 
 *
 */
/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */


/* Do not add a namespace declaration */
public class Main {
    public static Map<String,Integer> processData(ArrayList<String> array) {
        /* 
         * Modify this method to process `array` as indicated
         * in the question. At the end, return the appropriate value.
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */
        Map<String,Integer> retVal = new HashMap<String,Integer>();
        Map<String,Integer> refVal = new HashMap<String,Integer>();//reference map for comparing id of the stored value
        for (String string : array) {
        	String[] strArr = string.split("\\|");
        	Integer id = new Integer(strArr[0]);
        	String subjct = strArr[1];
        	Integer marks = new Integer(strArr[2]);
        	if(retVal.containsKey(subjct)){// checking already existing key and its value
        		if(refVal.get(subjct)>id){
        			retVal.put(subjct, marks);
            		refVal.put(subjct, id);
        		}
        	}else{//adding a new key value
        		retVal.put(subjct,marks );
        		refVal.put(subjct, id);
        	}
        }
        return retVal;
    }

    /*public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
            while(in.hasNextLine())
                inputData.add(in.nextLine());
            Map<String,Integer> retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            for(Map.Entry<String,Integer> e: retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }*/
    
    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            /*Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
            while(in.hasNextLine())
                inputData.add(in.nextLine());*/
        	inputData.add("22|Data Structures|45");
        	inputData.add("23|English|52");
        	inputData.add("22|English|51");
        	inputData.add("26|Data Structures|72");
        	inputData.add("23|Data Structures|61");
        	inputData.add("21|English|81");
            Map<String,Integer> retVal = processData(inputData);
            /*PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            for(Map.Entry<String,Integer> e: retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            output.close();*/
        } catch (Exception e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
