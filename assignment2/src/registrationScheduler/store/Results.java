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
public class Results implements StdoutDisplayInterface, FileDisplayInterface {
	// appropriate data structure as private data member
	private ArrayList<Student> students;
	private float avgPreferenceScore;

	public Results() {
		Logger.writeMessage("Results Constructor called", DebugLevel.CONSTRUCTOR);
		students = new ArrayList<>();
	}

	public synchronized void putStudent(Student student) {
		if (student == null)
			throw new IllegalArgumentException("Cannot add null.");
		if (students.contains(student))
			throw new IllegalArgumentException("Student already present in results");
		Logger.writeMessage("Adding Student to results" + student, DebugLevel.DS_STORE);
		students.add(student);
	}

	public synchronized void deleteStudent(Student student) {
		if (student == null)
			throw new IllegalArgumentException("Cannot remove null.");
		Logger.writeMessage("Deleteing Student from results" + student, DebugLevel.DS_STORE);
		students.remove(student);
	}

	public synchronized void updateStudent(Student student) {
		deleteStudent(student);
		putStudent(student);
	}

	public synchronized boolean contains(Student student) {
		if (student == null)
			return false;
		return students.contains(student);
	}

	/**
	 * @return
	 */
	public synchronized List<Student> getStudents() {
		return students;
	}

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
		for (Student student : students) {
			System.out.println(student.getOutputString());
		}
		System.out.println();
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
		for(Student student : students){
			Logger.writeMessage(student.getOutputString(), DebugLevel.RESULTS_ENTRY);
		}
		return "No of students in the result set:" + students.size();
	}
}