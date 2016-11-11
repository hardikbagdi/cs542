package wordCount.visitors;

import wordCount.store.Tree;
import wordCount.util.FileProcessor;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class PopulateVisitor implements Visitor {

	private FileProcessor fileProcessor;

	public PopulateVisitor(FileProcessor fileProcessor_in) {
		fileProcessor = fileProcessor_in;
	}

	@Override
	public void visit(Tree tree) {

	}
}
