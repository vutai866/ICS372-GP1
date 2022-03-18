public class Refrigerator extends Appliance {

	int capacity;
	public Refrigerator(String applianceName, String brandName, double price,int capacity) {
		super(applianceName, brandName, price);
		this.capacity=capacity;
	}

}
