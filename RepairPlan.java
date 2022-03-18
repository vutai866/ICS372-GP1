
/**
 * @authors Mwansa, Joseph, Tai, and Chee.
 * 
 *          The RepairPlan Class is a blueprint for RepairPlan objects.
 */
public class RepairPlan {
	private int planID;
	private int repairPlanType;
	private double repairBalance;
	private Customer CustomerID;
	private Appliance applianceID;

	/**
	 * The RepairPlan class constructor initializes customerID, repairPlanType, and
	 * repairPlanBalance variables
	 */
	public RepairPlan(Customer CustomerID, Appliance applianceID, int repairPlanType, double repairBalance) {
		this.setCustomerRepairID(CustomerID);
		this.setApplianceRepairID(applianceID);
		this.setRepairPlanType(repairPlanType);
		this.setRepairBalance(repairBalance);
	}

	// getters and setters
	public Customer getCustomerID() {
		return CustomerID;
	}

	public Appliance getApplianceID() {
		return applianceID;
	}

	public void setCustomerRepairID(Customer CustomerID) {
		this.CustomerID = CustomerID;
	}

	public void setApplianceRepairID(Appliance applianceID) {
		this.applianceID = applianceID;
	}

	public void setPlanType(int repairPlanType) {
		this.repairPlanType = repairPlanType;
	}

	public void setRepairBalance(double repairBalance) {
		this.repairBalance = repairBalance;
	}

	public int getRepairPlanType() {
		return repairPlanType;
	}

	public double getRepairBalance() {
		return repairBalance;
	}

	public int getPlanID() {
		return planID;
	}

	public void setPlanID(int planID) {
		this.planID = planID;
	}

	// setRepairPlanType can be used to change Repair Plan Type
	public void setRepairPlanType(int newPlanType) {
		setPlanType(newPlanType);
	}

	// changeNewRepairBalance is used to update repairPlanBalance
	public void changeNewRepairBalance(double newRepairBalance) {
		setRepairBalance(newRepairBalance);
	}

	// removeRepairPlan is used to terminate a repairPlan
	public void removeRepairPlan(Customer customer, Appliance appliance) {
		this.repairPlanType = 0;
		this.repairBalance = 0;
	}

	// repairBalance is used to check repairPlan balance
	public double repairBalance(Customer customer, Appliance appliance) {
		this.repairBalance = this.repairBalance + this.repairBalance * 0.1;
		return this.repairBalance;
	}

	// This toString method returns customer and appliance details for on a
	// repairPlan
	public String toString() {
		return "Customer Name: " + CustomerID.getCustomerName() + "\nCustomer Address: "
				+ CustomerID.getCustomerAddress() + "\nCustomer Phone Number: " + CustomerID.getCustomerPhoneNumber()
				+ "\nAppliance Brand: " + applianceID.getBrandName() + "\nAppliance Model: "
				+ applianceID.getApplianceName();
	}

}
