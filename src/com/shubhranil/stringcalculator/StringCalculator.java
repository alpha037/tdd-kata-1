package com.shubhranil.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	private final String DEFAULT_DELIMITER_REGEX = "[,\n]";
	private final String MULTIPLE_DELIMITER_REGEX = "//(.*)\n(.*)";
	
	public int add(String numbers) {
		if (numbers.equals("")) return 0;
		
		String[] numbersList = split(numbers);
		return sum(numbersList);
	}
	
	private String[] split(String numbers) {
		String delimiter = DEFAULT_DELIMITER_REGEX;
		
		if (numbers.startsWith("//")) {
			Pattern pattern = Pattern.compile(MULTIPLE_DELIMITER_REGEX);
			Matcher matcher = pattern.matcher(numbers);
			if (matcher.find()) {
				delimiter = matcher.group(1);
				numbers = matcher.group(2);
			}
		}
		
		return numbers.split(delimiter);
	}
	
	private int sum(String[] numbersList) {
		int sum = 0;
		for (String number : numbersList) sum += Integer.parseInt(number);
		return sum;
	}
}
