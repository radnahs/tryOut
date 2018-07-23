package org.radnahs.tryOut.thoughtworks.merchantToGalaxy.trialAndError;

import java.util.HashMap;
import java.util.Map;

public class RomanToDecimal {

	public static void main(String args[]) {
        romanToDecimal("XIV");
        romanToDecimal("VVVV");
        /*romanToDecimal("MCMXLIV");
        romanToDecimal("MMVI");
        romanToDecimal("MMVI");*/
        /*System.out.println(rtoi("XIV"));
        System.out.println(rtoi("VVVV"));*/
        RomanToDecimal rtd = new RomanToDecimal();
        //convertToDecimal();
    }
	
	public static void romanToDecimal(String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();
        /* operation to be performed on upper cases even if user enters roman values in lower case chars */
        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        System.out.println(decimal);
    }

    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }
    
    private static Map<Character, Integer> hm = new HashMap<Character, Integer>();

    public static int rtoi(String num) {       
    	hm.put('I',1);
        hm.put('X',10);
        hm.put('C',100);
        hm.put('M',1000);
        hm.put('V',5);
        hm.put('L',50);
        hm.put('D',500);
        int intNum=0;
        int prev = 0;
        for(int i = num.length()-1; i>=0 ; i--){
                int temp = hm.get(num.charAt(i));
                if(temp < prev)
                    intNum-=temp;
                else
                    intNum+=temp;
                prev = temp;
        }
        return intNum;
    }

    
    static String romanNumeral;
    static int decimalNum;
    
    public void convertToDecimal (String romanNumeral) {
        romanNumeral = romanNumeral.toUpperCase();
        int l=  romanNumeral.length();
        int num=0;
        int previousnum = 0;
        for (int i=l-1;i>=0;i--)  { 
                char x =  romanNumeral.charAt(i);
                x = Character.toUpperCase(x);
                switch(x) {  
                        case 'I':
                        previousnum = num;
                        num = 1;
                        break;
                     case 'V':
                             previousnum = num;
                        num = 5;
                        break;
                        case 'X':
                                previousnum = num;
                        num = 10;
                        break;
                        case 'L':
                                previousnum = num;
                        num = 50;
                        break;
                        case 'C':
                                previousnum = num;
                        num = 100;
                        break;
                        case 'D':
                                previousnum = num;
                        num = 500;
                        break;
                        case 'M':
                                previousnum = num;
                        num = 1000;
                        break;
                }           
                if (num<previousnum){
                	decimalNum= decimalNum-num;
                }else
                	decimalNum= decimalNum+num;
        	}
		}
		public static void printRoman (String romanNumeral){
		        System.out.println ("The equivalent of the Roman numeral "+romanNumeral+" is "+decimalNum);
		}
		
		public static void printDecimal (int decimalNum){
		        System.out.println ("Decimal Number stored is: " + decimalNum);
}

}
