/**
 * @authors Mwansa, Joseph, Tai, and Chee.
 * 
 *          The Furnace Class is a blueprint for Furnace objects.
 */
public class Furnace extends Appliance {
	int heatOutPut;

	/**
	 * The Furnace class constructor initializes applianceName, brandName, price,
	 * heatOutPut variables with the constructor of the super class, Appliance
	 */
	public Furnace(String applianceName, String brandName, double price, int heatOutPut) {
		super(applianceName, brandName, price);
		this.heatOutPut = heatOutPut;
	}

}
