import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {
	private static boolean checkIfFileExists(String inputfile) {
		if (inputfile == null)
			return false;
		File file = new File(inputfile);
		return file.exists();
	}
	private static void parseInputFile(String infile,Student[] students){
		String name = null;
		int sum=0;
		int prefs[] = new int[4];
		Scanner scanner = null;
		try{
			scanner = new Scanner(new FileReader(infile));
			for (int i = 0; i < students.length; i++) {
				name= scanner.next();
				for (int j = 0; j < prefs.length; j++) {
					prefs[j]=scanner.nextInt();
				}
				sum=0;
				for (int pref : prefs) {
					sum+=pref;
				}
				if(sum != 10){
					throw new IllegalStateException("Preferences not correct");
				}
				students[i] =  new Student(name, prefs);
			}
		}
		catch(IllegalStateException e){
			System.err.println("Preferences for some student in not specified as expected. Possible same preference for two subject or other anomalies");
			e.printStackTrace();
			System.exit(1);
		}
		catch(Exception e){
			System.err.println("Input file format not as expected. Please check input file.");
			e.printStackTrace();
			System.exit(1);
		}
		finally{
			scanner.close();
		}
	}

	private static void generateOutputFile(String outputfile, Student[] students) {
		PrintWriter pw = null;
		char[] courses = null;
		float sum = 0;
		try{
			pw = new PrintWriter(outputfile);
			for (Student student : students) {
				courses = student.getCoursesAlloted();
				sum+=student.getPreferenceScore();
				pw.println(student.getName()+" "+courses[0]+" "+courses[1]+" "+courses[2]+" "+student.getPreferenceScore());
			}
			pw.print("Average preference_score is:"+Float.toString(sum/12));
		}
		catch(Exception e){
			System.err.println("Error occuered while writing to output file.\n");
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			pw.close();
		}
	}
	public static void main(String[] args) {
		if(args.length!=2){
			System.out.println("Usage: Driver <input-filename> <output-filename>");
			System.exit(1);
		}
		String inputfile=args[0];
		String outputfile=args[1];
		Student[] students= new Student[12];
		if(!checkIfFileExists(inputfile)){
			System.out.println("Input file '"+inputfile+"' doesn't exists.");
			System.exit(1);
		}
		if(checkIfFileExists(outputfile)){
			System.out.println("Output file '"+outputfile+"' already exists.");
			System.exit(1);
		}
		try {


			parseInputFile(inputfile,students);

			Allocater.doAllocation(students);	

			for (Student student : students) {
				student.calculatePreferenceScore();
			}	
			generateOutputFile(outputfile,students);
			System.out.println("'"+outputfile+"' outfile generated successfully.");
		} catch (Exception e) {
			System.err.println("Error during processing. Exception Message:");
			e.printStackTrace();
			System.exit(1);
		}
	}	
}
