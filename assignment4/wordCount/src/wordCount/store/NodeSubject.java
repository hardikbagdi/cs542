package wordCount.store;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public interface NodeSubject {
	public void registerObserver(NodeObserver nodeObserver);

	public void removeObserver(NodeObserver nodeObserver);

	public void notifyObserver(NodeI node);
}
