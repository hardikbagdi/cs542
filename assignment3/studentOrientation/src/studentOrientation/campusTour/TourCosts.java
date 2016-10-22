package studentOrientation.campusTour;

//keep this package private, a single place for all touring costs
enum TourCosts {
	BUS_TOUR(2.00), WALKING_TOUR(0.50);

	private final double value;

	private TourCosts(double value_in) {
		value = value_in;
	}

	public double getCost() {
		return value;
	}
}
