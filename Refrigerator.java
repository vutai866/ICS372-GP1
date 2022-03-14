public class Refrigerator extends Appliance {

	int capacity;
	public Refrigerator(String applianceName, String brandName, double price, int quantity,int capacity) {
		super(applianceName, brandName, price, quantity);
		this.capacity=capacity;
	}

}
