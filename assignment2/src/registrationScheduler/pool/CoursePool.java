package registrationScheduler.pool;

import java.util.Arrays;

import registrationScheduler.data.Course;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class CoursePool implements ObjectPoolInterface {
	private int totalCourses;
	private int seatsPerCourse;
	// counters for each course, all objects are same, no unique property so
	// having an array of object is unnecessary
	private int[] seatCounters;

	/**
	 * @param totalCourses_in
	 * @param seatsPerCourse_in
	 */
	public CoursePool(int totalCourses_in, int seatsPerCourse_in) {
		Logger.writeMessage("CoursePool Constructor called", DebugLevel.CONSTRUCTOR);

		if (totalCourses_in < 1 || seatsPerCourse_in < 1)
			throw new IllegalArgumentException();

		totalCourses = totalCourses_in;
		seatsPerCourse = seatsPerCourse_in;
		seatCounters = new int[totalCourses];
		for (int i = 0; i < seatCounters.length; i++) {
			seatCounters[i] = seatsPerCourse;
		}
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.pool.ObjectPoolInterface#borrowCourse(registrationScheduler.data.Course)
	 */
	@Override
	public synchronized boolean borrowCourse(Course course) {
		if (course == null)
			return false;
		if (seatCounters[course.getValue()] > 0) {
			--seatCounters[course.getValue()];
			return true;
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.pool.ObjectPoolInterface#returnCourse(registrationScheduler.data.Course)
	 */
	@Override
	public synchronized boolean returnCourse(Course course) {
		if (course == null)
			return false;
		if (seatCounters[course.getValue()] == seatsPerCourse) {
			return false;
		} else {
			++seatCounters[course.getValue()];
			return true;
		}
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.pool.ObjectPoolInterface#isCourseAvailable(registrationScheduler.data.Course)
	 */
	@Override
	public synchronized boolean isCourseAvailable(Course course) {
		if (course == null)
			return false;
		if (seatCounters[course.getValue()] > 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		System.out.print(Arrays.toString(seatCounters));
		return "\nCourses:" + totalCourses + "\nStudents Per course:" + seatsPerCourse;
	}
}
