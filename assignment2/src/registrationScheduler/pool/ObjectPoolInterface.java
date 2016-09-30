package registrationScheduler.pool;

import registrationScheduler.data.Course;

public interface ObjectPoolInterface {
	/**
	 * @param course
	 * @return true if the course was borrowed successfully
	 */
	public  boolean borrowCourse(Course course);
	/**
	 * @param course
	 * @return the course was successfully added to the course or not
	 */
	public boolean returnCourse(Course course);
	/**
	 * @param course
	 * @return true if the course is available right now, else false
	 */
	public boolean isCourseAvailable(Course course);
}
