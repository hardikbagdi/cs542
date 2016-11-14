package wordCount.store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Node implements NodeObserver, NodeSubject {

	private List<NodeObserver> listeners;
	private Tree tree; // the tree which this node belongs to
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
		// TODO Auto-generated method stub
		return right;
	}

	public Word getData() {
		// TODO Auto-generated method stub
		return data;
	}

	public void setData(Word data) {
		this.data = data;
		notifyObserver();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public void registerObserver(Node nodeObserver) {
		// TODO Auto-generated method stub
		listeners.add(nodeObserver);
	}

	@Override
	public void removeObserver(Node nodeObserver) {
		// TODO Auto-generated method stub
		listeners.remove(nodeObserver);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (NodeObserver node : listeners) {
			node.update(this.getData());
		}
	}

	@Override
	public void update(Word data) {
		// TODO Auto-generated method stub
		// depends what changed
	}
}
