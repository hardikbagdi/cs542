package studentOrientation.campusTour;

import studentOrientation.activityExpenses.CaloriesI;
import studentOrientation.activityExpenses.CarbonCostI;
import studentOrientation.activityExpenses.CurrencyCostI;
import studentOrientation.activityExpenses.DurationI;

public class BusRide implements CampusTourI, CaloriesI, CarbonCostI, CurrencyCostI, DurationI {

	private static final int AVG_TOUR_DURATION = 15;
	private static final int AVG_CALORIES_SPENT = 50;
	private static final double AVG_CARBON_COST = 0.4;
	private static final String tourName = "Bearcat Bus Tour";
	private static final String description = "";

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
		return tourName;
	}

	@Override
	public String getDescription() {

		return description;
	}

	@Override
	public void printMap() {
		// placeholder
	}

}
