package registrationScheduler.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;
import registrationScheduler.data.Course;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */

public class Student {
	private String name;
	public static int requriedCourses = 5;
	private int preferences[];
	private int preferenceScore;
	private List<Course> coursesAlloted;

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
			this.coursesAlloted = new ArrayList<>();
			this.preferenceScore = -1;
		} catch (Exception e) {
			System.err.println("Constructor failed for Student Object.\n");
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * @return the name of the student
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the preference of the student for each subject in an array
	 */
	public int[] getPreferences() {
		return preferences;
	}

	/**
	 * @return Array of courses the student received after allocation.
	 */
	public Course[] getCoursesAlloted() {
		// http://stackoverflow.com/questions/5690351/java-stringlist-toarray-gives-classcastexception
		return (Course[]) coursesAlloted.toArray(new Course[coursesAlloted.size()]);
	}

	/**
	 * @return preference score of the student 
	 */
	public int getPreferenceScore() {
		return preferenceScore;
	}

	/**
	 * @param course_in A course being offered
	 * @return if the student has been able to secure a seat for this course or not
	 */
	public boolean hasCourse(Course course_in) {
		if (course_in == null)
			return false;
		return this.coursesAlloted.contains(course_in);
	}

	/**
	 * @param course
	 * @return student gets this course 
	 */
	public boolean addCourse(Course course) {
		if (course == null)
			throw new IllegalArgumentException();
		if (this.hasCourse(course))
			return false;
		return this.coursesAlloted.add(course);
	}

	/**
	 * @param course
	 * @return student is removed from this course
	 */
	public boolean removeCourse(Course course) {
		if (course == null)
			return true;
		if (!this.hasCourse(course))
			return false;
		return this.coursesAlloted.remove(course);
	}

	/**
	 * @return true if student has all the courses needed i.e. the requiredCOurses criteria has been fulfilled
	 */
	public boolean hasAllCourses() {
		return (coursesAlloted.size() == Student.requriedCourses);
	}

	/**
	 * @throws IllegalAccessException
	 */
	public void calculatePreferenceScore() throws IllegalAccessException {
		int sumOfPreference = 0;
		// validation
		for (Course c : coursesAlloted) {
			if (c == null)
				throw new IllegalAccessException();
			sumOfPreference += preferences[c.getValue()];
		}
		preferenceScore = sumOfPreference;
		this.preferenceScore = sumOfPreference;
	}

	/**
	 * @param course
	 * @return student's preference for the course
	 */
	public int coursePreference(Course course) {
		return preferences[course.getValue()];
	}

	/**
	 * @param preferenceRank
	 * @return returns the course for the corresponding preference value
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

	/**
	 * @return the string which shows student name and the courses he/she received.
	 */
	public String getOutputString() {
		StringBuilder outString = new StringBuilder(this.name + " ");
		for (Course course : coursesAlloted) {
			outString.append(course + " ");
		}
		outString.append("" + preferenceScore);
		return outString.toString();
	}


	// http://stackoverflow.com/questions/19220691/how-can-i-correctly-remove-an-object-from-arraylist
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (this == obj)
			return true;
		Student student = (Student) obj;
		return this.name.equals(student.getName());
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
			sb.append("\nCourses Allocated: ");
			for (Course c : coursesAlloted)
				sb.append(c + " ");
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
