package com.foxminded.obotezatu;

import java.util.Iterator;

public class DivisionFormatter {

	final private String DASH = "--";
	
	public String format(DivisionResult divisionResult) {
		if ((divisionResult.getDividend() < divisionResult.getDivider()) || divisionResult.getDividend() == 0) {
			return "0";
		}
		StringBuilder formattedResult = new StringBuilder();
		Iterator<Step> stepsIterator = divisionResult.getSteps().iterator();
		formattedResult.append(formatHead(divisionResult, stepsIterator)).append(formatBody(divisionResult, stepsIterator));
		return formattedResult.toString();
	}

	private String formatHead(DivisionResult divisionResult, Iterator<Step> stepsIterator) {
		int dividendLength = String.valueOf(divisionResult.getDividend()).length();
		StringBuilder formattedResult = new StringBuilder();
		Step currentStep = stepsIterator.next();
		if (currentStep.getDividerMultiple() == 0) {
			currentStep = stepsIterator.next();
		}
		formattedResult.append(String.format("_%" + dividendLength + "d | %d%n", divisionResult.getDividend(),
				divisionResult.getDivider()));
		formattedResult
				.append(String.format(" %-" + dividendLength + "d |--------%n", currentStep.getDividerMultiple()));
		formattedResult.append(String.format(" %-" + dividendLength + "s | %d%n", DASH, divisionResult.getResult()));
		return formattedResult.toString();
	}

	private String formatBody(DivisionResult divisionResult, Iterator<Step> stepsIterator) {
		StringBuilder formattedResult = new StringBuilder();
		StringBuilder indent = new StringBuilder();
		Step currentStep = new Step();
		while (stepsIterator.hasNext()) {
			currentStep = stepsIterator.next();
			indent.append(" ");
			if (currentStep.getPartialDividend() != 0 && currentStep.getDividerMultiple() != 0) {
				formattedResult.append(String.format("%s_%s%n", indent, currentStep.getPartialDividend()));
				formattedResult.append(String.format("%s% d%n", indent, currentStep.getDividerMultiple()));
				formattedResult.append(String.format(" %s%s%n", indent, DASH));
			} 
		}
		indent.append(" ");
		formattedResult.append(
				String.format("%s% d", indent, (currentStep.getPartialDividend() - currentStep.getDividerMultiple())));
		return formattedResult.toString();
	}
}