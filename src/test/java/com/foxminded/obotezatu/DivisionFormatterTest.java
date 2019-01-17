package com.foxminded.obotezatu;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DivisionFormatterTest {
	@Test
	public void testDivisionFormatterFormat() {
		Division division = new Division();
		DivisionFormatter divisionFormatter = new DivisionFormatter();
		StringBuilder expectedFormattedResult = new StringBuilder();
		expectedFormattedResult.append("_78945 | 4\r\n");  // For windows use \r\n, for Linux \n
		expectedFormattedResult.append(" 4     |--------\r\n");
		expectedFormattedResult.append(" --    | 19736\r\n");
		expectedFormattedResult.append(" _38\r\n");
		expectedFormattedResult.append("  36\r\n");
		expectedFormattedResult.append("  --\r\n");
		expectedFormattedResult.append("  _29\r\n");
		expectedFormattedResult.append("   28\r\n");
		expectedFormattedResult.append("   --\r\n");
		expectedFormattedResult.append("   _14\r\n");
		expectedFormattedResult.append("    12\r\n");
		expectedFormattedResult.append("    --\r\n");
		expectedFormattedResult.append("    _25\r\n");
		expectedFormattedResult.append("     24\r\n");
		expectedFormattedResult.append("     --\r\n");
		expectedFormattedResult.append("     1");
		assertEquals(expectedFormattedResult.toString(), divisionFormatter.format(division.divide(78945, 4)));
	}
}
