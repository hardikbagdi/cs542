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
public class CreateWorkers  {
	private Thread[] threads;
	private FileProcessor fileProcessor;
	private Results results;
	private CoursePool coursePool;
	public CreateWorkers(FileProcessor fileProcessor_in,Results results_in, CoursePool coursePool_in) {
		Logger.writeMessage("CreateWorkers constructor called",DebugLevel.CONSTRUCTOR);
		if (fileProcessor_in == null || results_in == null) {
			throw new IllegalArgumentException();
		}
		fileProcessor = fileProcessor_in;
		coursePool = coursePool_in;
		results = results_in;
		return;
	}
	public void startWorker(int threadCount){
		int i = -1;
		System.out.println("startworker called");
		//basic validation
		if(threadCount < 1)
			throw new IllegalArgumentException();
		try {
			threads = new Thread[threadCount];
			for (i = 0; i < threads.length; i++) {
				threads[i] = new Thread(new WorkerThread(fileProcessor, results, coursePool));
			}
			for (i = 0; i < threads.length; i++) {
				threads[i].start();
				threads[i].join();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
    // this class has the method startWokers(...)

}