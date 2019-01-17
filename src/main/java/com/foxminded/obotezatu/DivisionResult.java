package com.foxminded.obotezatu;

import java.util.ArrayList;
import java.util.List;

public class DivisionResult {
	private long dividend;
	private long divider;
	private List<Step> steps = new ArrayList<>();

	public long getDividend() {
		return dividend;
	}

	public void setDividend(long dividend) {
		this.dividend = dividend;
	}

	public long getDivider() {
		return divider;
	}

	public void setDivider(long divider) {
		this.divider = divider;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public long getFinalDivideResult() {
		long finalDivideResult = 0;
		for (Step step : steps) {
			finalDivideResult = (finalDivideResult * 10) + step.getDivideResult();
		}
		return finalDivideResult;
	}

	@Override
	public boolean equals(Object someObject) {
		if (someObject == this) {
			return true;
		}
		if (!(someObject instanceof DivisionResult)) {
			return false;
		}
		DivisionResult divisionResult = (DivisionResult) someObject;

		return Long.compare(this.getDividend(), divisionResult.getDividend()) == 0
				&& Long.compare(this.getDivider(), divisionResult.getDivider()) == 0
				&& steps.equals(divisionResult.steps);
	}
}
