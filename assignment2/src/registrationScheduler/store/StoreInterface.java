package registrationScheduler.store;

import java.util.List;

import registrationScheduler.data.Student;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public interface StoreInterface {
	/**
	 * @param student
	 * @return none
	 */
	public void putStudent(Student s);

	/**
	 * @param student
	 * @return none
	 */
	public void deleteStudent(Student s);

	/**
	 * @param student
	 * @return none
	 */
	public void updateStudent(Student s);

	/**
	 * @return Student which was picked up randomly and deleted
	 */
	public Student deleteRandomStudent();

	/**
	 * @param student
	 * @return true if the result set contains the student
	 */
	public boolean contains(Student s);

	/**
	 * @return true if the avg preferecne score was succesfully generated
	 */
	public boolean calculateAvgPreferenceScore();

	/**
	 * @return A list of all students in the result set
	 */
	public List<Student> getStudents();
	/**
	 * @return the average preference score of the class
	 */
	public float getAvgPreferenceScore();
}
