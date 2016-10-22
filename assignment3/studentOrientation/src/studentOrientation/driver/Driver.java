package studentOrientation.driver;

import studentOrientation.OrientationScheduleBuilder.StudentOrientationScheduleWorkshop;
import studentOrientation.OrientationScheduleBuilder.StudentOrientationScheduleWorkshopI;
import studentOrientation.bookStore.BookStoreChoice;
import studentOrientation.campusTour.CampusTourChoice;
import studentOrientation.courseRegistration.CourseRegistrationChoice;
import studentOrientation.dormitory.DormitoryRegistrationChoice;
import studentOrientation.student.StudentSchedule;
import studentOrientation.student.StudentScheduleI;
import studentOrientation.util.Logger;
import studentOrientation.util.Logger.DebugLevel;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Driver {
	private static final DebugLevel debuglevel = DebugLevel.NO_OUTPUT;

	/**
	 * @param args
	 *            No parameters should be passed to main
	 */
	public static void main(String[] args) {
		// set Logger Debug value
		Logger.setDebugValue(debuglevel);

		// Student details and choices
		String name = "Larry David";
		Long id = 42L;
		// Comments list the choices available

		// BUS_TOUR,WALKING_TOUR;
		CampusTourChoice campusTourChoice = CampusTourChoice.BUS_TOUR;

		// MANDO_BOOK_STORE, UNIVERSITY_BOOK_STORE;
		BookStoreChoice bookStoreChoice = BookStoreChoice.MANDO_BOOK_STORE;

		// OFFLINE_QUEUE, ONLINE_GAMING_CONTEST;
		DormitoryRegistrationChoice dormitoryRegistrationChoice = DormitoryRegistrationChoice.ONLINE_GAMING_CONTEST;

		// REGISTRAR_OFFICE,FROM_EB_LABS;
		CourseRegistrationChoice courseRegistrationChoice = CourseRegistrationChoice.REGISTRAR_OFFICE;

		StudentScheduleI studentSchedule;
		StudentOrientationScheduleWorkshopI scheduleWorkshop;
		try {
			studentSchedule = new StudentSchedule(name, id, campusTourChoice, bookStoreChoice,
					dormitoryRegistrationChoice, courseRegistrationChoice);

			scheduleWorkshop = new StudentOrientationScheduleWorkshop();

			scheduleWorkshop.constructSchedule(studentSchedule);

			studentSchedule.printItinerary();
		} catch (Exception exception) {
			exception.printStackTrace();
			System.exit(1);
		} finally {

		}
	}
}
