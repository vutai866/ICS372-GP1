import java.io.Serializable;
import java.util.Iterator;

public class ShopSystem implements Serializable {
	private CustomerList customers = new CustomerList();
	private OrderList orders = new OrderList();
	private ApplianceList appliances = new ApplianceList();
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
	
}
