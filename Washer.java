public class Washer extends Appliance {

	int repairPlanCost;
	public Washer(String applianceName, String brandName, double price, int quantity, int repairPlanCost) {
		super(applianceName, brandName, price, quantity);
		this.repairPlanCost=repairPlanCost;
	}
	public int getRepairPlanCost() {
		return repairPlanCost;
	}

	
}
