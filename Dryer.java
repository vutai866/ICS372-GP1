
/**
 * @authors Mwansa, Joseph, Tai, and Chee.
 * 
 *          The Dryer Class is a blueprint for Dryer objects.
 */
public class Dryer extends Appliance {

	int repairPlanCost;

	/**
	 * The Dryer class constructor initializes applianceName, brandName, price,
	 * repairPlanCost variables with the constructor of the super class, Appliance
	 */
	public Dryer(String applianceName, String brandName, double price, int repairPlanCost) {
		super(applianceName, brandName, price);
		this.repairPlanCost = repairPlanCost;
	}

	/**
	 *  get/collect the repairPlanCost
	 * @param repairPlanCost
	 */
	public int getRepairPlanCost() {
		return repairPlanCost;
	}
}
