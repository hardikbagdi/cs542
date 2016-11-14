package wordCount.visitors;

import wordCount.store.Node;
import wordCount.store.Tree;

public class CloneObserverVisitor implements Visitor {

	private Tree tree, clonedTree;

	public CloneObserverVisitor() {

	}

	@Override
	public void visit(Tree tree_in) {
		try {
			tree = tree_in;
			clonedTree = (Tree) tree.clone();
			clonedTree.setRoot((Node) (tree.getRoot().clone()));
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
			save.registerObserver(cloned);
			recursiveClone(cloned);
		}
		if (parent.getRightChild() != null) {
			save = parent.getRightChild();
			cloned = (Node) save.clone();
			parent.setRightChild(cloned);
			save.registerObserver(cloned);
			recursiveClone(cloned);
		}
	}

	public Tree getClonedTree() {
		return clonedTree;
	}

}
