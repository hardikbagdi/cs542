package studentOrientation.bookStore;

import studentOrientation.activityExpenses.CaloriesI;
import studentOrientation.activityExpenses.CarbonCostI;
import studentOrientation.activityExpenses.CurrencyCostI;
import studentOrientation.activityExpenses.DurationI;

public class MandBookStore implements BookStoreI, CaloriesI, CarbonCostI, CurrencyCostI, DurationI {
	private static final int AVG_CUSTOMER_DURATION = 15;
	private static final int AVG_CALORIES_SPENT = 100;
	private static final double AVG_CARBON_COST = 0.004;
	private static final String storeName = "Mando Book-Store";

	// private static final
	@Override
	public int getActivityDuration() {
		return AVG_CUSTOMER_DURATION;
	}

	@Override
	public double getCostInUSD() {
		double totalCost = 0;
		for (Books book : Books.values()) {
			totalCost += (1.05) * book.getPrice();
		}
		return totalCost;
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
	public void buyBook() {
		// placeholder method
	}

	@Override
	public String getStoreName() {
		return storeName;
	}

}
