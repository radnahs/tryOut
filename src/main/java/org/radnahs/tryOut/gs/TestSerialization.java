/**
 *
 * <p>Project: tryOut </p>
 * <p>Package Name: com.webtual.tryOut.utils.tests.gs </p>
 * <p>File Name: TestSerialization.java</p>
 * <p>Create Date: Apr 24, 2015 </p>
 * <p>Create Time: 5:49:22 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.gs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Shantanu Sikdar 
 *
 */
class Node implements Serializable{
	int id;
	String val;
	Node next;
	
	public Node(int id, String val) {
		super();
		this.id = id;
		this.val = val;
		this.next = null;
	}

/*	@Override
	public String toString() {
		return "Node [id=" + id + ", val=" + val + "]";
	}
*/	
	
	
}

public class TestSerialization {
	
	/*public static void main(String[] args) {
		Node node1 = new Node(11,"shantanu");
		
		try {
			FileOutputStream fos = new FileOutputStream("srlzbl.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(node1);
			oos.flush();
			System.out.println("Muaah");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}*/
	
	/*Deserialize */
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("srlzbl.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Node node1 = (Node)ois.readObject();
			
			System.out.println(node1.toString());
			ois.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
	}

}
