
/**
 	* @authors Mwansa, Joseph, Tai, and Chee. 

 	*The Appliance Class is a blueprint for appliance objects. 
 */
import java.util.*;

public class Appliance {
	private int applianceID;
	private String applianceName;
	private String brandName;
	private double price;
	private int quantity;

	/**
	 * The Appliance class constructor initializes applianceName, brandName, and
	 * price variables
	 */
	public Appliance(String applianceName, String brandName, double price) {
		// like customer appliance also generate a new id when it created
		this.applianceID = new Random().nextInt(999999999);
		this.applianceName = applianceName;
		this.brandName = brandName;
		this.price = price;
		this.quantity = 0;
	}

	// *getters and setters

	/**
	 *  get/collect appliance ID
	 * @param applianceID
	 */
	public int getApplianceID() {
		return applianceID;
	}

	/**
	 *  set/change appliance ID
	 * @param applianceID
	 */
	public void setApplianceID(int applianceID) {
		this.applianceID = applianceID;
	}

	/**
	 *  get/collect appliance name
	 * @param applianceName
	 */
	public String getApplianceName() {
		return applianceName;
	}

	/**
	 *  set/change appliance name
	 * @param applianceName
	 */
	public void setApplianceName(String applianceName) {
		this.applianceName = applianceName;
	}

	/**
	 *  get/collect the appliance brand name
	 * @param brandName
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 *  set/change the appliance brand name
	 * @param brandName
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 *  get/collect the appliance price
	 * @param price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 *  set/change the appliance price
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 *  get/collect the appliance quantity
	 * @param quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 *  set/change the appliance quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * The toString returns the ID, applianceName, brandName, price, and quantity of
	 * the appliance.
	 */
	public String toString() {
		return "Appliance [applianceID=" + applianceID + ", applianceName=" + applianceName + ", brandName=" + brandName
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}

}
