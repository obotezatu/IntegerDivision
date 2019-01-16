package com.foxminded.obotezatu;

import static org.junit.Assert.*;
import org.junit.Test;

public class IntegerDivisionTest {

	@Test(expected = ArithmeticException.class)
	public void testDivideDividerZero() {

		Division divisionResult = new Division();
		divisionResult.divide(78945, 0);
	}

	@Test
	public void testDivisionDivide() {
		Division division = new Division();
		long actualDivisionResult = division.divide(78945, 4).getFinalDivideResult();
		assertEquals(19736, actualDivisionResult);
	}
}
