/**
 * <p>Project: org.radnahs.tryOut.thoughtworks.merchantToGalaxy.service </p>
 * <p>Package Name: org.radnahs.tryOut.thoughtworks.merchantToGalaxy.service </p>
 * <p>File Name: MessageParser.java </p>
 * <p>Create Date: Apr 18, 2017 </p>
 * <p>Create Time: 9:01:17 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.thoughtworks.merchantToGalaxy.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.radnahs.tryOut.thoughtworks.merchantToGalaxy.util.RomanNumber;

/**
 * @author: Shantanu Sikdar
 */
public class GalacticMessageParser implements IMessageParser {

	private int i=0;
	public Map<String, String> outputMap = new LinkedHashMap<>();
	private Map<String, String> galacticNumRomanNumMap = new HashMap<>();
	private Map<String, String> itemTypes = new HashMap<>();
	
	@Override
	public Map<String, String> parseMessage(String[] message){
		parseMessage(message, message.length);
		return outputMap;
	}
	
	private void parseMessage(String[] message, int words) {
		if (words == 3 && message[1].equalsIgnoreCase("is")){
			parseInputType1Message(message, words);// handling "glob is I" type of input message
			return;
		}
		if (words > 4 && message[words - 1].equalsIgnoreCase("credits") && message[words - 3].equalsIgnoreCase("is")){
			parseInputType2Message(message, words);// handling "glob glob silver is 34 credits" type of input messages
			return;
		}
		if (words > 4 && message[0].equalsIgnoreCase("how") && message[1].equalsIgnoreCase("many") && message[2].equalsIgnoreCase("credits") && message[3].equalsIgnoreCase("is")) {
			parseInputType3Message(message, words);// handling "how many credits is glob prok silver ?" type of input questions
			return;
		}
		if (words > 4 && message[0].equalsIgnoreCase("how") && message[1].equalsIgnoreCase("much") && message[2].equalsIgnoreCase("is")) {
			parseInputType4Message(message, words);// handling "how much is pish tegj glob glob ?" type of input questions
			return;
		}
		
		//System.out.println("I've no idea what you are talking about");
		outputMap.put(i++ +"", "I've no idea what you are talking about");
	}
	
	/**
	 * Parsing "glob is I" type of input message
	 * @param message
	 * @param words
	 */
	private void parseInputType1Message(String[] message, int words){
		String key = null;
		String val = null;
		try {
			key = message[0];
			val = message[words - 1];
			// to check whether a valid roman numeral
			if (RomanNumber.isRomanNumeral(val)) {
			}
		} catch (NumberFormatException e) {
			//System.out.println(message[words - 2] + " is not a valid numeric value.");
			outputMap.put(i++ +"", message[words - 2] + " is not a valid numeric value.");
		} catch (Exception e) {
			//System.out.println("I've no idea what you are talking about");
			outputMap.put(i++ +"", "I've no idea what you are talking about");
		}
		galacticNumRomanNumMap.put(key, val);
	}
	
	/**
	 * Parsing "glob glob silver is 34 credits" type of input messages
	 * @param message
	 * @param words
	 */
	private void parseInputType2Message(String[] message, int words){
		String msgSymbl = "";
		String key = null;
		String val = null;
		try {
			key = message[words - 4];
			val = message[words - 2];
		} catch (Exception e) {
			System.out.println(message[words - 2] + " is not a valid numeric value.");
		}
		// getting the part of message to be parsed
		for (int i = 0; i < words - 4; i++) {
			if (galacticNumRomanNumMap.get(message[i]) != null){
				msgSymbl = msgSymbl + galacticNumRomanNumMap.get(message[i]);
			}else {
				//System.out.println(message[i] + " is not a valid symbol.");
				outputMap.put(i++ +"",message[i] + " is not a valid symbol.");
				return;
			}
		}
		int numValues = -1;
		numValues = RomanNumber.romanToDecimal(msgSymbl);
		if (numValues > 0){
			// making entry to the itemTypes
			itemTypes.put(key, String.valueOf(((double) (Double.valueOf(val) / numValues))));
		}else{
			//System.out.println(val + " is not a valid Galactic number.");
			outputMap.put(i++ +"",val + " is not a valid Galactic number.");
		}
	}
	
	// handling "how many credits is glob prok silver ?" type of input questions
	private void parseInputType3Message(String[] message, int words){
		String msgSymbl = "";
		String itemName = null;
		String msgTxt = "";
		if (message[words - 1].equals("?"))
			words--;
		itemName = message[words - 1];
		// getting the part of message to be parsed
		for (int i = 4; i < words - 1; i++) {
			if (galacticNumRomanNumMap.get(message[i]) != null) {
				msgSymbl = msgSymbl + galacticNumRomanNumMap.get(message[i]);
				msgTxt = msgTxt + message[i] + " ";
			} else {
				//System.out.println(message[i] + " is not a valid symbol.");
				outputMap.put(i++ +"",message[i] + " is not a valid symbol.");
				return;
			}
		}
		int numValues = -1;
		numValues = RomanNumber.romanToDecimal(msgSymbl);
		if (numValues > 0) {
			Double itemValues = Double.valueOf((itemTypes.get(itemName)));
			if (itemValues != 0) {
				//System.out.println(itemName + " is not a valid Galactic number.");
				//outputMap.put(i++ +"",itemName + " is not a valid Galactic number.");
				//System.out.println(msgTxt + " " + itemName + " is " + numValues * itemValues + " credits");
				outputMap.put(i++ +"",msgTxt + " " + itemName + " is " + numValues * itemValues + " credits");
			} else {
				//System.out.println(itemName + " is not a valid Galactic number.");
				outputMap.put(i++ +"",itemName + " is not a valid Galactic number.");
			}
		} else{
			//System.out.println(msgSymbl + " is not a valid Galactic number.");
			outputMap.put(i++ +"",msgSymbl + " is not a valid Galactic number.");
		}
	}

	// handling "how much is pish tegj glob glob ?" type of input questions
	private void parseInputType4Message(String[] message, int words){
		String msgSymbls = "";
		String msgTxt = "";
		if (message[words - 1].equals("?")){
			words--;
		}
		// getting the part of message to be parsed
		for (int i = 3; i < words; i++) {
			if (galacticNumRomanNumMap.get(message[i]) != null) {
				msgSymbls = msgSymbls + galacticNumRomanNumMap.get(message[i]);
				msgTxt = msgTxt + message[i] + " ";
			} else {
				//System.out.println(message[i] + " is not a valid symbol.");
				outputMap.put(i++ +"",message[i] + " is not a valid symbol.");
				return;
			}
		}
		int numValues = -1;
		numValues = RomanNumber.romanToDecimal(msgSymbls);
		if (numValues > 0) {
			//System.out.println(msgTxt + " is " + numValues + " credits");
			outputMap.put(i++ +"",msgTxt + " is " + numValues + " credits");
		} else{
			//System.out.println(msgSymbls + " is not a valid Galactic number.");
			outputMap.put(i++ +"",msgSymbls + " is not a valid Galactic number.");
		}
	}

	public static void main(String[] args) {
		
	}

}
