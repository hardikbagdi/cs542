package registrationScheduler.store;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import registrationScheduler.data.Student;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Results implements StdoutDisplayInterface, FileDisplayInterface, StoreInterface {
	// appropriate data structure as private data member
	private ArrayList<Student> students;
	private float avgPreferenceScore;

	public Results() {
		Logger.writeMessage("Results Constructor called", DebugLevel.CONSTRUCTOR);
		students = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see registrationScheduler.store.StoreInterface#putStudent(
	 * registrationScheduler.data.Student)
	 */
	@Override
	public synchronized void putStudent(Student student) {
		if (student == null)
			throw new IllegalArgumentException("Cannot add null.");
		if (students.contains(student))
			throw new IllegalArgumentException("Student already present in results");
		Logger.writeMessage("Adding Student to results" + student, DebugLevel.RESULTS_ENTRY);
		students.add(student);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see registrationScheduler.store.StoreInterface#deleteStudent(
	 * registrationScheduler.data.Student)
	 */
	@Override
	public synchronized void deleteStudent(Student student) {
		if (student == null)
			throw new IllegalArgumentException("Cannot remove null.");
		Logger.writeMessage("Deleteing Student from results" + student, DebugLevel.RESULTS_ENTRY);
		students.remove(student);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see registrationScheduler.store.StoreInterface#deleteRandomStudent()
	 */
	@Override
	public synchronized Student deleteRandomStudent() {
		Student student = students.get((int) Math.random() * students.size());
		students.remove(student);
		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see registrationScheduler.store.StoreInterface#updateStudent(
	 * registrationScheduler.data.Student)
	 */
	@Override
	public synchronized void updateStudent(Student student) {
		deleteStudent(student);
		putStudent(student);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * registrationScheduler.store.StoreInterface#contains(registrationScheduler
	 * .data.Student)
	 */
	@Override
	public synchronized boolean contains(Student student) {
		if (student == null)
			return false;
		return students.contains(student);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see registrationScheduler.store.StoreInterface#getStudents()
	 */
	@Override
	public synchronized List<Student> getStudents() {
		return students;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * registrationScheduler.store.StoreInterface#calculateAvgPreferenceScore()
	 */
	@Override
	public synchronized boolean calculateAvgPreferenceScore() {
		float sum = 0;
		try {
			for (Student student : students) {
				student.calculatePreferenceScore();
				sum += student.getPreferenceScore();
			}
			this.avgPreferenceScore = sum / (float) students.size();
		} catch (IllegalAccessException e) {
			// some student has not yet been allocated the courses needed
			return false;
		} catch (Exception e) {
			System.err.println("Error in calculateAvgPreferenceScore() for Result class.\n");
			e.printStackTrace();
			System.exit(1);
		} finally {
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see registrationScheduler.store.StoreInterface#getAvgPreferenceScore()
	 */
	@Override
	public synchronized float getAvgPreferenceScore() {
		return avgPreferenceScore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * registrationScheduler.store.StdoutDisplayInterface#writeScheduleToScreen(
	 * )
	 */
	@Override
	public synchronized void writeScheduleToScreen() {
		System.out.println("SIZE: " + students.size());
		for (Student student : students) {
			System.out.println(student.getOutputString());
		}
		System.out.println("The average preference score is " + this.getAvgPreferenceScore());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * registrationScheduler.store.FileDisplayInterface#writeSchedulesToFile(
	 * java.lang.String)
	 */
	@Override
	public synchronized void writeSchedulesToFile(String filename_in) {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(filename_in));
			for (Student student : students) {
				bufferedWriter.write(student.getOutputString() + "\n");
			}
			bufferedWriter.write("The average preference score is " + this.getAvgPreferenceScore());
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Student student : students) {
			sb.append(student.getOutputString());
			sb.append("\n");
		}
		sb.append("\nNo of students in the result set:" + students.size() + "\n");
		return sb.toString();
	}
}