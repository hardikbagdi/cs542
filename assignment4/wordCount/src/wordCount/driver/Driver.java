package wordCount.driver;

import java.io.File;
import java.util.Stack;

import wordCount.store.BinarySearchTree;
import wordCount.store.Node;
import wordCount.store.Tree;
import wordCount.store.Word;
import wordCount.util.FileProcessor;
import wordCount.util.FileProcessor.FileMode;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
import wordCount.visitors.CloneObserverVisitor;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.UpdateVisitor;
import wordCount.visitors.DSProcessingVisitorI;
import wordCount.visitors.WordCountVisitor;

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
			Tree tree = null;
			DSProcessingVisitorI visitor = null;
			int iterations = Integer.parseInt(args[2]);

			long startTime = System.currentTimeMillis();
			for (int i = 0; i < iterations; i++) {
				// declare/instantiate the data structure and visitors
				fileReader = new FileProcessor(inputFile, FileMode.READ);
				fileWriter = new FileProcessor(outputFile, FileMode.WRITE);
				tree = new BinarySearchTree();
				// code to visit with the PopulateVisitor
				visitor = new PopulateVisitor(fileReader);
				visitor.visit(tree);
				// code to visit with the WordCountVisitor.
				visitor = new WordCountVisitor(fileWriter);
				visitor.visit(tree);
			}
			long finishTime = System.currentTimeMillis();
			long avgTime = (finishTime - startTime) / (long) iterations;
			System.out.println(avgTime);
			// observer relation
			visitor = new CloneObserverVisitor();
			// setup a clone tree
			visitor.visit(tree);
			Tree clonedTree = ((CloneObserverVisitor) visitor).getClonedTree();
			// visitor to increment the count by 1 in the original tree
			visitor = new UpdateVisitor();
			visitor.visit(tree);
			TestObserver testObserver = new TestObserver();
			testObserver.verifyObserverRelation(tree, clonedTree);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

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
