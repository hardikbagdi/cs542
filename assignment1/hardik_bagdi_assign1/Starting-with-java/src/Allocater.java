import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Allocater {
	private static Student[] students=null;
	static int filled[] = null;
	static List<Integer> studentSequence = null;
	static char[][] coursesallocated = null;
	private static boolean checkIfFull(char course){
		int count = 0;
		switch(course){
		case 'A':
			count = filled[0];
			break;
		case 'B':
			count = filled[1];
			break;
		case 'C':
			count = filled[2];
			break;
		case 'D':
			count = filled[3];
			break;
		}
		return count==10;
	}
	private static void printSubjectMatrix(){
		for(int i=0;i<12;i++){
			for(int j=0;j<3;j++){
				System.out.print(coursesallocated[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void doAllocation(Student studentsArray[]){
		students = studentsArray;
		filled = new int[]{0,0,0,0};
		studentSequence = new ArrayList<>();
		randomizeStudentSequence();
		coursesallocated = new char[12][3];
		for(int i=0;i<12;i++){
			for(int j=0;j<3;j++){
				coursesallocated[i][j]='x';
			}
		}

		for (int i = 1 ; i <= 4 ; i++){
			for (int j = 0 ; j < 12 ; j++) {
				int k = studentSequence.get(j);
				char subject = students[k].getSubjectByPreference(i);
				if(!checkIfFull(subject) && !studentAllocationDone(k)){
					addStudentToCourse(subject,k);//k is student index.
				}
			}
		}
		//case when a student didn't get 3 courses allocated due to contention
		while(!allDone()){
			shuffleAndUpdate();
		}
		updateStudentRecords();
	}
	private static void shuffleAndUpdate() {
		int studentWithLessCourse,studentToShuffle;
		studentWithLessCourse = getStudentWithLessCourse();
		char courseNeeded = getWhichCourseNeeded(studentWithLessCourse);//0 based course
		studentToShuffle = getStudentToShuffle(studentWithLessCourse,courseNeeded);
		shuffleCourse(studentWithLessCourse,studentToShuffle,courseNeeded);
	}
	private static void shuffleCourse(int studentWithLessCourse, int studentToShuffle, char courseNeeded) {
		//update the course for shuffle student
		updateCourseForShuffleStudent(studentToShuffle,courseNeeded);//update the filled[]
		allocateNewCourseToTheStudent(studentWithLessCourse,courseNeeded);//do not update the filled[]
	}
	private static void allocateNewCourseToTheStudent(int studentWithLessCourse, char courseNeeded) {
		for (int i = 0; i < 3; i++) {
			if(coursesallocated[studentWithLessCourse][i]== 'x'){
				coursesallocated[studentWithLessCourse][i] = courseNeeded;
				return;
			}
		}
	}
	private static void updateCourseForShuffleStudent(int studentToShuffle,char courseNeeded) {
		//at which index to update
		int i,j;
		for ( i = 0; i < 3; i++) {
			if(coursesallocated[studentToShuffle][i] == courseNeeded)
				break;
		}
		//the replacement course
		char newCourseToAllocate = 0;
		int taken[] = new int[4];

		for ( j = 0; j < 3; j++) {
			char c =coursesallocated[studentToShuffle][j];
			switch(c){
			case 'A':
				taken[0]=1;
				break;
			case 'B':
				taken[1]=1;
				break;
			case 'C':
				taken[2]=1;
				break;
			case 'D':
				taken[3]=1;
				break;
			}
		}
		for ( j = 0; j < taken.length; j++) {
			if(taken[j] == 0){

				switch(j){
				case 0:
					newCourseToAllocate = 'A';
					break;
				case 1:
					newCourseToAllocate = 'B';
					break;
				case 2:
					newCourseToAllocate = 'C';
					break;
				case 3:
					newCourseToAllocate = 'D';
					break;
				}
				filled[j]++;
				coursesallocated[studentToShuffle][i] = newCourseToAllocate;
				break;
			}
		}

	}
	private static char getWhichCourseNeeded(int studentWithLessCourse) {
		char courseNeeded = 0 ;
		int taken[] = new int[4];
		if(coursesallocated[studentWithLessCourse][0] == 'x'){
			courseNeeded= students[studentWithLessCourse].getSubjectByPreference(1);
		}
		else{
			for (int i = 0; i < 3; i++) {
				if(coursesallocated[studentWithLessCourse][i] != 'x'){
					char c =coursesallocated[studentWithLessCourse][i];
					switch(c){
					case 'A':
						taken[0]=1;
						break;
					case 'B':
						taken[1]=1;
						break;
					case 'C':
						taken[2]=1;
						break;
					case 'D':
						taken[3]=1;
						break;
					}
				}
			}
			for (int i = 0; i < taken.length; i++) {
				if(taken[i] == 0 ){
					switch(i){
					case 0:
						courseNeeded='A';
						break;
					case 1:
						courseNeeded='B';
						break;
					case 2:
						courseNeeded='C';
						break;
					case 3:
						courseNeeded='D';
						break;
					}
				}
			}
		}
		return courseNeeded;
	}
	private static int getStudentToShuffle(int studentWithLessCourse, char courseNeeded) {
		while(true){

			int r = (int) (Math.random()*12);
			//check if random student is not same as studentWithLessCourse
			if (studentWithLessCourse == r)
				continue;
			//check this student has all courses assigned
			if(coursesallocated[r][0] != 'x' && coursesallocated[r][1] != 'x' && coursesallocated[r][2] != 'x' ){

				if(courseNeeded == coursesallocated[r][0] || courseNeeded == coursesallocated[r][1] || courseNeeded == coursesallocated[r][2]){
					return r;

				}
			}
		}
	}
	private static int getStudentWithLessCourse() {
		int i,student=0;
		for ( i = 0; i < 12; i++) {
			for (int j = 0; j < 3; j++) {
				if(coursesallocated[i][j] == 'x'){
					student=i;
					return student;
				}}
		}
		return -1;
	}
	private static boolean allDone() {
		for (int i = 0; i < students.length; i++) {
			for(int j =0 ; j <3 ; j++){
				if(coursesallocated[i][j]=='x'){
					return false;
				}
			}
		}
		return true;
	}
	private static void randomizeStudentSequence() {
		for (int i = 0; i < 12; i++) {
			studentSequence.add(i);
		}
		//Reference- http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
		Collections.shuffle(studentSequence);
	}
	private static void updateStudentRecords() {
		char courses[] = new char[3];
		for (int i = 0; i < students.length; i++) {
			for(int j =0 ; j <3 ; j++){
				courses[j]=coursesallocated[i][j];
			}
			students[i].setCoursesAlloted(courses);
		}
	}
	private static void addStudentToCourse(char courseName, int StudentNumber) {
		filled[courseIndexFromName(courseName)]++;
		for(int i=0;i<3;i++){
			if(coursesallocated[StudentNumber][i]=='x'){
				coursesallocated[StudentNumber][i] = courseName;
				break;
			}
		}
	}
	private static int courseIndexFromName(char courseName) {
		switch (courseName) {
		case 'A':
			return 0;
		case 'B':
			return 1;
		case 'C':
			return 2;
		case 'D':
			return 3;
		}
		return -1;
	}
	private static boolean studentAllocationDone(int studentNumber) {
		for(int j=0;j<3;j++){
			if (coursesallocated[studentNumber][j] == 'x')
				return false;
		}
		return true;
	}
}