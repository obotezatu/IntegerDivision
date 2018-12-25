package com.foxminded.obotezatu;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerDivisionTest {
	
	@Test (expected = ArithmeticException.class )
	public void testDivideDividerZero() {
		
		Division divisionResult = new Division(); 
		divisionResult.divide(12456, 0);		
	}
}


