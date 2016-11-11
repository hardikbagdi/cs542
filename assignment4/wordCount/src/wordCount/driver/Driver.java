package wordCount.driver;

import java.io.File;

import wordCount.store.BinaryTree;
import wordCount.store.Tree;
import wordCount.util.FileProcessor;
import wordCount.util.FileProcessor.FileMode;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.Visitor;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Driver {
	private static String usageString = "Usage: java Driver <input-file> <output-file> <iteration-count>";

	public static void main(String[] args) {
		Logger.setDebugValue(DebugLevel.NO_OUTPUT);
		try {
			if (!validateArgs(args)) {
				System.out.println(usageString);
				return;
			}
			String inputFile = args[0];
			String outputFile = args[1];
			FileProcessor fileReader, fileWriter;
			Tree tree;
			Visitor visitor1, visitor2, visitor3;
			int iterations = Integer.parseInt(args[2]);

			long startTime = System.currentTimeMillis();
			for (int i = 0; i < iterations; i++) {
				// declare/instantiate the data structure and visitors
				fileReader = new FileProcessor(inputFile, FileMode.READ);
				fileWriter = new FileProcessor(outputFile, FileMode.WRITE);
				tree = new BinaryTree();
				visitor1 = new PopulateVisitor(fileReader);
				visitor2 = new PopulateVisitor(fileWriter);
				// code to visit with the PopulateVisitor
				visitor1.visit(tree);
				// code to visit with the WordCountVisitor.
				visitor2.visit(tree);
			}
			long finishTime = System.currentTimeMillis();
			long totalTime = (finishTime - startTime) / (long) iterations;
			System.out.println(totalTime);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean validateArgs(String[] args) {
		try {
			if (args.length != 3) {
				return false;
			}
			if (!(new File(args[0])).canRead()) {
				System.out.println("Input file is unreadable/doesn't exist.");
				return false;
			}
			File file = new File(args[1]);
			if (file.exists()) {
				file.delete();
			}
			@SuppressWarnings("unused")
			int iterations = Integer.parseInt(args[2]);
			return true;
		} catch (NumberFormatException exception) {
			System.out.println("Please provide a natural number for iteration count.");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return false;
	}
}
