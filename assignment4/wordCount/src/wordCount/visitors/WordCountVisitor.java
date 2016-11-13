package wordCount.visitors;

import wordCount.store.Tree;
import wordCount.util.FileProcessor;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class WordCountVisitor<T> implements Visitor<T> {

	private FileProcessor fileProcessor;

	public WordCountVisitor(FileProcessor fileProcessor_in) {
		fileProcessor = fileProcessor_in;
	}

	@Override
	public void visit(Tree<T> tree) {

	}

}
