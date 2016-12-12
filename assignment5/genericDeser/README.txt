CS542 Design Patterns
Fall 2016
ASSIGNMENT 5 README FILE

Due Date: Dec 15, 2016
Submission Date: 
Grace Period Used This Project: None
Author(s): HARDIK BAGDI
e-mail(s): hbagdi1@binghamton.edu

PURPOSE:
Comparing Objects in Java and Java reflection

PERCENT COMPLETE:
100%

PARTS THAT ARE NOT COMPLETE:
None

BUGS:
None

FILES:
driver/
Driver,java The main Driver code

util/
First.java Sample Class for de-serialization 
Second.java Another sample class for de-serialization as per guidelines
PopulateObjects.java Class which builds data structures of First and Second classes by de-serializing data read from a plain text file
Logger.java General purpose logger

fileOperations/
FileProcessor.java General purpose file reader and writer; thread=safe

SAMPLE OUTPUT:
Number of unique First objects: 4952
Total Number of First objects: 4952
Number of unique Second objects: 5018
Total Number of Second objects: 5048

DATA STRUCTURES:
The primary purpose of this assignment was to get the count of distinct objects and total objects of  a class. 
Two Hashmaps for the two classes have been used to keep distinct objects and corresponding duplicate object counts.
This provide fast lookup of total distinct objects(size of the map) and total objects(iterate through the hashmap and sum over the values). 

TO COMPILE:
ant all

TO RUN:
ant run -Darg0="input-1.txt" -Darg1="0"
OR
java genericDeser/driver/Driver input-1.txt 0

EXTRA CREDIT:
N/A

BIBLIOGRAPHY:
https://docs.oracle.com/javase/7/docs/api/
https://www.mkyong.com/java/java-how-to-overrides-equals-and-hashcode/

ACKNOWLEDGEMENT:
N/A