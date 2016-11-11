package wordCount.store;

import wordCount.visitors.Visitor;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public interface Tree {

	// tree api
	// force accept()
	public void accept(Visitor visitor);
}
