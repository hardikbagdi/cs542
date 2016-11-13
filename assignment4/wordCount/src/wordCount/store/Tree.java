package wordCount.store;

import wordCount.visitors.Visitor;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public interface Tree<T> {

	// tree api
	public void insert(T toInsert);
	public T remove(T toRemove);
	public boolean contains(T toCheck);
	
	// force accept() implementation
	public void accept(Visitor<T> visitor);
}
