package registrationScheduler.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class RandomInputGenerator {
	private static int totalCourses = 7;
	private static int totalStudents = 80;
	private static ArrayList<Integer> preferences = new ArrayList<>();

	public static void main(String[] args) {
		BufferedWriter bufferedWriter = null;
		if (args.length != 1) {
			System.out.println("arg[0]: filename");
			System.exit(1);
		}
		if (new File(args[0]).exists()) {
			System.out.println("output file already exists.");
			System.exit(1);
		}
		try {
			for (int i = 0; i < totalCourses; i++) {
				preferences.add(i + 1);
			}
			bufferedWriter = new BufferedWriter(new FileWriter(args[0]));
			for (int i = 0; i < totalStudents; i++) {
				Collections.shuffle(preferences);
				bufferedWriter.write("Student_" + i);
				for (int j = 0; j < totalCourses; j++) {
					bufferedWriter.write(" " + preferences.get(j));
				}
				bufferedWriter.write("\n");
			}
			bufferedWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
