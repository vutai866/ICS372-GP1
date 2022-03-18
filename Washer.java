public class Washer extends Appliance {

	int repairPlanCost;
	public Washer(String applianceName, String brandName, double price, int repairPlanCost) {
		super(applianceName, brandName, price);
		this.repairPlanCost=repairPlanCost;
	}
	public int getRepairPlanCost() {
		return repairPlanCost;
	}

	
}
