package org.radnahs.tryOut.thoughtworks.merchantToGalaxy.trialAndError;

import java.util.HashMap;
import java.util.Map;

public class Validator {

	private Map<Character, Integer> romanNumeralMap = new HashMap<Character, Integer>();
	private int decimal;
	
	private boolean isRomanNumeral(String romanNumber){
		boolean isNum = false;
		String regex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
		if(romanNumber.matches(regex)){
			System.out.println(romanNumber);
			isNum = true;
		}
		return isNum;
	}
	
	// insert roman symbol values in symbol table
	private void insertSymbolValues() {
		romanNumeralMap.put('I', 1);
		romanNumeralMap.put('V', 5);
		romanNumeralMap.put('X', 10);
		romanNumeralMap.put('L', 50);
		romanNumeralMap.put('C', 100);
		romanNumeralMap.put('D', 500);
		romanNumeralMap.put('M', 1000);
	}

	/**
	 * parsing the roman numeral value into decimal value
	 **/
	private int parseRomanToNumber(String symbols) {
		if (symbols == null)
			return 0;
		if (symbols.length() == 1) {
			return romanNumeralMap.get(symbols.charAt(0));
		}
		decimal = 0;
		// boolean flag = true;
		for (int i = 0; i < symbols.length(); i++) {
			if (i + 1 < symbols.length()) {
				if (romanNumeralMap.get(symbols.charAt(i)) >= romanNumeralMap.get(symbols.charAt(i + 1))) {
					decimal = decimal + romanNumeralMap.get(symbols.charAt(i));
				} else {
					// subtracting the decimal value of the roman numeral as it
					// is smaller than it's next one.
					decimal = decimal + (romanNumeralMap.get(symbols.charAt(i + 1)) - romanNumeralMap.get(symbols.charAt(i)));
					i++;
				}
			} else {
				decimal = decimal + romanNumeralMap.get(symbols.charAt(i));
			}
		}
		return decimal;
	}

}
