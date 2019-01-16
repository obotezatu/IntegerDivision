package com.foxminded.obotezatu;

public class Step {

	private long partialDividend;
	private long divideResult;
	private long dividerMultiple;

	public long getDivideResult() {
		return divideResult;
	}

	public void setDivideResult(long divideRezult) {
		this.divideResult = divideRezult;
	}

	public long getPartialDividend() {
		return partialDividend;
	}

	public void setPartialDividend(long partialDivident) {
		this.partialDividend = partialDivident;
	}

	public long getDividerMultiple() {
		return dividerMultiple;
	}

	public void setDividerMultiple(long dividerMultiple) {
		this.dividerMultiple = dividerMultiple;
	}

	@Override
	public boolean equals(Object someObject) {

		if (someObject == this) {
			return true;
		}
		if (!(someObject instanceof Step)) {
			return false;
		}

		Step step = (Step) someObject;

		return Long.compare(this.getPartialDividend(), step.getPartialDividend()) == 0
				&& Long.compare(this.getDivideResult(), step.getDivideResult()) == 0
				&& Long.compare(this.getDividerMultiple(), step.getDividerMultiple()) == 0;
	}
}
