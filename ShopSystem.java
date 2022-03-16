import java.io.Serializable;
import java.util.Iterator;

public class ShopSystem implements Serializable {
	private CustomerList customers = new CustomerList();
	private OrderList orders = new OrderList();
	private BackorderList backorders = new BackorderList();
	private ApplianceList appliances = new ApplianceList();
	private RepairPlanList repairPlans = new RepairPlanList();

	public boolean addCustomer(Customer customer) {
		if(customers.insertCustomer(customer)) {
		return true;
		}
		else{return false;
		}
	}
	
	public boolean addAppliance(Appliance appliance) {
		if(appliances.insertAppliance(appliance)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addToInventory(int applianceId, int amount) {
		Appliance appliance = appliances.searchAppliances(applianceId);
		int total = appliance.getQuantity() + amount;
		appliance.setQuantity(total);
	}
	
	public boolean addOrder(int size, Customer customer, Appliance appliance) {
		double price = appliance.getPrice() * size;
		if(appliance.getQuantity() >= size) {
			appliance.setQuantity(appliance.getQuantity() - size);
			Order order = new Order(price, size, customer, appliance);
			orders.insertOrder(order);
			return true;
		}
		return false;
	}
	
	public void addBackorder(int size, Customer customer, Appliance appliance) {
		orders.insertOrder(new Backorder(appliance.getPrice(), size, customer, appliance));
	}
	
	public boolean fulfillBackorder(int id) {
		Order order = orders.searchOrders(id);
		if(order instanceof Backorder) {
			if(addOrder(order.getQuantity(),order.getBuyer(),order.getAppliance())) {
				orders.removeOrder(id);
				return true;
			}
		}
		return false;
	}

	public boolean addRepairPlan(Customer customer, Appliance appliance, int repairType, double repairCost){
		if (repairPlans.getRepairPlans() == null){
			RepairPlan plan = new RepairPlan(customer, appliance, repairType, repairCost);
			repairPlans.insertRepairPlan(plan);
		}
		return false;
	} // end boolean addRepairPlan

	public boolean removeRepairPlan(Customer customer, Appliance appliance){
		if (repairPlans.getRepairPlans() != null){
			repairPlans.removeRepairPlan(customer, appliance);
			return true;
		}
		return false;
	} // end boolean removeRepairPlan

	public boolean hasRepairBalance(Customer customer, Appliance appliance){
		if (repairPlans.getRepairPlans() != null){
			repairPlans.repairCost(customer, appliance);
			return true;
		}
		return false;
 	} // end boolean hasRepairBalance

	 public RepairPlan repairCost(Customer customer, Appliance appliance){
		return repairCost(customer, appliance);
	 }// end repairCost

	 public void chargeRepairPlan(Customer customer, double payment){
		return chargeRepairPlan(customer, payment);
	 }// end chargeRepairPlan
	
	public void listAppliances() {
		Iterator<Appliance> applianceIterator = appliances.iterator();
		System.out.println("printing all appliance information");
		while (applianceIterator.hasNext()) {
			Appliance appliance = applianceIterator.next();
			System.out.println(appliance);
		}
	}
	public void listUsers() {
		Iterator<Customer> customerIterator = customers.iterator();
		System.out.println("printing all User information");
		while (customerIterator.hasNext()) {
			Customer customer = customerIterator.next();
			System.out.println(customer);
		}
	}
	public void listEnrolledUsers() {
		Iterator<RepairPlan> repairPlanIterator = repairPlans.iterator();
		System.out.println("printing all Users in repair plans");
		while (repairPlanIterator.hasNext()) {
			RepairPlan repairPlan = repairPlanIterator.next();
			System.out.println(repairPlan);
		}
		
	}
	public void listBackorders() {
		Iterator<Backorder> backorderIterator = backorders.iterator();
		System.out.println("printing all Backorders");
		while (backorderIterator.hasNext()) {
			Backorder backorder = backorderIterator.next();
			System.out.println(backorder);
		}
		
	}
	public void listAppliance(int id) {
		System.out.println("printing the appliance information");
		System.out.println(appliances.searchAppliances(id));
	}
		
	public CustomerList getCustomers() {
		return customers;
	}
	
	public ApplianceList getAppliances() {
		return appliances;
	}

	public void setAppliances(ApplianceList appliances) {
		this.appliances = appliances;
	}

	public RepairPlanList getRepairPlans(){
		return repairPlans;
	}

	public void setRepairPlans(RepairPlanList newRepairPlan){
		this.repairPlans = newRepairPlan;
	}
	
}
