package studentOrientation.driver;

import studentOrientation.bookStore.BookStoreChoice;
import studentOrientation.campusTour.CampusTourChoice;
import studentOrientation.courseRegistration.CourseRegistrationChoice;
import studentOrientation.dormitory.DormitoryRegistrationChoice;
import studentOrientation.util.Logger;
import studentOrientation.util.Logger.DebugLevel;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Driver {
	public static final DebugLevel debuglevel = DebugLevel.NO_OUTPUT;

	/**
	 * @param args
	 *            No parameters should be passed to main
	 */
	public static void main(String[] args) {
		// set Logger Debug value
		Logger.setDebugValue(debuglevel);
		String name = "Larry David";
		int id = 42;
		CampusTourChoice campusTourChoice = CampusTourChoice.BUS_TOUR;
		BookStoreChoice bookStoreChoice = BookStoreChoice.MANDO_BOOK_STORE;
		DormitoryRegistrationChoice dormitoryRegistrationChoice = DormitoryRegistrationChoice.OFFLINE_QUEUE;
		CourseRegistrationChoice courseRegistrationChoice = CourseRegistrationChoice.FROM_EB_LABS;

		System.out.println("HELLO WORLD");

		System.out.println("BYE WORLD");
	}
}
