package studentOrientation.util;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Logger {
	public static enum DebugLevel {
		NO_OUTPUT
	};

	private static DebugLevel debugLevel;

	/**
	 * Sets the logger level based on an integer
	 * 
	 * @return none
	 */
	public static void setDebugValue(int levelIn) {
		// basic validation
		if (levelIn < 0 || levelIn > 4) {
			throw new IllegalArgumentException("Logger debug level should not be between 0-5.");
		}
		switch (levelIn) {
		case 0:
			debugLevel = DebugLevel.NO_OUTPUT;
			break;
		// case 1:
		// debugLevel = DebugLevel.;
		// break;
		// case 2:
		// debugLevel = DebugLevel.;
		// break;
		// case 3:
		// debugLevel = DebugLevel.;
		// break;
		// case 4:
		// debugLevel = DebugLevel.;
		// break;
		}
		return;
	}

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
