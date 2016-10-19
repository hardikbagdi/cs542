package studentOrientation.courseRegistration;

public class SimpleCourseRegistrationFactory {
	public static CourseRegistrationI createBookStore(CourseRegistrationChoice courseRegistrationChoice_in) {
		CourseRegistrationI courseRegistrationI = null;

		if (courseRegistrationChoice_in == null)
			throw new IllegalArgumentException("Choice cannot be null");
		try {
			switch (courseRegistrationChoice_in) {
			case FROM_EB_LABS:
				courseRegistrationI = new ElectronicCourseRegistration();
				break;
			case REGISTRAR_OFFICE:
				courseRegistrationI = new OfflineCourseRegistration();
				break;
			default:
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
		}
		return courseRegistrationI;
	}
}
