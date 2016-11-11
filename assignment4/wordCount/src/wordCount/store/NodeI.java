package wordCount.store;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public interface NodeI extends Cloneable {
	public NodeI getLeftChild();

	public NodeI getRightChild();

	public NodeData getData();
}