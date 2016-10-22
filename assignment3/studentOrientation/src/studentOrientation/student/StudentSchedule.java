package studentOrientation.student;

import studentOrientation.bookStore.BookStoreChoice;
import studentOrientation.bookStore.BookStoreI;
import studentOrientation.bookStore.SimpleBookStoreFactory;
import studentOrientation.campusTour.CampusTourChoice;
import studentOrientation.campusTour.CampusTourI;
import studentOrientation.campusTour.SimpleCampusTourFactory;
import studentOrientation.courseRegistration.CourseRegistrationChoice;
import studentOrientation.courseRegistration.CourseRegistrationI;
import studentOrientation.courseRegistration.SimpleCourseRegistrationFactory;
import studentOrientation.dormitory.DormitoryRegistrationChoice;
import studentOrientation.dormitory.DormitoryRegistrationI;
import studentOrientation.dormitory.SimpleDormitroyRegistrationFactory;
import studentOrientation.util.Logger;
import studentOrientation.util.Logger.DebugLevel;

public class StudentSchedule implements StudentScheduleI {

	private String name;
	private Long ID;
	CampusTourChoice campusTourChoice;
	BookStoreChoice bookStoreChoice;
	DormitoryRegistrationChoice dormitoryRegistrationChoice;
	CourseRegistrationChoice courseRegistrationChoice;
	CourseRegistrationI courseRegistration;
	BookStoreI bookStore;
	CampusTourI campusTour;
	DormitoryRegistrationI dormitoryRegistration;

	public StudentSchedule(String name_in, Long ID_in, CampusTourChoice campusTourChoice_in,
			BookStoreChoice bookStoreChoice_in, DormitoryRegistrationChoice dormitoryRegistrationChoice_in,
			CourseRegistrationChoice courseRegistrationChoice_in) {

		Logger.writeMessage("Constructor called " + this.getClass().getName(), DebugLevel.CONSTRUCTOR);
		if (name_in == null || ID_in == null || campusTourChoice_in == null || bookStoreChoice_in == null
				|| dormitoryRegistrationChoice_in == null || courseRegistrationChoice_in == null) {
			throw new IllegalArgumentException();
		}
		setName(name_in);
		setID(ID_in);
		campusTourChoice = campusTourChoice_in;
		bookStoreChoice = bookStoreChoice_in;
		dormitoryRegistrationChoice = dormitoryRegistrationChoice_in;
		courseRegistrationChoice = courseRegistrationChoice_in;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public Long getID() {
		return ID;
	}

	private void setID(Long iD) {
		ID = iD;
	}

	@Override
	public Long getIdNumber() {
		return getID();
	}

	@Override
	public void buildCampusTourItinerary() {
		this.campusTour = SimpleCampusTourFactory.createCampusTour(this.campusTourChoice);
	}

	@Override
	public void buildBookStoreItenerary() {
		this.bookStore = SimpleBookStoreFactory.createBookStore(this.bookStoreChoice);
	}

	@Override
	public void buildCourseRegistrationItenerary() {
		this.courseRegistration = SimpleCourseRegistrationFactory.createBookStore(this.courseRegistrationChoice);
	}

	@Override
	public void buildDormioryRegistrationItenerary() {
		this.dormitoryRegistration = SimpleDormitroyRegistrationFactory
				.createBookStore(this.dormitoryRegistrationChoice);
	}

	@Override
	public void printItinerary() {

	}

}
