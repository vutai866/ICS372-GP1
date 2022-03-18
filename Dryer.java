public class Dryer extends Appliance {

	int repairPlanCost;
	public Dryer(String applianceName, String brandName, double price, int repairPlanCost) {
		super(applianceName, brandName, price);
		this.repairPlanCost=repairPlanCost;
	}
	public int getRepairPlanCost() {
		return repairPlanCost;
	}
}
