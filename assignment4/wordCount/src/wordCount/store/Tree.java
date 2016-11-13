package wordCount.store;

import wordCount.visitors.Visitor;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public interface Tree<T extends Comparable<T>> {

	// tree api
	public void insert(T toInsert);
	public void insert(Node<T> node);

	public void remove(T toRemove);
	public void remove(Node<T> node);

	public boolean contains(T toCheck);

	public Node<T> getNode(T data);
	// force accept() implementation
	public void accept(Visitor<T> visitor);
}
