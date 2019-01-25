package com.foxminded.obotezatu;

public class Division {

	public DivisionResult divide(long dividend, long divider) {
		DivisionResult divisionResult = new DivisionResult();
		divisionResult.setDividend(dividend);
		divisionResult.setDivider(divider);
		long[] dividendDigits = splitDividend(dividend);
		long partialDividend = 0;
		for (long digit : dividendDigits) {
			partialDividend = partialDividend * 10 + digit;
			long dividerMultiple = (partialDividend / divider) * divider;
			Step divisionStep = new Step();
			if (dividerMultiple != 0) {
				  divisionStep.setDivideResult(partialDividend / divider);
				  divisionStep.setPartialDividend(partialDividend);
				  divisionStep.setDividerMultiple(dividerMultiple);
			}
			partialDividend = partialDividend - dividerMultiple;
			divisionResult.getSteps().add(divisionStep);
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

	/*private Step createStep(long partialDividend, long dividerMultiple, long divider) {
		Step divisionStep = new Step();
		divisionStep.setDivideResult(partialDividend / divider);
		divisionStep.setPartialDividend(partialDividend);
		divisionStep.setDividerMultiple(dividerMultiple);
		return divisionStep;
	}*/
}