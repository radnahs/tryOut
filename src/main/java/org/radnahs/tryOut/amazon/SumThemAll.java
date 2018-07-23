package org.radnahs.tryOut.amazon;

public class SumThemAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = sum(new int[]{12,12});
		System.out.println(sum);
	}

	static int sum(int[] numbers){
		int sum = 0;
		for(int i :numbers){
			sum+=i;
		}
		return sum;
	}
}
