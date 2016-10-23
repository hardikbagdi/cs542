CS542 Design Patterns
Fall 2016
ASSIGNMENT 3 README FILE

Due Date: October 27, 2016
Submission Date: October 27, 2016
Grace Period Used This Project: None
Author(s): HARDIK BAGDI
e-mail(s): hbagdi1@binghamton.edu


PURPOSE:
Apply the design principles and patterns you have learned so far to develop and test code for the given problem.

PERCENT COMPLETE:

100.0 

PARTS THAT ARE NOT COMPLETE:

None

BUGS:

None

FILES:

studentOrientation/activityExpenses:
CaloriesI.java Interface for calories of activities
CarbonCostI.java Interface for carbon costs of activities
CurrencyCostI.java Interface for cost of activities
DurationI.java Interface for duration of activities
PaymentMethod.java enum representing various payment methods possible for activities

studentOrientation/bookStore:
Books.java enum for holding all books in the bookstores and their details
BookStoreChoice.java choice enum for different types of book stores
BookStoreI.java Interface for Book Store activity
MandBookStore.java Concrete class
SimpleBookStoreFactory.java SimpleFactory class used to create objects based on parameter
UniversityBookStore.java Concrete class

studentOrientation/campusTour:
BusRide.java Concrete class 
CampusTourChoice.java choice enum for different types of tours
CampusTourI.java Interface for campus tour activity
SimpleCampusTourFactory.java SimpleFactory class used to create objects based on parameter
TourCosts.javaa enum holding prices for different kind of tours
WalkingTour.java Concrete class

studentOrientation/courseRegistration:
CourseRegistrationChoice.java choice enum for different types of course registration methods
CourseRegistrationI.java Interface for course registration activity
ElectronicCourseRegistration.java Concrete class
OfflineCourseRegistration.java Concrete class
SimpleCourseRegistrationFactory.java SimpleFactory class used to create objects based on parameter
UniversityFees.java enum to hold all University fees related to course like tuition, registration, technology fees, etc

studentOrientation/dormitory:
DormFees.java enum holding dorm fees; used by the concrete classes
DormitoryRegistrationChoice.java choice enum for different types of dorm registration methods
DormitoryRegistrationI.java Interface for dorm registration activity
OfflineDormRegistration.java Concrete class
OnlineDormRegistration.java Concrete class
SimpleDormitroyRegistrationFactory.java SimpleFactory class used to create objects based on parameter

studentOrientation/driver:
Driver.java Driver code

studentOrientation/OrientationScheduleBuilder:
StudentOrientationScheduleWorkshopI.java Builder interface
StudentOrientationScheduleWorkshop.java Workshop class which builds the itinerary for a student orientation

studentOrientation/student:
StudentScheduleI.java Interface for schedule of a student for the orientation
StudentSchedule.java  Concrete class implementing the above interface

studentOrientation/util:
Logger.java Logger class for debugging purpose


SAMPLE OUTPUT:

Name:Larry David
ID:42

Orientation Itinerary:
Take a tour of the campus
Bearcat Bus TourHop on the bus and get the feel of University campus!
Average time: 15 minutes
Average Calories spent: 50 calories
Average carbon cost:0.4 tonnnes
Cost of Tour(USD):2.0

Book your dorm room
Online Dorm Registration
Register for Dorm. Compete against others in an online game to get a room based on your performance.
Average time: 10 minutes
Average Calories spent: 30 calories
Average carbon cost:0.08 tonnnes
Cost of Registration(USD):11220.0

Register for courses
Offline Course Registration
Register for your courses at the Registrar's Office.
Average time: 60 minutes
Average Calories spent: 80 calories
Average carbon cost:0.008 tonnnes
Cost of Registration(USD):1067.0
Payment Method:Cheque

Buy books needed
Mando Book-Store
Buy books in a minute.
Average time: 15 minutes
Average Calories spent: 100 calories
Average carbon cost:0.004 tonnnes
Cost of books(USD):84.0

TO COMPILE:

ant all

TO RUN:

ant run

EXTRA CREDIT:

N/A

BIBLIOGRAPHY:
https://docs.oracle.com/javase/7/docs/api/

ACKNOWLEDGEMENT:
N/A