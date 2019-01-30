package com.foxminded.obotezatu;

import java.util.Iterator;
import java.util.ListIterator;

public class DivisionFormatter {

	public String format(DivisionResult divisionResult) {
		if ((divisionResult.getDividend() < divisionResult.getDivider()) || divisionResult.getDividend() == 0) {
			return "0";
		}
		StringBuilder formattedResult = new StringBuilder();
		ListIterator<Step> stepsIterator = divisionResult.getSteps().listIterator();
		formattedResult.append(formatHead(divisionResult, stepsIterator)).append(formatBody(stepsIterator));
		return formattedResult.toString();
	}

	private String formatHead(DivisionResult divisionResult, ListIterator<Step> stepsIterator) {
		int dividendLength = String.valueOf(divisionResult.getDividend()).length();
		StringBuilder formattedResult = new StringBuilder();
		Step currentStep = stepsIterator.next();
		while (currentStep.getDividerMultiple() == 0) {
			currentStep = stepsIterator.next();
		}
		formattedResult.append(String.format("_%" + dividendLength + "d | %d%n", divisionResult.getDividend(),
				divisionResult.getDivider()));
		formattedResult
				.append(String.format(" %-" + dividendLength + "d |--------%n", currentStep.getDividerMultiple()));
		formattedResult.append(String.format(" %-" + dividendLength + "s | %d%n",
				countDashes(currentStep.getPartialDividend()), divisionResult.getResult()));
		return formattedResult.toString();
	}

	private String formatBody(ListIterator<Step> stepsIterator) {
		StringBuilder formattedResult = new StringBuilder();
		StringBuilder indent = new StringBuilder(countIndents(stepsIterator));
		Step currentStep = null;
		while (stepsIterator.hasNext()) {
			currentStep = stepsIterator.next();
			if (currentStep.getPartialDividend() != 0 && currentStep.getDividerMultiple() != 0) {

				formattedResult.append(String.format("%s_%s%n", indent.toString(), currentStep.getPartialDividend()));
				formattedResult.append(String.format("%s% d%n", indent.toString(), currentStep.getDividerMultiple()));
				formattedResult.append(
						String.format(" %s%s%n", indent.toString(), countDashes(currentStep.getPartialDividend())));
				indent.append(countIndents(stepsIterator));
			} else {
				indent.append(" ");
			}
		}
		formattedResult.append(
				String.format("%s% d", indent, (currentStep.getPartialDividend() - currentStep.getDividerMultiple())));
		return formattedResult.toString();
	}

	private String countDashes(long partialDividend) {
		StringBuilder dashes = new StringBuilder();
		int dashCount = String.valueOf(partialDividend).length();
		for (int i = 0; i < dashCount; i++) {
			dashes.append("-");
		}
		return dashes.toString();
	}

	private String countIndents(ListIterator<Step> stepsIterator) {
		stepsIterator.previous();
		Step currentStep = stepsIterator.next();
		long indentCount = countDigits(currentStep);
		StringBuilder indent = new StringBuilder();
		for (int i = 0; i < indentCount; i++) {
			indent.append(" ");
		}
		return indent.toString();
	}

	private long countDigits(Step currentStep) {
		long partialDividentLength = (long) (Math.log10(currentStep.getPartialDividend()) + 1);
		long partialDividentLengthDiff = currentStep.getPartialDividend() - currentStep.getDividerMultiple();
		return partialDividentLengthDiff != 0
				? partialDividentLength - ((long) (Math.log10(partialDividentLengthDiff) + 1))
				: partialDividentLength - 0;
	}
}