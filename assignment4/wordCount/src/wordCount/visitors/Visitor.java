package wordCount.visitors;

import wordCount.store.Tree;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public interface Visitor<T> {
	public void visit(Tree<T> tree);
}
