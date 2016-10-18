package studentOrientation.campusTour;

public class SimpleCampusTourFactory {
	public static CampusTourI createCampusTour(CampusTourChoice campusTourChoice_in) {
		CampusTourI campusTourI = null;

		if (campusTourChoice_in == null)
			throw new IllegalArgumentException("Choice cannot be null");
		try {
			switch (campusTourChoice_in) {
			case BUS_TOUR:

				break;
			case WALKING_TOUR:

				break;
			default:
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
		}
		return campusTourI;
	}
}
