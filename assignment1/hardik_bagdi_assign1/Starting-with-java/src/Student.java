import java.util.Arrays;

public class Student {
	;
	private String name;

	private int preferences[] = null;
	private char coursesAlloted[] = null;
	private int preferenceScore = -1;
	public Student(String n,int[] prefs) {
		try{
			if (n == null || prefs == null)
				throw new IllegalArgumentException("Name or preference array cannot be null");
			if (prefs.length != 4)
				throw new IllegalArgumentException("Length of preferences array should be 4");
			this.name=n;
			this.preferences=new int[4];
			for (int i = 0; i < prefs.length; i++) {
				this.preferences[i]=prefs[i];
			}
			this.coursesAlloted=new char[3];
			for (int i = 0; i < coursesAlloted.length; i++) {
				this.coursesAlloted[i]='x';
			}
			this.preferenceScore=-1;
		}
		catch(Exception e){
			System.err.println("Constructor failed for Student Object.\n");
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb;
		sb = new StringBuilder();
		try {

			sb.append(name);
			sb.append("\nPreferences:");
			sb.append(Arrays.toString(this.preferences));
			sb.append("\nCourses Allocated:");
			sb.append(Arrays.toString(this.coursesAlloted));
			sb.append("\nPreference Score:");
			sb.append(preferenceScore);
		} catch (Exception e) {
			System.err.println("Error in toString() for Student class.\n");
			e.printStackTrace();
		}
		return sb.toString();
	}
	public String getName() {
		return name;
	}
	public int[] getPreferences() {
		return preferences;
	}
	public char[] getCoursesAlloted() {
		return coursesAlloted;
	}
	public void setCoursesAlloted(char courses[]) {
		for (int i = 0; i < coursesAlloted.length; i++) {
			this.coursesAlloted[i]=courses[i];
		}
	}
	public int getPreferenceScore() {
		return preferenceScore;
	}
	public void calculatePreferenceScore() throws IllegalStateException{
		//validate and calculate
		int sumOfPreference=0;
		for (int i = 0; i < coursesAlloted.length; i++) {
			if (coursesAlloted[i]=='x'){
				throw new IllegalStateException("Course allocation not performed");
			}
			else{
				switch (coursesAlloted[i]) {
				case 'A':
					sumOfPreference+=this.preferences[0];
					break;
				case 'B':
					sumOfPreference+=this.preferences[1];
					break;	
				case 'C':
					sumOfPreference+=this.preferences[2];
					break;
				case 'D':
					sumOfPreference+=this.preferences[3];
					break;
				default:
					throw new IllegalStateException("Unkown course allocated");
				}
			}
		}
		this.preferenceScore = sumOfPreference;
	}
	public int getPreferenceBySubject(char subject){
		switch(subject){
		case 'A':
			return this.preferences[0];

		case 'B':
			return this.preferences[1];

		case 'C':
			return this.preferences[2];

		case 'D':
			return this.preferences[3];

		default:
			throw new IllegalArgumentException("unkown subject");
		}
	}
	public char getSubjectByPreference(int preferenceRank){
		if(preferenceRank>4 || preferenceRank <1 )
			throw new IllegalArgumentException("preference should be between 1 to 4(inclusive)");
		int i;
		for ( i = 0; i < preferences.length; i++) {
			if (preferences[i] == preferenceRank){
				break;
			}
		}
		switch (i) {
		case 0:
			return 'A';
		case 1:
			return 'B';
		case 2:
			return 'C';
		case 3:
			return 'D';
		default:
			throw new IllegalStateException();
		}
	}
}