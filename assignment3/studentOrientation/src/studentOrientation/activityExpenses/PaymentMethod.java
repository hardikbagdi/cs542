package studentOrientation.activityExpenses;

public enum PaymentMethod {
	CASH("Cash"), CHEQUE("Cheque"), CREDIT_CARD("Credit Card"), BANK_TRANSFER("Bank Transfer");

	private final String value;

	PaymentMethod(String value_in) {
		value = value_in;
	}

	public String getValue() {
		return value;
	}
}
