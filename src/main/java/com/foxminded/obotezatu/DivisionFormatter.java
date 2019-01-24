package com.foxminded.obotezatu;

import java.util.Formatter;
import java.util.Iterator;

public class DivisionFormatter {

	public String format(DivisionResult divisionResult) {
		if ((divisionResult.getDividend() < divisionResult.getDivider()) || divisionResult.getDividend() == 0) {
			return "0";
		}
		String dash = "--";
		int dividendLength = String.valueOf(divisionResult.getDividend()).length();
		StringBuilder indent = new StringBuilder();
		StringBuilder formattedResult = new StringBuilder();
		Iterator<Step> stepsIterator = divisionResult.getSteps().iterator();
		Step currentStep = stepsIterator.next();
		if (currentStep.getDividerMultiple() == 0) {
			currentStep = stepsIterator.next();
		}
		try (Formatter divisionFormatter = new Formatter(formattedResult)) {
			divisionFormatter.format("_%" + dividendLength + "d | %d%n", divisionResult.getDividend(),
					divisionResult.getDivider());
			divisionFormatter.format(" %-" + dividendLength + "d |--------%n", currentStep.getDividerMultiple());
			divisionFormatter.format(" %-" + dividendLength + "s | %d%n", dash, divisionResult.getResult());
			while (stepsIterator.hasNext()) {
				currentStep = stepsIterator.next();
				if (currentStep.getPartialDividend() != 0 && currentStep.getDividerMultiple() != 0) {
					indent.append(" ");
					divisionFormatter.format("%s_%s%n", indent, currentStep.getPartialDividend());
					divisionFormatter.format("%s% d%n", indent, currentStep.getDividerMultiple());
					divisionFormatter.format(" %s%s%n", indent, dash);
				} else {
					indent.append(" ");
				}
			}
			indent.append(" ");
			divisionFormatter.format("%s% d", indent,
					(currentStep.getPartialDividend() - currentStep.getDividerMultiple()));
		}
		return formattedResult.toString();
	}
}