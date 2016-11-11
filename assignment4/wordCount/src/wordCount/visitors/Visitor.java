package wordCount.visitors;

import wordCount.store.Tree;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public interface Visitor {
	public void visit(Tree tree);
}
