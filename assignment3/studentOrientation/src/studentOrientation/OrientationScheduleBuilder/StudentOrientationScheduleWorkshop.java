package studentOrientation.OrientationScheduleBuilder;

import studentOrientation.student.StudentScheduleI;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class StudentOrientationScheduleWorkshop implements StudentOrientationScheduleWorkshopI {

	/*
	 * (non-Javadoc)
	 * 
	 * @see studentOrientation.OrientationScheduleBuilder.
	 * StudentOrientationScheduleWorkshopI#constructSchedule(studentOrientation.
	 * student.StudentScheduleI)
	 */
	@Override
	public void constructSchedule(StudentScheduleI studentSchedule) {

		studentSchedule.buildCampusTourItinerary();
		studentSchedule.buildDormioryRegistrationItenerary();
		studentSchedule.buildCourseRegistrationItenerary();
		studentSchedule.buildBookStoreItenerary();
	}

}
