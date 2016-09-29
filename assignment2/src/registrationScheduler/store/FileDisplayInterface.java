package registrationScheduler.store;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public interface FileDisplayInterface {
	/**
	 * Write the generated schedule to an output file
	 * 
	 * @param filename
	 *            file to which to write the output
	 */
	public void writeSchedulesToFile(String filename);
}
