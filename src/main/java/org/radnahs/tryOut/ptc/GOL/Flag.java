package org.radnahs.tryOut.ptc.GOL;

/**
 * Monitor to set the start and stop of the algorithm
 * @author Martella Massimiliano
 *
 */
public class Flag {
	
	private boolean isSet;
	
	public Flag(){
		isSet = false;
	}
	
	public synchronized void set(){
		isSet = true;
	}
	
	public synchronized boolean isSet(){
		return isSet;
	}
	
	public synchronized void reset(){
		isSet = false;
	}
}

