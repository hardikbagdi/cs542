package registrationScheduler.store;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public interface FileDisplayInterface {
	/**
	 * Write the generated schedule to an output file
	 * @param filename Outputfile
	 */
	public void writeSchedulesToFile(String filename);
}
