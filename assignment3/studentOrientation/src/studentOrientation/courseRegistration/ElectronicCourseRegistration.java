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

	@Override
	public int getActivityDuration() {
		return AVG_REGISTRATION_DURATION;
	}

	@Override
	public double getCostInUSD() {
		// TODO Auto-generated method stub
		return 0;
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

	}

	@Override
	public void getSurcharge() {

	}

	@Override
	public PaymentMethod getPaymentMethod() {
		return PaymentMethod.CREDIT_CARD;
	}

}
