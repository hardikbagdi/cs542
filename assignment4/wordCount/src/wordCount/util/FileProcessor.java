package wordCount.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import wordCount.util.Logger.DebugLevel;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class FileProcessor {
	public static enum FileMode {
		READ, WRITE
	};

	private String filename;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private FileMode fileMode;

	/**
	 * @return the filename of the file which is being processed
	 */
	public String getFilename() {
		return filename;
	}

	public FileMode getFileMode() {
		return fileMode;
	}

	/**
	 * @param filename_in
	 *            the file which is being read from or written to
	 */
	public FileProcessor(String filename_in, FileMode fileMode_in) {
		Logger.writeMessage("FileProcessor Constructor called", DebugLevel.CONSTRUCTOR);
		if (filename_in == null || fileMode_in == null)
			throw new IllegalArgumentException();
		File file = new File(filename_in);
		if (fileMode_in == FileMode.READ && !file.canRead())
			throw new IllegalArgumentException("Can't read file " + filename_in);
		if (fileMode_in == FileMode.WRITE && file.exists() && !file.delete())
			throw new IllegalArgumentException("Output file exists and not removable");
		filename = filename_in;
		fileMode = fileMode_in;
		try {
			if (fileMode == FileMode.READ) {
				bufferedReader = new BufferedReader(new FileReader(getFilename()));
			} else {
				bufferedWriter = new BufferedWriter(new FileWriter(getFilename()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
		}
	}

	/**
	 * @return String which was read by the processor, this will be null when
	 *         EOF is reached
	 * @throws IllegalAccessException
	 */
	public synchronized String getLine() throws IllegalAccessException {
		if (fileMode == FileMode.WRITE) {
			throw new IllegalAccessException("Cant read a file which is being written to.");
		}
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

	public synchronized void putLine(String line_in) throws IllegalAccessException {
		if (fileMode == FileMode.READ) {
			throw new IllegalAccessException("Cant write to a file which is being read.");
		}
		try {
			bufferedWriter.write(line_in+"\n");
			bufferedWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
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
		return "FileProcessor:" + getFilename() + " is being processed. Operation :" + getFileMode();
	}
}
