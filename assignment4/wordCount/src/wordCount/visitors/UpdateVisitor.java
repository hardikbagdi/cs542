package wordCount.visitors;

import wordCount.store.Node;
import wordCount.store.Tree;
import wordCount.store.Word;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class UpdateVisitor implements DSProcessingVisitorI {

	private Tree tree;

	@Override
	public void visit(Tree tree_in) {
		tree = tree_in;
		updateCounts(tree.getRoot());
	}

	private void updateCounts(Node node) {
		if (node == null){
			return;
		}
		Word word = node.getData();
		word.setCount(word.getCount() + 1);
		node.setData(word);
		if (node.getLeftChild() != null) {
			updateCounts(node.getLeftChild());
		}
		if (node.getRightChild() != null) {
			updateCounts(node.getRightChild());
		}
	}
}
