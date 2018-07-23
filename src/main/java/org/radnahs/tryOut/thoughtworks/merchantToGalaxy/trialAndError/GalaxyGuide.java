package org.radnahs.tryOut.thoughtworks.merchantToGalaxy.trialAndError;

import java.util.HashMap;

public class GalaxyGuide {
	/**
	 * Creating symbol table for parsing roman numeral values to decimal nums:
	 * key value entry to keep track of inputs given goods: key value entry to
	 * decode the message and store the Credit value corresponding to the good
	 * stuff.
	 **/
	private HashMap<Character, Integer> symbol_table = new HashMap<Character, Integer>();
	private HashMap<String, String> nums = new HashMap<String, String>();
	private HashMap<String, String> goods = new HashMap<String, String>();

	private String key;
	private String val;
	private String message_symbols;
	private String message_txt;
	private int num_values;
	private double good_values;
	private int decimal;
	private String good_name;

	// insert roman symbol values in symbol table
	private void insertSymbolValues() {
		symbol_table.put('I', 1);
		symbol_table.put('V', 5);
		symbol_table.put('X', 10);
		symbol_table.put('L', 50);
		symbol_table.put('C', 100);
		symbol_table.put('D', 500);
		symbol_table.put('M', 1000);
	}

	/**
	 * parsing the roman numeral value into decimal value
	 **/
	private int parse(String symbols) {
		if (symbols == null)
			return 0;
		if (symbols.length() == 1) {
			return symbol_table.get(symbols.charAt(0));
		}
		decimal = 0;
		// boolean flag = true;
		for (int i = 0; i < symbols.length(); i++) {
			if (i + 1 < symbols.length()) {
				if (symbol_table.get(symbols.charAt(i)) >= symbol_table.get(symbols.charAt(i + 1))) {
					decimal = decimal + symbol_table.get(symbols.charAt(i));
				} else {
					// subtracting the decimal value of the roman numeral as it
					// is smaller than it's next one.
					decimal = decimal + (symbol_table.get(symbols.charAt(i + 1)) - symbol_table.get(symbols.charAt(i)));
					i++;
				}
			} else {
				decimal = decimal + symbol_table.get(symbols.charAt(i));
			}
		}
		return decimal;
	}

