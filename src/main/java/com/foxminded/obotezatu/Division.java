package com.foxminded.obotezatu;

public class Division {

	public DivisionResult divide(long dividend, long divider) {

		DivisionResult divisionResult = new DivisionResult();
		divisionResult.setDividend(dividend);
		divisionResult.setDivider(divider);
		long[] dividendDigits = splitDividend(dividend);
		long partialDividend = 0;
		long dividerMultiple = 0;
		for (int i = 0; i < dividendDigits.length; i++) {
			partialDividend = partialDividend * 10 + dividendDigits[i];
			dividerMultiple = (partialDividend / divider) * divider;
			if (dividerMultiple != 0) {
				Step divisionSteps = new Step();
				divisionSteps.setDivideResult(partialDividend / divider);
				divisionSteps.setPartialDividend(partialDividend);
				divisionSteps.setDividerMultiple(dividerMultiple);
				partialDividend = partialDividend - dividerMultiple;
				divisionResult.getSteps().add(divisionSteps);
			}
		}
		return divisionResult;
	}

	private long[] splitDividend(long dividend) {
		int dividendLength = String.valueOf(dividend).length();
		long[] dividendDigits = new long[dividendLength];
		for (int i = dividendLength - 1; i >= 0; i--) {
			dividendDigits[i] = dividend % 10;
			dividend = dividend / 10;
		}
		return dividendDigits;
	}
}