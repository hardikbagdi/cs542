package wordCount.visitors;

import wordCount.store.Tree;

public class CloneObserverVisitor implements Visitor {

	private Tree tree, clonedTree;

	public CloneObserverVisitor() {

	}

	@Override
	public void visit(Tree tree_in) {
		tree = tree_in;
	}

	public Tree getClonedTree() {
		return clonedTree;
	}

}
