package studentOrientation.dormitory;

import studentOrientation.activityExpenses.CaloriesI;
import studentOrientation.activityExpenses.CarbonCostI;
import studentOrientation.activityExpenses.CurrencyCostI;
import studentOrientation.activityExpenses.DurationI;

public class OfflineDormRegistration
		implements DormitoryRegistrationI, CaloriesI, CarbonCostI, CurrencyCostI, DurationI {

	@Override
	public int getActivityDuration() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCostInUSD() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCarbonCostInTonnes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCaloriesSpent() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommunityName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRoomNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

}
