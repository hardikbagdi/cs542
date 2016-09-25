package registrationScheduler.data;

import java.util.Arrays;

import javax.swing.plaf.BorderUIResource.CompoundBorderUIResource;

import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;
import registrationScheduler.data.Course;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */

public class Student {
	private String name;
	private static int requriedCourses = 5;
	private int preferences[];
	private int preferenceScore;
	private Course coursesAlloted[];

	/**
	 * @param name_in
	 * @param preferences_in
	 */
	public Student(String name_in, int[] preferences_in) {
		Logger.writeMessage("Student constructor called", DebugLevel.CONSTRUCTOR);
		if (name_in == null || preferences_in == null)
			throw new IllegalArgumentException("Name and/or preference array cannot be null");
		if (preferences_in.length != Course.totalCourses)
			throw new IllegalArgumentException("Length of preferences array should be " + Course.totalCourses);
		try {
			this.name = name_in;
			this.preferences = preferences_in;
			this.coursesAlloted = new Course[requriedCourses];
			this.preferenceScore = -1;
		} catch (Exception e) {
			System.err.println("Constructor failed for Student Object.\n");
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public int[] getPreferences() {
		return preferences;
	}

	/**
	 * @return
	 */
	public Course[] getCoursesAlloted() {
		return coursesAlloted;
	}

	/**
	 * @param courseAllocated_in
	 */
	public void setCoursesAlloted(Course[] courseAllocated_in) {
		coursesAlloted = courseAllocated_in;
	}

	/**
	 * @return
	 */
	public int getPreferenceScore() {
		return preferenceScore;
	}

	/**
	 * 
	 */
	public void calculatePreferenceScore() {
		int sumOfPreference = 0;

		for (Course c : coursesAlloted) {
			sumOfPreference += preferences[c.getValue()];
		}
		preferenceScore = sumOfPreference;
		this.preferenceScore = sumOfPreference;
	}

	/**
	 * @param course
	 * @return
	 */
	public int coursePreference(Course course) {
		return preferences[course.getValue()];
	}

	/**
	 * @param preferenceRank
	 * @return
	 */
	public Course getCourseByPreferenceRank(int preferenceRank) {
		int i;
		if (preferenceRank < 1 || preferenceRank > Course.totalCourses)
			throw new IllegalArgumentException(
					"preference should be between 1 to " + Course.totalCourses + "(inclusive).");
		for (i = 0; i < preferences.length; i++) {
			if (preferenceRank == preferences[i])
				break;
		}
		// http://stackoverflow.com/questions/14319232/get-enum-name-from-enum-value
		return Course.values()[i];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb;
		sb = new StringBuilder();
		try {

			sb.append("\n" + name);
			sb.append("\nPreferences:");
			sb.append(Arrays.toString(this.preferences));
			sb.append("\nCourses Allocated:");
			sb.append(Arrays.toString(this.coursesAlloted));
			sb.append("\nPreference Score:");
			sb.append(preferenceScore + "\n");
		} catch (Exception e) {
			System.err.println("Error in toString() for Student class.\n");
			e.printStackTrace();
			System.exit(1);
		}
		return sb.toString();
	}
}
