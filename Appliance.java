
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

	// getters and setters

	public int getApplianceID() {
		return applianceID;
	}

	public void setApplianceID(int applianceID) {
		this.applianceID = applianceID;
	}

	public String getApplianceName() {
		return applianceName;
	}

	public void setApplianceName(String applianceName) {
		this.applianceName = applianceName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

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
