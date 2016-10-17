package studentOrientation.driver;

import studentOrientation.util.Logger;
import studentOrientation.util.Logger.DebugLevel;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Driver {
	public static final DebugLevel debuglevel = DebugLevel.NO_OUTPUT;
	
	/**
	 * @param args No parameters should be passed to main
	 */
	public static void main(String[] args) {
		//set Logger Debug value
		Logger.setDebugValue(debuglevel);
		
		System.out.println("HELLO WORLD");
		
		
		
		System.out.println("BYE WORLD");
	}
}
