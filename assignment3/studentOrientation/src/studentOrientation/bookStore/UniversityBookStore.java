package studentOrientation.bookStore;

import studentOrientation.activityExpenses.CaloriesI;
import studentOrientation.activityExpenses.CarbonCostI;
import studentOrientation.activityExpenses.CurrencyCostI;
import studentOrientation.activityExpenses.DurationI;

public class UniversityBookStore implements BookStoreI, CaloriesI, CarbonCostI, CurrencyCostI, DurationI {
	private static final int AVG_CUSTOMER_DURATION = 35;
	private static final int AVG_CALORIES_SPENT = 200;
	private static final double AVG_CARBON_COST = 0.04;
	private static final String storeName = "University Book-Store";

	@Override
	public int getActivityDuration() {
		return AVG_CUSTOMER_DURATION;
	}

	@Override
	public double getCostInUSD() {
		double totalCost = 0;
		for (Books book : Books.values()) {
			totalCost += book.getPrice();
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
		throw new UnsupportedOperationException();
	}

	@Override
	public String getStoreName() {
		return storeName;
	}

	@Override
	public String getDescription() {
		StringBuilder sb = new StringBuilder();
		sb.append(getStoreName());
		sb.append("\nEvery book you need.");
		sb.append("\nAverage time: " + AVG_CUSTOMER_DURATION + " minutes");
		sb.append("\nAverage Calories spent: " + AVG_CALORIES_SPENT + " calories");
		sb.append("\nAverage carbon cost:" + AVG_CARBON_COST + " tonnnes");
		sb.append("\nCost of books(USD):" + getCostInUSD());
		return sb.toString();
	}

}
