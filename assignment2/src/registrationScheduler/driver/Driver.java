package registrationScheduler.driver;

import java.io.File;

import registrationScheduler.data.Course;
import registrationScheduler.pool.CoursePool;
import registrationScheduler.pool.ObjectPoolInterface;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.store.StoreInterface;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

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
		StoreInterface store = null;
		FileProcessor fileProcessor = null;
		ObjectPoolInterface coursePool = null;
		try {
			// validate the inputs
			validate_inputs(args);

			// take inputs
			threadCount = (int) Integer.parseInt(args[2]);
			Logger.setDebugValue((int) Integer.parseInt(args[3]));

			// setup fileProcessor
			fileProcessor = new FileProcessor(args[0]);

			// setup results
			store = new Results();

			// setup object pool
			coursePool = new CoursePool(Course.totalCourses, capacityPerCourse);

			// setup CreateWorkers
			createWorkers = new CreateWorkers(fileProcessor, store, coursePool);

			// start processing
			createWorkers.startWorker(threadCount);
			// done processing

			// calculate average preference score
			store.calculateAvgPreferenceScore();

			Logger.writeMessage((store).toString(), DebugLevel.DS_STORE);
			// print as needed
			// only avg score
			System.out.println("The average preference score is " + store.getAvgPreferenceScore());

			// entire output to stdout
			//((StdoutDisplayInterface) store).writeScheduleToScreen();

			// entire output to file
			//((FileDisplayInterface) store).writeSchedulesToFile(args[1]);

			// print remaining courses
			// coursePool.toString();
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
		int a = 0;
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
			a = Integer.parseInt(args[2]);
			if (a > 3 || a < 1) {
				System.out.println("Please provide thread count between 1 and 3");
				terminate();
			}
			a = Integer.parseInt(args[3]);
			if (a > 4 || a < 0) {
				System.out.println("Please provide debug value between 0 and 4");
				terminate();
			}
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