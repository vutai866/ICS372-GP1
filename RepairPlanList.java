
/**
 	* @authors Mwansa, Joseph, Tai, and Chee. 

 	*The RepairPlan List stores repairPlan objects. The class also imports arrayList and list. 
 	*Order List also implements Iterable.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepairPlanList implements Iterable<RepairPlan> {
	private List<RepairPlan> repairPlans = new ArrayList<>();
	private List<RepairPlan> repairPayment = new ArrayList<>();

	// searchRepairBalance searches for a particular repairPlan balance using
	// customer and appliance parameters
	public RepairPlan searchRepairBalance(Customer customer, Appliance appliance) {
		Iterator<RepairPlan> repairPlanIterator = repairPlans.iterator();
		while (repairPlanIterator.hasNext()) {
			RepairPlan targetRepairPlan = repairPlanIterator.next();
			if (targetRepairPlan.getCustomerID() == customer && targetRepairPlan.getApplianceID() == appliance) {
				return targetRepairPlan;
			}
		}
		return null;
	}

	// insertRepairPlan adds a repairPlan into the list of repairPlans.
	public boolean insertRepairPlan(RepairPlan RepairPlan) {
		repairPlans.add(RepairPlan);
		return true;
	}

	// removeRepairPlan terminates a repair plan using customer and appliance
	// parameters
	public void removeRepairPlan(Customer customer, Appliance appliance) {
		for (int i = 0; i < repairPlans.size(); i++) {
			if (repairPlans.get(i).getCustomerID() == customer && repairPlans.get(i).getApplianceID() == appliance) {
				repairPlans.remove(i);
				return;
			}
		}
	}

	// repairCost is used to update the repairPlanBalance using the customer and
	// appliance parameters
	public void repairCost(Customer customer, Appliance appliance) {
		for (int i = 0; i < repairPlans.size(); i++) {
			if (repairPlans.get(i).getCustomerID() == customer && repairPlans.get(i).getApplianceID() == appliance) {
				repairPlans.get(i).setRepairBalance(
						repairPlans.get(i).getRepairBalance() + repairPlans.get(i).getRepairBalance() * 0.1);
				return;
			}
		}
	}

	// chargeRepairPlan is used to charge a repair plan customer for enrolling into
	// a repair plan
	public double chargeRepairPlan(Customer customer, double payment) {
		for (int i = 0; i < repairPlans.size(); i++) {
			if (repairPlans.get(i).getCustomerID() == customer) {
				repairPlans.get(i).setRepairBalance(repairPlans.get(i).getRepairBalance() - payment);
				repairPayment.add(repairPlans.get(i));
				repairPlans.remove(i);
				return payment;
			}
		}
		return 0;
	}

	// searchRepairPlan searches for a particular repair plan using the repairPlanID
	public RepairPlan searchRepairPlan(int repairPlanID) {
		Iterator<RepairPlan> repairPlanIterator = repairPlans.iterator();
		while (repairPlanIterator.hasNext()) {
			RepairPlan targetRepairPlan = repairPlanIterator.next();
			if (targetRepairPlan.getPlanID() == repairPlanID) {
				return targetRepairPlan;
			}
		}
		return null;
	}

	// getRepairPlans returns a lost of all repair plans
	public List<RepairPlan> getRepairPlans() {
		return repairPlans;
	}

	// getTotalCost returns the a list of the total cost of all repair plans
	public List<RepairPlan> getTotalCost() {
		return repairPayment;
	}

	@Override
	public Iterator<RepairPlan> iterator() {
		// TODO Auto-generated method stub
		return repairPlans.iterator();
	}
} // end RepairPlanList
