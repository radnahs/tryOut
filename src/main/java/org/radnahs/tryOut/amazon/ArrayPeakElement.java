package org.radnahs.tryOut.amazon;

public class ArrayPeakElement {

	public static void main(String[] args) {
		ArrayPeakElement ape = new ArrayPeakElement();
		ape.peakElement(new String[]{"9","1","2","3","4","5","6","8","7","5","3"});
	}
	
	private int peakElement(String[] strArr){
		int peak=0;
		for (String i : strArr) {
			int k = Integer.parseInt(i);
			if(peak<k){
				peak=k;
			}
		}	
		System.out.println(peak);
		return peak;
	}

}
