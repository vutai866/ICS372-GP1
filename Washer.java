/**
 * @authors Mwansa, Joseph, Tai, and Chee.
 * 
 *          The Washer Class is a blueprint for Washer objects.
 */
public class Washer extends Appliance {

	int repairPlanCost;

	/**
	 * The Washer class constructor initializes applianceName, brandName, price,
	 * repairPlanCost variables with the constructor of the super class, Appliance
	 */
	public Washer(String applianceName, String brandName, double price, int repairPlanCost) {
		super(applianceName, brandName, price);
		this.repairPlanCost = repairPlanCost;
	}

	public int getRepairPlanCost() {
		return repairPlanCost;
	}

}
