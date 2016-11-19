CS542 Design Patterns
Fall 2016
ASSIGNMENT 4 README FILE

Due Date: Nov 23, 2016
Submission Date: 
Grace Period Used This Project: None
Author(s): HARDIK BAGDI
e-mail(s): hbagdi1@binghamton.edu


PURPOSE:
"wc" command with Visitor, Prototype, and Observer 

PERCENT COMPLETE:
100%

PARTS THAT ARE NOT COMPLETE:
None

BUGS:
None


FILES:
driver/
Driver,java The main Driver code

store/
BinarySearchTree.java The BST implementation which is used for storing the counts
Node.java The node class which represents a node for any tree data structure.
NodeObserver.java The Observer interface for observer pattern
NodeSubject.java The subject interface for observer pattern
Tree.java The tree API to which the BST is implemented
Word.java A class which holds the relevant data for this assignment in any data structure.

util/
FileProcessor.java General purpose file reader and writer; thread=safe
Logger.java General purpose logger

visitors/
CloneObserverVisitor.java  A visitor which clones a given tree data structure and setups observer relation between the orignal and cloned
PopulateVisitor.java A visitor which reads from a FileProcessor and populates a data structure
UpdateVisitor.java A visitor which tests the observer relation set by CloneObserverVisitor.java by incrementing counts by 1 and writing output to files
Visitor.java The visitor interface
WordCountVisitor.java Visitor which reads generates counts given a data structure

SAMPLE OUTPUT:
25 (+3 files)

TO COMPILE:
ant all

TO RUN:
ant -Darg0="input.txt" -Darg1="output.txt" -Darg2="10" run
OR
java wordCount/driver/Driver input.txt output.txt 10

EXTRA CREDIT:
N/A

BIBLIOGRAPHY:
https://docs.oracle.com/javase/7/docs/api/

ACKNOWLEDGEMENT:
N/A