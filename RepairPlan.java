
public class RepairPlan{
	private int planID;
    private int repairPlanType;
    private double repairBalance;
    private Customer CustomerID;
    private Appliance applianceID;

    public RepairPlan(Customer CustomerID, Appliance applianceID, int repairPlanType, double repairBalance){
        this.setCustomerRepairID(CustomerID);
        this.setApplianceRepairID(applianceID);
        this.setRepairPlanType(repairPlanType);
        this.setRepairBalance(repairBalance);
    }// end public RepairPlan

    public Customer getCustomerID(){
        return CustomerID;
    }

    public Appliance getApplianceID(){
        return applianceID;
    }

    public void setCustomerRepairID(Customer CustomerID){
        this.CustomerID = CustomerID;
    }

    public void setApplianceRepairID(Appliance applianceID){
        this.applianceID = applianceID;
    }// end applianceRepairID



    // Incase that need to change Repair Plan Type 
    public void setRepairPlanType(int newPlanType){
        setPlanType(newPlanType);
    }// end setRepairPlanType  

    public void changeNewRepairBalance(double newRepairBalance){
        setRepairBalance(newRepairBalance);
    }

    public void setPlanType(int repairPlanType){
        this.repairPlanType = repairPlanType;
    }// end setPlanType

    public void setRepairBalance(double repairBalance){
        this.repairBalance = repairBalance;
    }// end setRepairBalance

    public int getRepairPlanType(){
        return repairPlanType;
    }// end getRepairPlanType

    public double getRepairBalance(){
        return repairBalance;
    }//end getRepairBalance

	public int getPlanID() {
		return planID;
	}

	public void setPlanID(int planID) {
		this.planID = planID;
	}

    public void removeRepairPlan(Customer customer, Appliance appliance){
        this.repairPlanType = 0;
        this.repairBalance = 0;
    }// end removeRepairPlan

    public double repairBalance(Customer customer, Appliance appliance){
        this.repairBalance = this.repairBalance + this.repairBalance * 0.1;
        return this.repairBalance;
    }// end repairBalance
    
    public String toString(){
        return "Customer Name: " + CustomerID.getCustomerName() + "\nCustomer Address: " + CustomerID.getCustomerAddress() + 
            "\nCustomer Phone Number: " + CustomerID.getCustomerPhoneNumber() + "\nAppliance Brand: " + applianceID.getBrandName()
            + "\nAppliance Model: " + applianceID.getApplianceName();
    }// end public String toString()
    
}// end RepairPlan class

