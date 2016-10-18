package studentOrientation.OrientationScheduleBuilder;

import studentOrientation.student.StudentScheduleI;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public interface StudentOrientationScheduleWorkshopI {
	/**
	 * @param studentScheduleI
	 *            Student for which to construct the entire schedule
	 */
	public void constructSchedule(StudentScheduleI studentScheduleI);
}
