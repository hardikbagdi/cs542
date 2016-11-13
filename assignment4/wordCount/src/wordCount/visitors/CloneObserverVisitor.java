package wordCount.visitors;

import wordCount.store.Tree;

public class CloneObserverVisitor<T> implements Visitor<T> {

	private Tree<T> tree, clonedTree;

	public CloneObserverVisitor() {

	}

	@Override
	public void visit(Tree<T> tree_in) {
		tree = tree_in;
	}

	public Tree<T> getClonedTree() {
		return clonedTree;
	}

}
