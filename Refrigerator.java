/**
 * @authors Mwansa, Joseph, Tai, and Chee.
 * 
 *          The Refrigerator Class is a blueprint for Refrigerator objects.
 */
public class Refrigerator extends Appliance {

	int capacity;

	/**
	 * The Refrigerator class constructor initializes applianceName, brandName, price,
	 * capacity variables with the constructor of the super class, Appliance
	 */
	public Refrigerator(String applianceName, String brandName, double price, int capacity) {
		super(applianceName, brandName, price);
		this.capacity = capacity;
	}

}
