package studentOrientation.dormitory;

public class SimpleDormitroyRegistrationFactory {
	public static DormitoryRegistrationI createBookStore(DormitoryRegistrationChoice dormitoryRegistrationChoice_in) {
		DormitoryRegistrationI dormitoryRegistrationI = null;

		if (dormitoryRegistrationChoice_in == null)
			throw new IllegalArgumentException("Choice cannot be null");
		try {
			switch (dormitoryRegistrationChoice_in) {
			case OFFLINE_QUEUE:
				dormitoryRegistrationI = new OfflineDormRegistration();
				break;
			case ONLINE_GAMING_CONTEST:
				dormitoryRegistrationI = new OnlineDormRegistration();
				break;
			default:
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
		}
		return dormitoryRegistrationI;
	}
}
