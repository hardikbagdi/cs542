package wordCount.visitors;

import java.util.StringTokenizer;

import wordCount.store.Node;
import wordCount.store.Tree;
import wordCount.store.Word;
import wordCount.util.FileProcessor;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class PopulateVisitor implements DSProcessingVisitorI {

	private FileProcessor fileProcessor;
	private Tree tree;

	public PopulateVisitor(FileProcessor fileProcessor_in) {
		fileProcessor = fileProcessor_in;
	}

	@Override
	public void visit(Tree tree_in) {
		tree = tree_in;
		String line, singleWord;
		Word word;
		Node node;
		StringTokenizer st;
		try {
			line = fileProcessor.getLine();

			while (line != null) {
				st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					singleWord = st.nextToken();
					word = new Word(singleWord, 1);
					node = tree.getNode(word);
					if (node == null) {
						tree.insert(word);
					} else {
						word = node.getData();
						word.setCount(word.getCount() + 1);
					}
				}
				line = fileProcessor.getLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}
}
