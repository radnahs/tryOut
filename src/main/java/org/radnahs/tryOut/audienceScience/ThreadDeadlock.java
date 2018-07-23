/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.audienceScience;
* File Name: ThreadDeadlock.java
* Create Date: Sep 3, 2016
* Create Time: 12:01:37 AM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.audienceScience;

public class ThreadDeadlock {

	String str1 = "Java";
    String str2 = "UNIX";
    int i = 0; 
    int j = 0; 
     
    Thread trd1 = new Thread("My Thread 1"){
        public void run(){
            while(true){
                synchronized(str1){
                    synchronized(str2){
                        System.out.println("i= "+ i++ +" "+str1 + str2);
                        
                    }
                }
            }
        }
    };
     
    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
            while(true){
                synchronized(str2){
                    synchronized(str1){
                        System.out.println("j= "+ j++ +" "+str2 + str1);
                    }
                }
            }
        }
    };
     
    public static void main(String a[]){
    	ThreadDeadlock tdl = new ThreadDeadlock();
        tdl.trd1.start();
        tdl.trd2.start();
    }
	
}
