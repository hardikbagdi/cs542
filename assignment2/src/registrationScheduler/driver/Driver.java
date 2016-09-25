package registrationScheduler.driver;

import java.io.File;

import registrationScheduler.data.Course;
import registrationScheduler.pool.CoursePool;
import registrationScheduler.store.Results;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Driver {
	private static String USAGE_STRING = "Usage: java Driver <input-file> <output-file> <thread-count> <debug-value>";
	private static int capacityPerCourse = 60;

	/**
	 * Main method
	 * 
	 * @param args
	 *            Commandline String array
	 * @return none
	 */
	public static void main(String args[]) {
		int threadCount = -1;
		CreateWorkers createWorkers = null;
		Results results = null;
		FileProcessor fileProcessor = null;
		CoursePool coursePool = null;
		try {
			// validate the inputs
			validate_inputs(args);

			// take inputs
			threadCount = (int) Integer.parseInt(args[2]);
			Logger.setDebugValue((int) Integer.parseInt(args[3]));

			// setup fileProcessor
			fileProcessor = new FileProcessor(args[0]);

			// setup results
			results = new Results();

			// setup object pool
			coursePool = new CoursePool(Course.totalCourses, capacityPerCourse);

			// setup CreateWorkers
			createWorkers = new CreateWorkers(fileProcessor, results, coursePool);

			// start processing
			createWorkers.startWorker(threadCount);
			// done processing

			// calculate average preference score
			results.calculateAvgPreferenceScore();

			// print as needed
			// only avg score
			System.out.println("The average preference score is" + results.getAvgPreferenceScore());
			// entire output to stdout
			results.writeScheduleToScreen();
			// entire output to file
			// results.writeSchedulesToFile(args[1]);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Called when parameter validation failed
	 * 
	 * @return none
	 */
	private static void terminate() {
		System.out.println(USAGE_STRING);
		System.exit(1);
	}

	/**
	 * Validates the inputs taken from the commandline
	 * 
	 * @param args
	 *            commandline argument list
	 * @return none
	 */
	private static void validate_inputs(String[] args) {
		File file;
		try {
			if (args.length != 4) {
				terminate();
			}

			file = new File(args[0]);
			if (!file.canRead()) {
				System.out.println("Input file does not exist or not readable.");
				terminate();
			}

			file = new File(args[1]);
			if (file.exists())
				file.delete();
			Integer.parseInt(args[2]);
			Integer.parseInt(args[3]);
		} catch (NumberFormatException e) {
			System.out.println("Please provide thread count/debug value as an integer");
			terminate();
		} catch (Exception e) {
			e.printStackTrace();
			terminate();
		} finally {

		}
	}
}