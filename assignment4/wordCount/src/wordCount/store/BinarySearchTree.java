package wordCount.store;

import java.util.Iterator;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
import wordCount.visitors.Visitor;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>, Cloneable, Iterable<T> {

	Node<T> root;

	@Override
	public void accept(Visitor<T> visitor) {
		visitor.visit(this);
	}

	public BinarySearchTree() {
		Logger.writeMessage("Constructor called for" + this.getClass().getName(), DebugLevel.CONSTRUCTOR);
	}

	public void insert(T itemToInsert) {
		insertHelper(root, itemToInsert);
	}

	public void insert(Node<T> nodeToInsert) {

	}

	private Node<T> insertHelper(Node<T> parent, T itemToInsert) {
		if (parent == null)
			return new Node<T>(itemToInsert, this);
		int compare = parent.getData().compareTo(itemToInsert);
		if (compare == 0) {
			return parent;
		} else if (compare < 0) {
			return insertHelper(parent.getLeftChild(), itemToInsert);
		} else {
			return insertHelper(parent.getRightChild(), itemToInsert);
		}
	}

	public void remove(Node<T> nodeToRemove) {
		remove(nodeToRemove.getData());
	}

	public void remove(T itemToRemove) {
		if (itemToRemove == null)
			return;
		removeHelper(root, itemToRemove);
	}

	private Node<T> removeHelper(Node<T> parent, T itemToRemove) {
		if (parent == null) {
			throw new RuntimeException("Cannot delete the element which doesn't exist.");
		}
		int compare = parent.getData().compareTo(itemToRemove);
		if (compare < 0) {
			parent.setLeftChild(removeHelper(parent.getLeftChild(), itemToRemove));
		} else if (compare > 0) {
			parent.setRightChild(removeHelper(parent.getRightChild(), itemToRemove));
		} else {
			// the current node has to be removed
			if (parent.getLeftChild() == null)
				return parent.getRightChild();
			if (parent.getRightChild() == null)
				return parent.getLeftChild();
			// we need to delete the rightmost node in the left tree.
			T rightMostData = getRightMostData(parent);
			parent.setData(rightMostData);
			// now delete the leftmost node
			// we can be sure that there will be an empty pointer there
			parent.setLeftChild(removeHelper(parent.getLeftChild(), rightMostData));
		}
		return parent;
	}

	private T getRightMostData(Node<T> parent) {
		while (parent.getRightChild() != null)
			parent = parent.getLeftChild();
		return parent.getData();
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

	private boolean containsHelper(Node<T> parent, T toCheck) {
		if (parent == null) {
			return false;
		}
		int compare = parent.getData().compareTo(toCheck);
		if (compare == 0) {
			return true;
		} else if (compare < 0) {
			return containsHelper(parent.getLeftChild(), toCheck);
		} else {
			return containsHelper(parent.getRightChild(), toCheck);
		}
	}

	public Node<T> getNode(T data) {
		if (data == null)
			return null;
		return getNodeHelper(root, data);
	}

	private Node<T> getNodeHelper(Node<T> parent, T toCheck) {
		if (parent == null) {
			return null;
		}
		int compare = parent.getData().compareTo(toCheck);
		if (compare == 0) {
			return parent;
		} else if (compare < 0) {
			return getNodeHelper(parent.getLeftChild(), toCheck);
		} else {
			return getNodeHelper(parent.getRightChild(), toCheck);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
