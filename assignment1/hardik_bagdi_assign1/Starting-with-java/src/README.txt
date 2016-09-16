CS542 Design Patterns
Fall 2016
ASSIGNMENT 1 README FILE

Due Date: Tuesday, August 30, 2016
Submission Date: Tuesday, August 30, 2016
Grace Period Used This Project: None
Grace Period Remaining: <DAYS> Days
Author(s): HARDIK BAGDI
e-mail(s): hbagdi1@binghamton.edu


PURPOSE:

Assign courses to a class of 12 students who provided their preferences.
Course allotment should be done in a way to keep everyone happy i.e. try to satisfy all students' preferences.

PERCENT COMPLETE:

I believe that I've done 100% but I don't have as much confidence in my code as I should have.
A lot of optimizations in terms of code as well as functionality is possible.
Not much effort has been made to keep the preference score low.

PARTS THAT ARE NOT COMPLETE:

Code will work with any kind of input but the average preference score is not the optimal one.

BUGS:

None

FILES:

  Included with this project are 5 files:
  Driver.java - contains main method, parses input,uses Allocater to perform course allotment.
  Student.java - Data Structure to hold details for a student- name,preferences,preference score and subjects alloted.
  Allocater.java - Takes an array of students and performs best effort course allotment.
  README.txt the text file you are presently reading

SAMPLE OUTPUT:

$javac *.java
$java Driver input-1.txt output1.txt
'output1.txt' outfile generated successfully.
$cat output1.txt 
Student_1 A B C 6
Student_2 B C D 6
Student_3 C D A 6
Student_4 D A B 6
Student_5 A B C 6
Student_6 B C D 6
Student_7 C D A 6
Student_8 D A B 6
Student_9 A B C 6
Student_10 B C D 6
Student_11 C D A 6
Student_12 D A B 6
Average preference_score is:6.0


TO COMPILE:
extract the tarball (tar xvf <name>)
cd to directory
javac *.java

TO RUN:

java Driver input.txt output.txt (input.txt should be present and 'output.txt' should not be present)

EXTRA CREDIT:
NA

BIBLIOGRAPHY:

http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
https://docs.oracle.com/javase/7/docs/api/


ACKNOWLEDGEMENT:
None