package studentOrientation.student;

import java.io.PrintWriter;

public interface StudentScheduleI {
	public String getName();

	public Long getIdNumber();

	public void printItinerary(PrintWriter printWriter);

	public void buildCampusTourItinerary();

	public void buildBookStoreItenerary();

	public void buildCourseRegistrationItenerary();

	public void buildDormioryRegistrationItenerary();
}
