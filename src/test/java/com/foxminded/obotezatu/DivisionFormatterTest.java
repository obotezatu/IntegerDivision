package com.foxminded.obotezatu;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DivisionFormatterTest {

	Division division;
	DivisionFormatter divisionFormatter;
	StringBuilder expected;

	@Before
	public void setUp() {
		division = new Division();
		divisionFormatter = new DivisionFormatter();
		expected = new StringBuilder();
	}

	@Test
	public void testDivisionFormatterFormat() {
		expected.append("_78945 | 4").append(System.lineSeparator());
		expected.append(" 4     |--------").append(System.lineSeparator());
		expected.append(" --    | 19736").append(System.lineSeparator());
		expected.append(" _38").append(System.lineSeparator());
		expected.append("  36").append(System.lineSeparator());
		expected.append("  --").append(System.lineSeparator());
		expected.append("  _29").append(System.lineSeparator());
		expected.append("   28").append(System.lineSeparator());
		expected.append("   --").append(System.lineSeparator());
		expected.append("   _14").append(System.lineSeparator());
		expected.append("    12").append(System.lineSeparator());
		expected.append("    --").append(System.lineSeparator());
		expected.append("    _25").append(System.lineSeparator());
		expected.append("     24").append(System.lineSeparator());
		expected.append("     --").append(System.lineSeparator());
		expected.append("      1");
		assertEquals(expected.toString(), divisionFormatter.format(division.divide(78945, 4)));
	}

	@Test
	public void testThousandsDivisionFormatterFormat() {
		expected.append("_10000 | 10").append(System.lineSeparator());
		expected.append(" 10    |--------").append(System.lineSeparator());
		expected.append(" --    | 1000").append(System.lineSeparator());
		expected.append("     0");
		assertEquals(expected.toString(), divisionFormatter.format(division.divide(10000, 10)));
	}

	@Test
	public void testZeroDivisionFormatterFormat() {
		String expected = "0";
		assertEquals(expected.toString(), divisionFormatter.format(division.divide(0, 4)));
	}
}
