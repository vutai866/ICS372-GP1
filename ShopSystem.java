import java.util.Iterator;

public class ShopSystem {
	private CustomerList customers = new CustomerList();
	private OrderList orders = new OrderList();
	private static ApplianceList appliances = new ApplianceList();
	private RepairPlanList repairPlans = new RepairPlanList();

	public void addCustomer(String name, String address,int phone) {
	Customer customer = new Customer(name, address, phone);
		
	customers.insertCustomer(customer);
	System.out.println("added sucessfully");
	System.out.print("remenber it, your id is:"+customer.getCustomerID());
	}
	
	public void addAppliance(String applianceName, String brandName, double price, int quantity){
		Appliance appliance = new Appliance(applianceName, brandName, price, quantity);
		
		appliances.insertAppliance(appliance);
		System.out.println("added sucessfully");
		System.out.print("the appliance id is:"+appliance.getApplianceID());
	}
	
	public static void addToInventory(int applianceId, int amount) {
		Appliance appliance = searchAppliances(applianceId);
		int total = appliance.getQuantity() + amount;
		appliance.setQuantity(total);
	}
	
	public void listAppliances() {
		Iterator<Appliance> applianceIterator = appliances.iterator();
		System.out.println("printing all appliance information");
		while (applianceIterator.hasNext()) {
			Appliance appliance = applianceIterator.next();
			System.out.println(appliance);
		}
	}

	public void listAppliance(int id) {
		System.out.println("printing the appliance information");
		System.out.println(searchAppliances(id));
	}
	
	public void addOrder() {
		
	}
	
	public Customer searchCustomers(int customerID) {
		Iterator<Customer> customerIterator = customers.iterator();
		while(customerIterator.hasNext()) {
			Customer targetCustomer  = customerIterator.next();
			if(targetCustomer.getCustomerID() == customerID) {
				return targetCustomer;
			}
		}
		return null;
	}

	public CustomerList getCustomers() {
		return customers;
	}
	
	public Order searchOrders(int orderID) {
		Iterator<Order> orderIterator = orders.iterator();
		while(orderIterator.hasNext()) {
			Order targetOrder  = orderIterator.next();
			if(targetOrder.getOrderID() == orderID) {
				return targetOrder;
			}
		}
		return null;
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
	
}
