package wordCount.driver;

import java.util.Stack;

import wordCount.store.Node;
import wordCount.store.Tree;
import wordCount.util.FileProcessor;
import wordCount.util.FileProcessor.FileMode;

public class TestObserver {

	public void verifyObserverRelation(Tree orignalTree, Tree clonedTree) throws IllegalAccessException {
		FileProcessor originalFile = new FileProcessor("original-tree.txt", FileMode.WRITE);
		FileProcessor clonedFile = new FileProcessor("cloned-tree.txt", FileMode.WRITE);
		Node node = orignalTree.getRoot();
		Node clonedNode = clonedTree.getRoot();
		Stack<Node> stack = new Stack<>();
		Stack<Node> clonedStack = new Stack<>();
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
			// System.out.printf("%-40s %s \n", node.getData(),
			// clonedNode.getData());
			originalFile.putLine(node.getData().toString());
			clonedFile.putLine(clonedNode.getData().toString());
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
}
