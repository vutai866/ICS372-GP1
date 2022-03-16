import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepairPlanList implements Iterable<RepairPlan>{
    private List<RepairPlan> repairPlans = new ArrayList<>();
    private List<RepairPlan> repairPayment = new ArrayList<>();

    public boolean insertRepairPlan(RepairPlan RepairPlan){
        repairPlans.add(RepairPlan);
        return true;
    }// end boolean insertRepairPlan

    public void removeRepairPlan(Customer customer, Appliance appliance){
        for (int i = 0; i < repairPlans.size(); i++) {
            if (repairPlans.get(i).getCustomerID() == customer && repairPlans.get(i).getApplianceID() == appliance) {
                repairPlans.remove(i);
                return;
            }
        }
    }// end removeRepairPlan

    public void repairCost(Customer customer, Appliance appliance){
        for (int i = 0; i < repairPlans.size(); i++) {
            if (repairPlans.get(i).getCustomerID() == customer && repairPlans.get(i).getApplianceID() == appliance) {
                repairPlans.get(i).setRepairCost(repairPlans.get(i).getRepairCost() + repairPlans.get(i).getRepairCost() * 0.1);
                return;
            }
        }
    }// end hasRepairBalance

    public double chargeRepairPlan(Customer customer, double payment){
        for (int i = 0; i < repairPlans.size(); i++) {
            if (repairPlans.get(i).getCustomerID() == customer) {
                repairPlans.get(i).setRepairCost(repairPlans.get(i).getRepairCost() - payment);
                repairPayment.add(repairPlans.get(i));
                repairPlans.remove(i);
                return payment;
            }
        }
        return 0;
    }// end chargeRepairPlan
    
    public RepairPlan searchRepairPlan(int repairPlanID){
		Iterator<RepairPlan> repairPlanIterator = repairPlans.iterator();
		while(repairPlanIterator.hasNext()) {
			RepairPlan targetRepairPlan  = repairPlanIterator.next();
			if(targetRepairPlan.getPlanID() == repairPlanID) {
				return targetRepairPlan;
			}
		}
		return null;
	}

    public List<RepairPlan> getRepairPlans() {
        return repairPlans;
    }

    public List<RepairPlan> getTotalCost(){
        return repairPayment;
    }

    @Override
    public Iterator<RepairPlan> iterator() {
        // TODO Auto-generated method stub
        return repairPlans.iterator();
    }
} // end RepairPlanList
