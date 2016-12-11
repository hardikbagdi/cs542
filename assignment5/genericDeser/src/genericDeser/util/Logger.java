package genericDeser.util;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Logger {
	public static enum DebugLevel {
		NO_OUTPUT, CONSTRUCTOR, TREEINSERT
	};

	private static DebugLevel debugLevel;

	/**
	 * Sets up the logger level- based on DebugLevel
	 * 
	 * @return none
	 */
	public static void setDebugValue(DebugLevel levelIn) {
		if (levelIn == null)
			return;
		debugLevel = levelIn;
		return;
	}

	/**
	 * Writes a message if the log level matches
	 * 
	 * @return none
	 */
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == null || message == null)
			return;
		if (levelIn == debugLevel)
			System.out.println("Logger->" + message);
	}

	/*
	 * @return none
	 */
	public String toString() {
		return "Debug Level is " + debugLevel;
	}
}
