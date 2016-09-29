CS542 Design Patterns
Fall 2016
ASSIGNMENT 2 README FILE

Due Date: September 30, 2016
Submission Date: September 29, 2016
Grace Period Used This Project: None
Grace Period Remaining: <DAYS> Days
Author(s): HARDIK BAGDI
e-mail(s): hbagdi1@binghamton.edu


PURPOSE:

To implement and understand the use of objectpool design pattern and
simulate all students registering for courses scenario using threads


PERCENT COMPLETE:

100

PARTS THAT ARE NOT COMPLETE:

none

BUGS:

none

FILES:
registrationScheduler/data:
Course.java Enum representing a course
Student.java Class which represnts a student and holds necessary data

registrationScheduler/driver:
Driver.java Main driver program

registrationScheduler/pool:
CoursePool.java ObjectPool implementation

registrationScheduler/store:
FileDisplayInterface.java
StdoutDisplayInterface.java
Results.java 

registrationScheduler/test:
RandomInputGenerator.java To generate random valid test cases

registrationScheduler/threadMgmt:
CreateWorkers.java Class which creates all the threads necessary and then waits on all of them 
WorkerThread.java Thread which performs allocation

registrationScheduler/util:
FileProcessor.java
Logger.java Log to stdout as per the log level.

SAMPLE OUTPUT:

The average preference score is 15.15

TO COMPILE:
tar xvf <name>.tar.gz
cd to relevant directory
ant all

TO RUN:

ant run (edit for input filename)

EXTRA CREDIT:
NA

BIBLIOGRAPHY:
https://docs.oracle.com/javase/7/docs/api/
http://stackoverflow.com/questions/5690351/java-stringlist-toarray-gives-classcastexception
http://stackoverflow.com/questions/14319232/get-enum-name-from-enum-value
http://stackoverflow.com/questions/19220691/how-can-i-correctly-remove-an-object-from-arraylist