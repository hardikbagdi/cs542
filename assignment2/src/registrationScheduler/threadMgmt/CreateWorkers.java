package registrationScheduler.threadMgmt;

import registrationScheduler.pool.CoursePool;
import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class CreateWorkers {
	private int threadCount;
	private Thread[] threads;
	private FileProcessor fileProcessor;
	private Results results;
	private CoursePool coursePool;

	/**
	 * @param fileProcessor_in
	 * @param results_in
	 * @param coursePool_in
	 */
	public CreateWorkers(FileProcessor fileProcessor_in, Results results_in, CoursePool coursePool_in) {
		Logger.writeMessage("CreateWorkers constructor called", DebugLevel.CONSTRUCTOR);
		if (fileProcessor_in == null || results_in == null) {
			throw new IllegalArgumentException();
		}
		fileProcessor = fileProcessor_in;
		coursePool = coursePool_in;
		results = results_in;
		threads = null;
		threadCount = -1;
		return;
	}

	/**
	 * @param threadCount_in
	 * @return none
	 */
	public void startWorker(int threadCount_in) {
		int i = -1;
		// basic validation
		if (threadCount_in < 1)
			throw new IllegalArgumentException();
		try {
			threadCount = threadCount_in;
			threads = new Thread[threadCount];
			for (i = 0; i < threads.length; i++) {
				threads[i] = new Thread(new WorkerThread("Thread" + i, fileProcessor, results, coursePool));
			}
			for (i = 0; i < threads.length; i++) {
				threads[i].start();
			}
			for (i = 0; i < threads.length; i++) {
				threads[i].join();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
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
		return "CreateWorkers: Number of threads: " + threadCount;
	}
}