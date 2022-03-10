import java.util.Iterator;

public class ShopSystem {
	private CustomerList customers = new CustomerList();
	private OrderList orders = new OrderList();
	private ApplianceList appliances = new ApplianceList();

	public void addCustomer(String name, String address,int phone) {
	
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
	
	public Appliance searchAppliances(int applianceID) {
		Iterator<Appliance> applianceIterator = appliances.iterator();
		while(applianceIterator.hasNext()) {
			Appliance targetAppliance  = applianceIterator.next();
			if(targetAppliance.getApplianceID() == applianceID) {
				return targetAppliance;
			}
		}
		return null;
	}
	
}
