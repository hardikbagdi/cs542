package genericDeser.driver;

import java.io.File;

import genericDeser.fileOperations.FileProcessor;
import genericDeser.fileOperations.FileProcessor.FileMode;
import genericDeser.util.Logger;
import genericDeser.util.Logger.DebugLevel;
import genericDeser.util.PopulateObjects;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Driver {
	private static String usageString = "Usage: java Driver <input-file> <logger-value>";

	public static void main(String[] args) {
		String inputFile = args[0];
		FileProcessor fileReader;
		PopulateObjects populateObjects;
		try {
			if (!validateArgs(args)) {
				System.out.println(usageString);
				return;
			}
			Logger.setDebugValue(DebugLevel.NO_OUTPUT);
			fileReader = new FileProcessor(inputFile, FileMode.READ);
			populateObjects = new PopulateObjects();
			populateObjects.deserObjects(fileReader);

			System.out.println("Number of unique First objects: " + populateObjects.uniqueNumOfFirstObjects());
			System.out.println("Total Number of First objects: " + populateObjects.totalNumOfFirstObjects());
			System.out.println("Number of unique Second objects: " + populateObjects.uniqueNumOfSecondObjects());
			System.out.println("Total Number of Second objects: " + populateObjects.totalNumOfSecondObjects());
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}

	private static boolean validateArgs(String[] args) {
		try {
			if (args.length != 2) {
				return false;
			}
			if (!(new File(args[0])).canRead()) {
				System.out.println("Input file is unreadable/doesn't exist.");
				return false;
			}
			Integer.parseInt(args[1]);
			return true;
		} catch (NumberFormatException exception) {
			System.out.println("Please provide a natural number for iteration count.");
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return true;
	}
}
