package wordCount.driver;

import java.io.File;

import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

public class Driver {
	private static String usageString = "Usage: java Driver <input-file> <output-file> <iteration-count>";

	public static void main(String[] args) {
		Logger.setDebugValue(DebugLevel.NO_OUTPUT);
		try {
			if (!validateArgs(args)) {
				System.out.println(usageString);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean validateArgs(String[] args) {
		try {
			if (args.length != 3) {
				return false;
			}
			if (!(new File(args[0])).canRead()) {
				System.out.println("Input file is unreadable/doesn't exist.");
				return false;
			}
			File file = new File(args[1]);
			if (file.exists()) {
				file.delete();
			}
			int iterations = Integer.parseInt(args[2]);
			return true;
		} catch (NumberFormatException exception) {
			System.out.println("Please provide a natural number for iteration count.");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return false;
	}
}
