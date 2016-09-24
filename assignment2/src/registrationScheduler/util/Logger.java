package registrationScheduler.util;


/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Logger{
    public static enum DebugLevel { NO_OUTPUT, DS_STORE, RESULTS_ENTRY, THREAD, CONSTRUCTOR };
    private static DebugLevel debugLevel;
    
    /**
     * Sets the logger level based on an int
     * @return none
    */
    public static void setDebugValue (int levelIn) {
		//basic validation
    	if (levelIn < 0 || levelIn > 4) {
			throw new IllegalArgumentException("Logger debug level should not be between 0-5.");
		}
    	switch (levelIn) {
			case 0:
				debugLevel = DebugLevel.NO_OUTPUT;
				break;
			case 1:
				debugLevel = DebugLevel.DS_STORE;
				break;
			case 2:
				debugLevel = DebugLevel.RESULTS_ENTRY;
				break;
			case 3:
				debugLevel = DebugLevel.THREAD;
				break;
			case 4:
				debugLevel = DebugLevel.CONSTRUCTOR;
				break;
		}
    	return;
    }
    /**
     * Sets up the logger level- based on DebugLevel
     * @return none
    */
    public static void setDebugValue (DebugLevel levelIn) {
    	debugLevel = levelIn;
    	return;
    }

    /**
     * Writes a message if the log level matches
     * @return none
    */
    public static void writeMessage (String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
		    System.out.println(message);
    }
    
    /* 
     * @return none
     */
    public String toString() {
    	return "Debug Level is " + debugLevel;
    }
}
