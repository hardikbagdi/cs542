package wordCount.store;

import java.util.Iterator;

import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
import wordCount.visitors.Visitor;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class BinaryTree<T extends Comparable<T>> implements Tree<T>, Cloneable, Iterable<T> {

	Node<T> root;
	
	@Override
	public void accept(Visitor<T> visitor) {
		visitor.visit(this);
	}

	public BinaryTree() {
		Logger.writeMessage("Constructor called for"+this.getClass().getName(), DebugLevel.CONSTRUCTOR);
	}
	public void insert(T itemToInsert){
		
	}
	private Node<T> insertHelper(Node<T> parent,T itemToInsert){
		return null;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T toRemove) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T toCheck) {
		// TODO Auto-generated method stub
		return false;
	}

}
