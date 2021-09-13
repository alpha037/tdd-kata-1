package com.shubhranil.stringcalculator;

public class StringCalculator {
	
	public int add(String numbers) {
		if (numbers.equals("")) return 0;
		
		String[] numbersList = numbers.split("[,\n]");
		return sum(numbersList);
	}
	
	private int sum(String[] numbersList) {
		int sum = 0;
		for (String number : numbersList) sum += Integer.parseInt(number);
		return sum;
	}
}
