package wordCount.store;

import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
import wordCount.visitors.Visitor;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class BinarySearchTree implements Tree, Cloneable {

	private Node root;

	public BinarySearchTree() {
		Logger.writeMessage("Constructor called for" + this.getClass().getName(), DebugLevel.CONSTRUCTOR);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root_in) {
		root = root_in;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void insert(Word itemToInsert) {
		Logger.writeMessage("BST:insert() called for "+itemToInsert, DebugLevel.TREEINSERT);
		root = insertHelper(root, itemToInsert);
	}
	public void insert(Node nodeWordoInsert) {
	}

	private Node insertHelper(Node parent, Word itemToInsert) {
		if (parent == null)
			return new Node(itemToInsert, this);
		int compare = parent.getData().compareTo(itemToInsert);
		if (compare == 0) {
			return parent;
		} else if (compare > 0) {
			parent.setLeftChild(insertHelper(parent.getLeftChild(), itemToInsert));
		} else {
			parent.setRightChild( insertHelper(parent.getRightChild(), itemToInsert));
		}
		return parent;
	}

	public void remove(Node nodeWordoRemove) {
		remove(nodeWordoRemove.getData());
	}

	public void remove(Word itemWordoRemove) {
		if (itemWordoRemove == null)
			return;
		removeHelper(root, itemWordoRemove);
	}

	private Node removeHelper(Node parent, Word itemWordoRemove) {
		if (parent == null) {
			throw new RuntimeException("Cannot delete the element which doesn't exist.");
		}
		int compare = parent.getData().compareTo(itemWordoRemove);
		if (compare > 0) {
			parent.setLeftChild(removeHelper(parent.getLeftChild(), itemWordoRemove));
		} else if (compare > 0) {
			parent.setRightChild(removeHelper(parent.getRightChild(), itemWordoRemove));
		} else {
			// the current node has to be removed
			if (parent.getLeftChild() == null)
				return parent.getRightChild();
			if (parent.getRightChild() == null)
				return parent.getLeftChild();
			// we need to delete the rightmost node in the left tree.
			Word rightMostData = getRightMostData(parent);
			parent.setData(rightMostData);
			// now delete the leftmost node
			// we can be sure that there will be an empty pointer there
			parent.setLeftChild(removeHelper(parent.getLeftChild(), rightMostData));
		}
		return parent;
	}

	private Word getRightMostData(Node parent) {
		while (parent.getRightChild() != null)
			parent = parent.getLeftChild();
		return parent.getData();
	}

	@Override
	public boolean contains(Word toCheck) {
		if (toCheck == null)
			return false;
		return containsHelper(root, toCheck);
	}

	private boolean containsHelper(Node parent, Word toCheck) {
		if (parent == null) {
			return false;
		}
		int compare = parent.getData().compareTo(toCheck);
		if (compare == 0) {
			return true;
		} else if (compare > 0) {
			return containsHelper(parent.getLeftChild(), toCheck);
		} else {
			return containsHelper(parent.getRightChild(), toCheck);
		}
	}

	@Override
	public boolean contains(Node toCheck) {
		if (toCheck == null)
			return false;
		if (toCheck.getData() == null)
			return false;
		return contains(toCheck.getData());
	}

	public Node getNode(Word data_in) {
		if (data_in == null)
			return null;
		return getNodeHelper(root, data_in);
	}

	private Node getNodeHelper(Node parent, Word toCheck) {
		if (parent == null) {
			return null;
		}
		int compare = parent.getData().compareTo(toCheck);
		if (compare == 0) {
			return parent;
		} else if (compare > 0) {
			return getNodeHelper(parent.getLeftChild(), toCheck);
		} else {
			return getNodeHelper(parent.getRightChild(), toCheck);
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
