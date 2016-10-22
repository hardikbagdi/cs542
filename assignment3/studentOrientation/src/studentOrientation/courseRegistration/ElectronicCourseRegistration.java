package studentOrientation.courseRegistration;

import studentOrientation.activityExpenses.CaloriesI;
import studentOrientation.activityExpenses.CarbonCostI;
import studentOrientation.activityExpenses.CurrencyCostI;
import studentOrientation.activityExpenses.DurationI;
import studentOrientation.activityExpenses.PaymentMethod;

public class ElectronicCourseRegistration
		implements CourseRegistrationI, CaloriesI, CarbonCostI, CurrencyCostI, DurationI {

	private static final int AVG_REGISTRATION_DURATION = 25;
	private static final int AVG_CALORIES_SPENT = 20;
	private static final double AVG_CARBON_COST = 0.08;
	private static String DESCRIPTION = "Register using computers in the Engineering Building.";

	@Override
	public int getActivityDuration() {
		return AVG_REGISTRATION_DURATION;
	}

	@Override
	public double getCostInUSD() {
		int totalcost = 0;
		for (UniversityFees fee : UniversityFees.values())
			totalcost += fee.getFeeAmount();
		return totalcost;
	}

	@Override
	public double getCarbonCostInTonnes() {
		return AVG_CARBON_COST;
	}

	@Override
	public int getCaloriesSpent() {
		return AVG_CALORIES_SPENT;
	}

	@Override
	public void listCourses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public PaymentMethod getPaymentMethod() {
		return PaymentMethod.CREDIT_CARD;
	}

	@Override
	public String getDescription() {
		StringBuilder sb = new StringBuilder();
		sb.append("Online Course Registration");
		sb.append("\n" + DESCRIPTION);
		sb.append("\nAverage time: " + AVG_REGISTRATION_DURATION + " minutes");
		sb.append("\nAverage Calories spent: " + AVG_CALORIES_SPENT + " calories");
		sb.append("\nAverage carbon cost:" + AVG_CARBON_COST + " tonnnes");
		sb.append("\nCost of Registration(USD):" + getCostInUSD());
		sb.append("\nPayment Method:" + getPaymentMethod().getValue());
		return sb.toString();
	}

}
