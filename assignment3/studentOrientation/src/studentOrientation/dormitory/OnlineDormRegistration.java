package studentOrientation.dormitory;

import studentOrientation.activityExpenses.CaloriesI;
import studentOrientation.activityExpenses.CarbonCostI;
import studentOrientation.activityExpenses.CurrencyCostI;
import studentOrientation.activityExpenses.DurationI;

public class OnlineDormRegistration
		implements DormitoryRegistrationI, CaloriesI, CarbonCostI, CurrencyCostI, DurationI {
	private static final int AVG_REGISTRATION_DURATION = 10;
	private static final int AVG_CALORIES_SPENT = 30;
	private static final double AVG_CARBON_COST = 0.08;
	private static final double SURCHARGE_PERCENTAGE = 2;
	private static final String DESCRIPTION  = "Register for Dorm. Compete against others in an online game to get a room based on your performance.";
	@Override
	public int getActivityDuration() {
		return AVG_REGISTRATION_DURATION;
	}

	@Override
	public double getCostInUSD() {
		double total = 0;
		for(DormFees fee : DormFees.values())
			total += fee.getFeeAmount();
		return (1.0+SURCHARGE_PERCENTAGE/100.0)*total;
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
	public String getCommunityName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getRoomNumber() {
		throw new UnsupportedOperationException();
	}

	@Override
	public double getSurchargePercentage() {
		return  SURCHARGE_PERCENTAGE;
	}

	@Override
	public String getDescription() {
		StringBuilder sb = new StringBuilder();
		sb.append("Online Dorm Registration");
		sb.append("\n" + DESCRIPTION);
		sb.append("\nAverage time: " + AVG_REGISTRATION_DURATION + " minutes");
		sb.append("\nAverage Calories spent: " + AVG_CALORIES_SPENT + " calories");
		sb.append("\nAverage carbon cost:" + AVG_CARBON_COST + " tonnnes");
		sb.append("\nCost of Registration(USD):" + getCostInUSD());
		return sb.toString();
	}
}
