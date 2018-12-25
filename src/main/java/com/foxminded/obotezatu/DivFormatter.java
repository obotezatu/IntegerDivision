package com.foxminded.obotezatu;

import java.util.Formatter;

public class DivFormatter {

	public String format(DivisionResult divisionResult) {
		if (divisionResult.getSteps().isEmpty()) {
			return "0";
		}
		char dash = '-';
		int dividendLength = String.valueOf(divisionResult.getDividend()).length();
		StringBuilder indent = new StringBuilder();
		StringBuilder formattedResult = new StringBuilder();
		try (Formatter divisionFormatter = new Formatter(formattedResult)) {
			divisionFormatter.format("_%" + dividendLength + "d | %d%n", divisionResult.getDividend(), divisionResult.getDivider());
			divisionFormatter.format(" %-" + dividendLength + "d |--------%n", divisionResult.getSteps().get(0).getDividerMultiple());
			divisionFormatter.format(" %-" + dividendLength + "s | %d%n", dash, divisionResult.getSteps().get(0).getDivideResult());

			for (int i = 1; i < divisionResult.getSteps().size(); i++) {
				indent.append(" ");
				divisionFormatter.format("%s_%s%n", indent, divisionResult.getSteps().get(i).getPartialDividend());
				divisionFormatter.format("%s% d%n", indent, divisionResult.getSteps().get(i).getDividerMultiple());
				divisionFormatter.format(" %s%s%n", indent, dash);
			}
			divisionFormatter.format("%s% d%n", indent,
					(divisionResult.getSteps().get(divisionResult.getSteps().size() - 1).getPartialDividend()) - (divisionResult.getSteps().get(divisionResult.getSteps().size() - 1).getDividerMultiple()));
		}
		return formattedResult.toString();
	}
}
