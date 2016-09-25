package registrationScheduler.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import registrationScheduler.util.Logger.DebugLevel;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class FileProcessor {
	private String filename;
	FileReader fileReader;
	BufferedReader bufferedReader;

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename_in
	 */
	public FileProcessor(String filename_in) {
		Logger.writeMessage("FileProcessor Constructor called", DebugLevel.CONSTRUCTOR);
		if (filename_in == null)
			throw new IllegalArgumentException();

		filename = filename_in;

		try {
			bufferedReader = new BufferedReader(new FileReader(getFilename()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}

	/**
	 * @return
	 */
	public synchronized String getLine() {
		String line = null;

		try {
			// this will throw null at the end of file
			line = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
		return line;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		bufferedReader.close();
		super.finalize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileProcessor: File being Processed: " + getFilename();
	}
}
