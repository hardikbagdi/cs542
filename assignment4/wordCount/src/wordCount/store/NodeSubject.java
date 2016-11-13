package wordCount.store;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public interface NodeSubject<T> {
	public void registerObserver(Node<T> nodeObserver);

	public void removeObserver(Node<T> nodeObserver);

	public void notifyObserver();
}
