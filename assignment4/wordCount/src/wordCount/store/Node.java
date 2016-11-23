package wordCount.store;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Node implements NodeObserver, NodeSubject, Cloneable {

	private List<NodeObserver> listeners;
	private Tree tree; // the tree which this node belongs to

	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	private Word data;
	private Node left, right;

	public Node(Word data_in) {
		data = data_in;
		listeners = new ArrayList<>();
	}

	public Node(Word data_in, Tree tree_in) {
		this(data_in);
		tree = tree_in;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Node cloned = (Node) super.clone();
		cloned.data = ((Word) data.clone());
		cloned.listeners = new ArrayList<>();// somehow clear the listners
		// set left,right to null or not?
		return cloned;
	}

	public void setLeftChild(Node leftChild_in) {
		left = leftChild_in;
	}

	public void setRightChild(Node rightChild_in) {
		right = rightChild_in;
	}

	public Node getLeftChild() {
		return left;
	}

	public Node getRightChild() {
		return right;
	}

	public Word getData() {
		return data;
	}

	public void setData(Word data) {
		this.data = data;
		notifyObserver();
	}

	@Override
	public void registerObserver(Node nodeObserver) {
		listeners.add(nodeObserver);
	}

	@Override
	public void removeObserver(Node nodeObserver) {
		listeners.remove(nodeObserver);
	}

	@Override
	public void notifyObserver() {
		for (NodeObserver node : listeners) {
			node.update(this.getData());
		}
	}

	@Override
	public void update(Word updatedData) {
		this.setData(updatedData);
	}

	@Override
	public String toString() {
		return "Node: " + data.toString();
	}
}
