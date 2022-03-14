public class Dryer extends Appliance {

	int repairPlanCost;
	public Dryer(String applianceName, String brandName, double price, int quantity, int repairPlanCost) {
		super(applianceName, brandName, price, quantity);
		this.repairPlanCost=repairPlanCost;
	}
	public int getRepairPlanCost() {
		return repairPlanCost;
	}
}
