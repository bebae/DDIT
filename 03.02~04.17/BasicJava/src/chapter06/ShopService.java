package chapter06;

public class ShopService {
	private static ShopService instance;
	
	public static ShopService getInstance() {
		if (instance == null)
			instance = new ShopService();
		return instance;
	}
	
	private ShopService() {}
}
