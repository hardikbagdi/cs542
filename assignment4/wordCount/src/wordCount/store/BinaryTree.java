package wordCount.store;

import java.util.Iterator;import sun.org.mozilla.javascript.ast.ParenthesizedExpression;
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
		Logger.writeMessage("Constructor called for" + this.getClass().getName(), DebugLevel.CONSTRUCTOR);
	}

	public void insert(T itemToInsert) {
		insertHelper(root, itemToInsert);
	}

	public void insert(Node<T> nodeToInsert){
		
	}
	private Node<T> insertHelper(Node<T> parent,T itemToInsert){
		if (parent == null)
			return new Node<T>(itemToInsert,this);
		int compare = parent.getData().compareTo(itemToInsert);
		if (compare == 0){
			return parent;
		}
	else if(compare <0 ) {
		return insertHelper(parent.getLeftChild(), itemToInsert);
	}
	else{
		return insertHelper(parent.getRightChild(), itemToInsert);
	}
}

	public void remove(T itemToRemove) {
		removeHelper(root, itemToRemove);
	}

	private Node<T> removeHelper(Node<T> parent, T itemToInsert) {
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T toCheck) {
		if (toCheck == null)
			return false;
		return containsHelper(root, toCheck);
	}

	private boolean containsHelper(Node<T> parent, T toCheck){
		if(parent==null){
			return false;
		}
		int compare = parent.getData().compareTo(toCheck);
		if(compare == 0){
			return true;
		}
		else if (compare < 0 ){
			return containsHelper(parent.getLeftChild(), toCheck);
		}
		else{
			return containsHelper(parent.getRightChild(), toCheck);
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
