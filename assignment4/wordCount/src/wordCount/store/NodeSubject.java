package wordCount.store;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public interface NodeSubject {
	public void registerObserver(Node nodeObserver);

	public void removeObserver(Node nodeObserver);

	public void notifyObserver();
}
