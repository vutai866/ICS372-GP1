
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
	
	/**
	 *  The customerRepairPlan method searches for a particular repairPlan
	 * @param customer and appliance 
	 */
		public Customer customerWithPlan() {
		Iterator<RepairPlan> repairPlanIterator = repairPlans.iterator();
		while (repairPlanIterator.hasNext()) {
			Customer targetRepairPlan = repairPlanIterator.next().getCustomerID();
			return targetRepairPlan;
		}
		return null;
	}

	/**
	 * applyRepairPlan method applies a repairPlan to a customer and appliance
	 * @param customer, appliance
	 */
	public Appliance applianceWithPlan() {
		Iterator<RepairPlan> repairPlanIterator = repairPlans.iterator();
		while (repairPlanIterator.hasNext()) {
			Appliance targetRepairPlan = repairPlanIterator.next().getApplianceID();
			return targetRepairPlan;
		}
		return null;
	}

	/**
	 * add a repairPlan into the list of repairPlans then return true 
	 * InsertRepairPlan adds a repairPlan into the list of repairPlans.
	 * @param RepairPlan
	 */
	public boolean insertRepairPlan(RepairPlan RepairPlan) {
		repairPlans.add(RepairPlan);
		return true;
	}

	/**
	 * remove/terminate a RepairPlan 
	 * @param customerID, appliance
	 */
	public void removeRepairPlan(Customer customer, Appliance appliance) {
		for (int i = 0; i < repairPlans.size(); i++) {
			if (repairPlans.get(i).getCustomerID() == customer && repairPlans.get(i).getApplianceID() == appliance) {
				repairPlans.remove(i);
				return;
			}
		}
	}

	/**
	 * calculate the repair balance and update the repairPlanBalance
	 * @param customer, appliance
	 */
	public void repairCost(Customer customer, Appliance appliance) {
		for (int i = 0; i < repairPlans.size(); i++) {
			if (repairPlans.get(i).getCustomerID() == customer && repairPlans.get(i).getApplianceID() == appliance) {
				repairPlans.get(i).setRepairBalance(
						repairPlans.get(i).getRepairBalance() + repairPlans.get(i).getRepairBalance() * 0.1);
				return;
			}
		}
	}

	/**
	 * colect customer payment and then charge a repair plan by get balance - payment. 
	 * @param customer, payment
	 */
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

	/**
	 * search for the particular repair plan 
	 * @param RepairPlanID
	 */
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

	/**
	 * get the list of all repair plans
	 * @param RepairPlan
	 */
	public List<RepairPlan> getRepairPlans() {
		return repairPlans;
	}

	/**
	 * get the total repair cost and return it 
	 * @param RepairPlan
	 */
	public List<RepairPlan> getTotalCost() {
		return repairPayment;
	} // end getTotalCost

	@Override
	public Iterator<RepairPlan> iterator() {
		// TODO Auto-generated method stub
		return repairPlans.iterator();
	}
} // end RepairPlanList
