package registrationScheduler.store;

import java.util.List;

import registrationScheduler.data.Student;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public interface StoreInterface {
	public void putStudent(Student s);

	public void deleteStudent(Student s);

	public void updateStudent(Student s);

	public Student deleteRandomStudent();

	public boolean contains(Student s);

	public boolean calculateAvgPreferenceScore();

	public List<Student> getStudents();

	public float getAvgPreferenceScore();
}
