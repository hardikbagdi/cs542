package wordCount.visitors;

import wordCount.store.Node;
import wordCount.store.Tree;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class CloneObserverVisitor implements DSProcessingVisitorI {

	private Tree tree, clonedTree;

	public CloneObserverVisitor() {

	}

	@Override
	public void visit(Tree tree_in) {
		try {
			tree = tree_in;
			clonedTree = (Tree) tree.clone();
			Node clonedRoot = (Node) (tree.getRoot().clone());
			clonedTree.setRoot(clonedRoot);
			clonedRoot.setTree(clonedTree);
			tree.getRoot().registerObserver(clonedTree.getRoot());
			recursiveClone(clonedTree.getRoot());

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}

	private void recursiveClone(Node parent) throws CloneNotSupportedException {
		Node save, cloned;
		if (parent.getLeftChild() != null) {
			save = parent.getLeftChild();
			cloned = (Node) save.clone();
			parent.setLeftChild(cloned);
			cloned.setTree(clonedTree);
			save.registerObserver(cloned);
			recursiveClone(cloned);
		}
		if (parent.getRightChild() != null) {
			save = parent.getRightChild();
			cloned = (Node) save.clone();
			parent.setRightChild(cloned);
			cloned.setTree(clonedTree);
			save.registerObserver(cloned);
			recursiveClone(cloned);
		}
	}

	public Tree getClonedTree() {
		return clonedTree;
	}

}
