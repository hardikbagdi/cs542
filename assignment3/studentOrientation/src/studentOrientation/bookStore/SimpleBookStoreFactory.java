package studentOrientation.bookStore;

public class SimpleBookStoreFactory {
	public static BookStoreI createBookStore(BookStoreChoice bookStoreChoice_in) {
		BookStoreI bookStoreI = null;

		if (bookStoreChoice_in == null)
			throw new IllegalArgumentException("Choice cannot be null");
		try {
			switch (bookStoreChoice_in) {
			case UNIVERSITY_BOOK_STORE:
				bookStoreI = new UniversityBookStore();
				break;
			case MANDO_BOOK_STORE:
				bookStoreI = new MandBookStore();
				break;
			default:
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
		}
		return bookStoreI;
	}
}
