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
public class WorkerThread implements Runnable  {

	private FileProcessor fileProcessor;
	private Results results;
	private CoursePool coursePool;
	
	public WorkerThread(FileProcessor fileProcessor_in,Results results_in, CoursePool coursePool_in) {
		Logger.writeMessage("WorkerThread constructor called",DebugLevel.CONSTRUCTOR);
		if (fileProcessor_in == null || results_in == null || coursePool_in == null) {
			throw new IllegalArgumentException();
		}
		fileProcessor = fileProcessor_in;
		coursePool = coursePool_in;
		results = results_in;
		return;
	}
    public void run() {
    	try{
    		Logger.writeMessage("WorkerTHread started.", DebugLevel.THREAD);
    	}catch(Exception e){
    		
    	}finally {
			
		}
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return super.toString();
    }
    

}