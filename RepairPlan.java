
public class RepairPlan{
	private int planID;
    private int repairPlanType;
    private double repairCost;
    private Customer CustomerID;
    private Appliance applianceID;

    public RepairPlan(Customer CustomerID, Appliance applianceID, int repairPlanType, double repairCost){
        this.setCustomerRepairID(CustomerID);
        this.setApplianceRepairID(applianceID);
        this.setRepairPlanType(repairPlanType);
        this.setRepairCost(repairCost);
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

    public void changeNewRepairCost(double newRepairCost){
        setRepairCost(newRepairCost);
    }

    public void setPlanType(int repairPlanType){
        this.repairPlanType = repairPlanType;
    }// end setPlanType

    public void setRepairCost(double repairCost){
        this.repairCost = repairCost;
    }// end setRepairCost

    public int getRepairPlanType(){
        return repairPlanType;
    }// end getRepairPlanType

    public double getRepairCost(){
        return repairCost;
    }//end getRepairCost

	public int getPlanID() {
		return planID;
	}

	public void setPlanID(int planID) {
		this.planID = planID;
	}

    public void removeRepairPlan(Customer customer, Appliance appliance){
        this.repairPlanType = 0;
        this.repairCost = 0;
    }// end removeRepairPlan

    public double repairCost(Customer customer, Appliance appliance){
        this.repairCost = this.repairCost + this.repairCost * 0.1;
        return this.repairCost;
    }// end repairCost
    
}// end RepairPlan class

