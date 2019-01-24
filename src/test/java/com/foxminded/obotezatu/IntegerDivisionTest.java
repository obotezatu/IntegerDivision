package com.foxminded.obotezatu;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class IntegerDivisionTest {

	Division division;

	@Before
	public void setUp() {
		division = new Division();
	}

	@Test(expected = ArithmeticException.class)
	public void testDivideByZero() {
		division.divide(78945, 0);
	}

	@Test
	public void testNumberDivision() {
		long actualDivisionResult = division.divide(78945, 4).getResult();
		assertEquals(19736, actualDivisionResult);
	}
	
	@Test
	public void testThousandsDivision() {
		long actualDivisionResult = division.divide(10000, 10).getResult();
		assertEquals(1000, actualDivisionResult);
	}
	
	@Test
	public void testSmallToBigDivision() {
		long actualDivisionResult = division.divide(123, 456).getResult();
		assertEquals(0, actualDivisionResult);
	}
}
