package registrationScheduler.store;

import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Results implements StdoutDisplayInterface, FileDisplayInterface {
	// appropriate data structure as private data member

	public Results() {
		Logger.writeMessage("Results Constructor called", DebugLevel.CONSTRUCTOR);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void writeScheduleToScreen() {

	}

	@Override
	public void writeSchedulesToFile(String filename) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}