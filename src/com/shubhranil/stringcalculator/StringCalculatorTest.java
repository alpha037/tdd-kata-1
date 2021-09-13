package com.shubhranil.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {
	
	@Test
	public void testWithEmptyString() {
		assertEquals(0, new StringCalculator().add(""));
	}
	
	@Test
	public void testWithOneNumber() {
		assertEquals(1, new StringCalculator().add("1"));
	}
	
	@Test
	public void testWithTwoNumbers() {
		assertEquals(3, new StringCalculator().add("1,2"));
	}
	
	@Test
	public void testWithMultipleNumbers() {
		assertEquals(15, new StringCalculator().add("1,2,3,4,5"));
	}
	
	@Test
	public void testWithNewLineDelimeter() {
		assertEquals(6, new StringCalculator().add("1\n2,3"));
	}
	
	@Test
	public void testWithMultipleDelimiters() {
		assertEquals(3, new StringCalculator().add("//;\n1;2"));
	}
	
	@Test
	public void testWithNegativeNumber() {
		try {
			new StringCalculator().add("-1,2");
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "Negatives not allowed: -1");
		}
	}
	
	@Test
	public void testWithMultipleNegativeNumbers() {
		try {
			new StringCalculator().add("-1,-2,-3,-5,6,7,8");
		} catch (IllegalArgumentException ex) {
			assertEquals(
				ex.getMessage(), "Negatives not allowed: -1,-2,-3,-5"
			);
		}
	}
}
