
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

	/**
	 *  get CustomerID from Customer class 
	 * @param customer
	 */
	public Customer getCustomerID() {
		return CustomerID;
	}

	/**
	 * get ApplianceID from Appliance class
	 * @param customer
	 */
	public Appliance getApplianceID() {
		return applianceID;
	}

	/**
	 * set a new CustomerRepairID from Customer class
	 * @param customer
	 */
	public void setCustomerRepairID(Customer CustomerID) {
		this.CustomerID = CustomerID;
	}

	/**
	 * set/change a new ApplianceRepairID from Appliance class
	 * @param customer
	 */
	public void setApplianceRepairID(Appliance applianceID) {
		this.applianceID = applianceID;
	}

	/**
	 * set/change a new RepairPlan  
	 * @param repairPlanType
	 */
	public void setPlanType(int repairPlanType) {
		this.repairPlanType = repairPlanType;
	}

	/**
	 * set/change a new RepairBalance
	 * @param repairBalance
	 */
	public void setRepairBalance(double repairBalance) {
		this.repairBalance = repairBalance;
	}

	/**
	 * get CustomerRepairID
	 * @param repairPlanType
	 */
	public int getRepairPlanType() {
		return repairPlanType;
	}

	/**
	 * get RepairBalance 
	 * @param repairBalance
	 */
	public double getRepairBalance() {
		return repairBalance;
	}

	/**
	 * get Repair Plan ID 
	 * @param repairPlanID
	 */
	public int getPlanID() {
		return planID;
	}
	/**
	 * set/change repairPlanID 
	 * @param repairPlanID
	 */
	public void setPlanID(int planID) {
		this.planID = planID;
	}

	/**
	 * set a new repair plan type 
	 * @param RepairPlan
	 */
	public void setRepairPlanType(int newPlanType) {
		setPlanType(newPlanType);
	}

	/**
	 * change/update new repair balance due to customer make a payment 
	 * @param repairBalance
	 */
	public void changeNewRepairBalance(double newRepairBalance) {
		setRepairBalance(newRepairBalance);
	}

	/**
	 * remove/terminate a repair plan due to customer withdraw repair plan
	 * @param customer,appliance
	 */
	public void removeRepairPlan(Customer customer, Appliance appliance) {
		this.repairPlanType = 0;
		this.repairBalance = 0;
	}

	/**
	 * check for repair balance need to be paid
	 * @param customer,appliance
	 */
	public double repairBalance(Customer customer, Appliance appliance) {
		this.repairBalance = this.repairBalance + this.repairBalance * 0.1;
		return this.repairBalance;
	}

	/**
	 * This toString method returns customer and appliance details for on a repairPlan
	 * @param CustomerID,applianceID
	 */
	public String toString() {
		return "Customer Name: " + CustomerID.getCustomerName() + "\nCustomer Address: "
				+ CustomerID.getCustomerAddress() + "\nCustomer Phone Number: " + CustomerID.getCustomerPhoneNumber()
				+ "\nAppliance Brand: " + applianceID.getBrandName() + "\nAppliance Model: "
				+ applianceID.getApplianceName();
	}

}
