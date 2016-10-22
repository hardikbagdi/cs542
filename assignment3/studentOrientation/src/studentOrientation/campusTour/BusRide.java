package studentOrientation.campusTour;

import studentOrientation.activityExpenses.CaloriesI;
import studentOrientation.activityExpenses.CarbonCostI;
import studentOrientation.activityExpenses.CurrencyCostI;
import studentOrientation.activityExpenses.DurationI;

public class BusRide implements CampusTourI, CaloriesI, CarbonCostI, CurrencyCostI, DurationI {

	private static final int AVG_TOUR_DURATION = 15;
	private static final int AVG_CALORIES_SPENT = 50;
	private static final double AVG_CARBON_COST = 0.4;
	private static final String TOUR_NAME = "Bearcat Bus Tour";
	private static final String TAG_LINE = "Hop on the bus and get the feel of University campus!";

	@Override
	public int getActivityDuration() {
		return AVG_TOUR_DURATION;
	}

	@Override
	public double getCostInUSD() {
		return TourCosts.BUS_TOUR.getCost();
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
	public String getTourName() {
		return TOUR_NAME;
	}

	@Override
	public String getDescription() {
		StringBuilder sb = new StringBuilder();
		sb.append(getTourName());
		sb.append(TAG_LINE);
		sb.append("\nAverage time: " + AVG_TOUR_DURATION + " minutes");
		sb.append("\nAverage Calories spent: " + AVG_CALORIES_SPENT + " calories");
		sb.append("\nAverage carbon cost:" + AVG_CARBON_COST + " tonnnes");
		sb.append("\nCost of Tour(USD):" + getCostInUSD());
		return sb.toString();
	}

	@Override
	public void printMap() {
		throw new UnsupportedOperationException();
	}

}
