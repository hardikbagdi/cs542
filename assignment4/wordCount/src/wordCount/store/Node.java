package wordCount.store;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Node implements NodeI, NodeObserver, NodeSubject {

	@Override
	public NodeI getLeftChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodeI getRightChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodeData getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public void registerObserver(NodeObserver nodeObserver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(NodeObserver nodeObserver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver(NodeI node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(NodeI node) {
		// TODO Auto-generated method stub
		
	}
}
