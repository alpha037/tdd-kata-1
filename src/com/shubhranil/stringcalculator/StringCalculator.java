package com.shubhranil.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
  private static final String DEFAULT_DELIMITER_REGEX = "[,\n]";
  private static final String MULTIPLE_DELIMITER_REGEX = "//(.*)\n(.*)";

  private static int calledCount = 0;

  public static int getCalledCount() {
    return calledCount;
  }

  public static int add(String numbers) {
    ++calledCount;

    if (numbers.equals("")) return 0;

    String[] numbersList = split(numbers);
    return sum(numbersList);
  }

  private static String[] split(String numbers) {
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

  private static int sum(String[] numbersList) {
    int sum = 0;
    String negativeNumbers = "";

    for (String number : numbersList) {
      if (number.isBlank()) continue;

      int numberAsInt = Integer.parseInt(number);
      negativeNumbers +=
          numberAsInt < 0 ? (negativeNumbers.length() == 0 ? number : "," + number) : "";

      if (numberAsInt <= 1000) sum += numberAsInt;
    }

    if (negativeNumbers.length() > 0)
      throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);

    return sum;
  }
}
