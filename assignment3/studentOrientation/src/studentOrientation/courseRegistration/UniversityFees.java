package studentOrientation.courseRegistration;

public enum UniversityFees {
	TUITIOM("Tuition Fees", 1000.0), MISCELLANIOUS("Miscellaneous fees", 100.0);

	private String feeType;
	private double amount;

	private UniversityFees(String fee_in, double amount_in) {
		this.feeType = fee_in;
		this.amount = amount_in;
	}

	public String getFeeType() {
		return feeType;
	}

	public double getFeeAmount() {
		return amount;
	}
}
