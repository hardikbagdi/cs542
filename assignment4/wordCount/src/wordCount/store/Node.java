package wordCount.store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Node<T extends Comparable<T>> implements NodeObserver<T>, NodeSubject<T> {

	private List<NodeObserver<T>> listeners;
	private Tree<T> tree; // the tree which this node belongs to
	private T data;
	private Node<T> left, right;

	public Node(T data_in) {
		data = data_in;
		listeners = new ArrayList<>();
	}

	public Node(T data_in, Tree<T> tree_in) {
		this(data_in);
		tree = tree_in;
	}

	public Node<T> getLeftChild() {
		return left;
	}

	public Node<T> getRightChild() {
		// TODO Auto-generated method stub
		return right;
	}

	public T getData() {
		// TODO Auto-generated method stub
		return data;
	}

	public void setData(T data) {
		this.data = data;
		notifyObserver();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public void registerObserver(Node<T> nodeObserver) {
		// TODO Auto-generated method stub
		listeners.add(nodeObserver);
	}

	@Override
	public void removeObserver(Node<T> nodeObserver) {
		// TODO Auto-generated method stub
		listeners.remove(nodeObserver);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (NodeObserver<T> node : listeners) {
			node.update(this.getData());
		}
	}

	@Override
	public void update(T data) {
		// TODO Auto-generated method stub
		// depends what changed
	}
}
