
public class RepairPlan{

    private String repairPlanType;
    private boolean hasRepairPlan;
    private double repairCost;
    private Customer CustomerID;
    private Appliance applianceID;

    public RepairPlan(Customer CustomerID, Appliance applianceID, boolean hasRepairPlan, String repairPlanType, double repairCost){
        this.setCustomerRepairID(CustomerID);
        this.setApplianceRepairID(applianceID);
        this.setHasRepairPlan(hasRepairPlan);
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
    public void setRepairPlanType(String newPlanType){
        setPlanType(newPlanType);
    }// end setRepairPlanType  

    public void changeNewRepairCost(double newRepairCost){
        setRepairCost(newRepairCost);
    }

    public void setPlanType(String repairPlanType){
        this.repairPlanType = repairPlanType;
    }// end setPlanType

    public void setHasRepairPlan(boolean hasRepairPlan){
        this.hasRepairPlan = hasRepairPlan;
    }// end setHasRepairPlan

    public void setRepairCost(double repairCost){
        this.repairCost = repairCost;
    }// end setRepairCost

    public String getRepairPlanType(){
        return repairPlanType;
    }// end getRepairPlanType

    public boolean getHasRepairPlan(){
        return hasRepairPlan;
    }// end getHasRepairPlan

    public double getRepairCost(){
        return repairCost;
    }//end getRepairCost

}// end RepairPlan class

