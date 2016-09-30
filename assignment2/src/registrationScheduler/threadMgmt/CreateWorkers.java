package registrationScheduler.threadMgmt;

import registrationScheduler.pool.CoursePool;
import registrationScheduler.pool.ObjectPoolInterface;
import registrationScheduler.store.Results;
import registrationScheduler.store.StoreInterface;
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
	private StoreInterface store;
	private ObjectPoolInterface coursePool;

	/**
	 * @param fileProcessor_in
	 * @param store_in
	 * @param coursePool_in
	 */
	public CreateWorkers(FileProcessor fileProcessor_in, StoreInterface store_in, ObjectPoolInterface coursePool_in) {
		Logger.writeMessage("CreateWorkers constructor called", DebugLevel.CONSTRUCTOR);
		if (fileProcessor_in == null || store_in == null) {
			throw new IllegalArgumentException();
		}
		fileProcessor = fileProcessor_in;
		coursePool = coursePool_in;
		store = store_in;
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
				threads[i] = new Thread(new WorkerThread("Thread" + i, fileProcessor, store, coursePool));
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