package wordCount.store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
class Node<T> implements  NodeObserver<T>, NodeSubject<T> {

	private List<NodeObserver> listeners;
	private Tree<T> tree;
	private T data;
	private Node<T> left,right;
	public Node(T data_in) {
		data = data_in;
		listeners = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	
	public Node<T> getLeftChild() {
				return left;
	}

	public Node<T> getRightChild() {
		// TODO Auto-generated method stub
		return null;
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
		for (NodeObserver node : listeners ){
			node.update(this.getData());
		}
	}

	@Override
	public void update(T data) {
		// TODO Auto-generated method stub
		//depends what changed
	}
}
