package registrationScheduler.threadMgmt;

import registrationScheduler.coursePool.CoursePool;
import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class WorkerThread implements Runnable {
	private FileProcessor fileProcessor;
	private Results results;
	private CoursePool coursePool;
	private String threadName;

	/**
	 * @param threadName
	 * @param fileProcessor_in
	 * @param results_in
	 * @param coursePool_in
	 */
	public WorkerThread(String threadName_in, FileProcessor fileProcessor_in, Results results_in,
			CoursePool coursePool_in) {
		Logger.writeMessage("WorkerThread constructor called", DebugLevel.CONSTRUCTOR);
		if (fileProcessor_in == null || results_in == null || coursePool_in == null) {
			throw new IllegalArgumentException();
		}
		threadName = threadName_in;
		fileProcessor = fileProcessor_in;
		coursePool = coursePool_in;
		results = results_in;
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		int i = 0;
		try {
			Logger.writeMessage(threadName + ": run() called.", DebugLevel.THREAD);
			String line = null;
			while ((line = fileProcessor.getLine()) != null)
				System.out.println(threadName + "   " + line + " " + (++i));

		} catch (Exception e) {

		} finally {

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String status = "WorkerThread Status:\n";
		status.concat("Processing File: " + fileProcessor.getFilename());
		// TODO add other data structure info here
		return status;
	}

}