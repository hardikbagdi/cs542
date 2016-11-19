package wordCount.visitors;

import java.util.Stack;

import wordCount.store.Node;
import wordCount.store.Tree;
import wordCount.util.FileProcessor;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class WordCountVisitor implements Visitor {

	private FileProcessor fileProcessor;
	private int uniqueWords, totalWords, characters;

	public WordCountVisitor(FileProcessor fileProcessor_in) {
		fileProcessor = fileProcessor_in;
	}

	@Override
	public void visit(Tree tree) {
		try {
			parseTree(tree);
			printToFile();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}

	private void parseTree(Tree tree) {
		Node root = tree.getRoot();
		Stack<Node> stack = new Stack<>();
		Node left, right;
		stack.push(root);
		Node cur;
		while (!stack.isEmpty()) {
			cur = stack.pop();
			left = cur.getLeftChild();
			right = cur.getRightChild();
			if (left != null)
				stack.push(left);
			if (right != null)
				stack.push(right);
			characters += cur.getData().getCharCount() * cur.getData().getCount();
			totalWords += cur.getData().getCount();
			uniqueWords++;
		}

	}

	private void printToFile() throws IllegalAccessException {
		fileProcessor.putLine("Total words:\t" + totalWords);
		fileProcessor.putLine("Distinct Words:\t" + uniqueWords);
		fileProcessor.putLine("Characters:\t" + characters);
	}

}