	/**
	 * To Decode the message and conclude accordingly. it may be a hidden data
	 * entry to goods. it may be a question whose output is required.
	 **/
	void processMessage(String[] message, int words) {
		// handling "glob is I" type of input message
		if (words == 3 && message[1].equalsIgnoreCase("is")) {
			key = null;
			val = null;
			try {
				key = message[0];
				val = message[words - 1];
				// to check whether a valid roman numeral
				if (parse(val) / 1 == 1) {
				}
			} catch (NumberFormatException e) {
				System.out.println(message[words - 2] + "is not a valid numeric value.");
			} catch (Exception e) {
				System.out.println("I've no idea what you are talking about");
			}
			nums.put(key, val);
			return;

		}
		// handling "glob glob silver is 34 credits" type of input messages
		if (words > 4 && message[words - 1].equalsIgnoreCase("credits") && message[words - 3].equalsIgnoreCase("is")) {
			message_symbols = "";
			key = null;
			val = null;
			try {
				key = message[words - 4];
				val = message[words - 2];
			} catch (Exception e) {
				System.out.println(message[words - 2] + " is not a valid numeric value.");
			}
			// getting the part of message to be parsed
			for (int i = 0; i < words - 4; i++) {
				if (nums.get(message[i]) != null)
					message_symbols = message_symbols + nums.get(message[i]);
				else {
					System.out.println(message[i] + " is not a valid symbol.");
					return;
				}
			}
			num_values = -1;
			num_values = parse(message_symbols);
			if (num_values > 0)
				// making entry to the goods
				goods.put(key, String.valueOf(((double) (Double.valueOf(val) / num_values))));
			else
				System.out.println(val + " is not a valid Galactic number.");
			return;
		}
		// handling "how many credits is glob prok silver ?" type of input
		// questions
		if (words > 4 && message[0].equalsIgnoreCase("how") && message[1].equalsIgnoreCase("many")
				&& message[2].equalsIgnoreCase("credits") && message[3].equalsIgnoreCase("is")) {
			message_symbols = "";
			good_name = null;
			message_txt = "";
			if (message[words - 1].equals("?"))
				words--;
			good_name = message[words - 1];
			// getting the part of message to be parsed
			for (int i = 4; i < words - 1; i++) {
				if (nums.get(message[i]) != null) {
					message_symbols = message_symbols + nums.get(message[i]);
					message_txt = message_txt + message[i] + " ";
				} else {
					System.out.println(message[i] + " is not a valid symbol.");
					return;
				}
			}
			num_values = -1;
			num_values = parse(message_symbols);
			if (num_values > 0) {
				good_values = Double.valueOf((goods.get(good_name)));
				if (good_values != 0) {
					System.out.println(good_name + " is not a valid Galactic number.");
					System.out.println(message_txt + " " + good_name + " is " + num_values * good_values + " credits");
				} else {
					System.out.println(good_name + " is not a valid Galactic number.");
				}
			} else
				System.out.println(message_symbols + " is not a valid Galactic number.");
			return;
		}
		// handling "how much is pish tegj glob glob ?" type of input questions
		if (words > 4 && message[0].equalsIgnoreCase("how") && message[1].equalsIgnoreCase("much")
				&& message[2].equalsIgnoreCase("is")) {
			message_symbols = "";
			message_txt = "";
			if (message[words - 1].equals("?"))
				words--;
			// getting the part of message to be parsed
			for (int i = 3; i < words; i++) {
				if (nums.get(message[i]) != null) {
					message_symbols = message_symbols + nums.get(message[i]);
					message_txt = message_txt + message[i] + " ";
				} else {
					System.out.println(message[i] + " is not a valid symbol.");
					return;
				}
			}
			num_values = -1;
			num_values = parse(message_symbols);
			if (num_values > 0) {
				System.out.println(message_txt + " is " + num_values + " credits");
			} else
				System.out.println(message_symbols + " is not a valid Galactic number.");
			return;
		}

		System.out.println("I've no idea what you are talking about");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GalaxyGuide guide = new GalaxyGuide();
		// initializing symbol table
		guide.insertSymbolValues();

		// Declaring message strings to save and create string array to process
		String[] galactic_message = new String[100];
		String[] input_message = new String[10];
		int i = 0, j = 0, start_index = 0, words = 0;
		String temp = null;
		// Initilizing input messages
		galactic_message[0] = "glob is I";
		galactic_message[1] = "prok is V";
		galactic_message[2] = "pish is X";
		galactic_message[3] = "tegj is L";
		galactic_message[4] = "glob glob silver is 34 credits";
		galactic_message[5] = "glob prok gold is 57800 credits";
		galactic_message[6] = "pish pish iron is 3910 credits";
		galactic_message[7] = "how much is pish tegj glob glob ?";
		galactic_message[8] = "how many credits is glob prok silver ?";
		galactic_message[9] = "how many credits is glob prok iron ?";
		galactic_message[10] = "asd";
		galactic_message[11] = "how much is pish pish pish glob ?";
		galactic_message[12] = "how much is glob pish glob glob ?";
		galactic_message[13] = "how many is credits is glob pish silver ?";
		
		// iterating over the input messages and passing it to process
		while (galactic_message[j] != null && j < galactic_message.length) {
			temp = galactic_message[j];
			start_index = 0;
			words = 0;
			// Building input string array from input message string.
			for (i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) == ' ' || i == temp.length() - 1) {
					if (i == temp.length() - 1)
						i++;
					input_message[words] = temp.substring(start_index, i);
					start_index = i + 1;
					words++;
				}

			}
			j++;
			// Send input message string for processing.
			guide.processMessage(input_message, words);
		}
	}

}
