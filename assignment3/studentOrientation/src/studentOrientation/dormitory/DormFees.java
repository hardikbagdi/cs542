package studentOrientation.dormitory;

public enum DormFees {
	BASE_FARE("Base Fare", 10000.0), MEAL_PLAN("Meal plan", 1000.0);

	private String feeType;
	private double amount;

	private DormFees(String fee_in, double amount_in) {
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
