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
import wordCount.visitors.Visitor;
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
			Visitor visitor = null;
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
			int nodesToPrint = 50;
			System.out.println("Original Tree:");
			testObserver(tree, clonedTree, nodesToPrint);
			// visitor to increment the count by 1 in the original tree
			visitor = new UpdateVisitor();
			visitor.visit(tree);
			// code to change the original tree and then observer changes
			System.out.println("\n\nAfter updating main tree counts by 1:");
			testObserver(tree, clonedTree, nodesToPrint);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}

	private static void testObserver(Tree tree, Tree clonedTree, int nodesToPrint) {
		Node node = tree.getRoot();
		Node clonedNode = clonedTree.getRoot();
		Stack<Node> stack = new Stack<>();
		Stack<Node> clonedStack = new Stack<>();
		int i = 0;
		// inorder
		while (node != null) {
			stack.push(node);
			clonedStack.push(node);
			node = node.getLeftChild();
			clonedNode = clonedNode.getLeftChild();
		}
		while (stack.size() > 0) {
			node = stack.pop();
			clonedNode = clonedStack.pop();
			if (i++ < nodesToPrint)
				System.out.printf("%-40s  %s \n", node.getData(), clonedNode.getData());
				//System.out.println(node.getData() + "\t\t" + clonedNode.getData());
			else
				return;
			if (node.getRightChild() != null) {
				node = node.getRightChild();
				clonedNode = clonedNode.getRightChild();

				while (node != null) {
					stack.push(node);
					clonedStack.push(node);
					node = node.getLeftChild();
					clonedNode = clonedNode.getLeftChild();
				}
			}
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
