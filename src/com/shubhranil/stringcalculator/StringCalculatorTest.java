package com.shubhranil.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {
	
	@Test
	public void testWithEmptyString() {
		assertEquals(0, new StringCalculator().add(""));
	}
}
