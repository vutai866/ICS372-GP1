
/**
 	* @authors Mwansa, Joseph, Tai, and Chee. 

 	*The ShopSystem Class implement a system for a company. 
	*it keep records of objects such as customer and appliances. 
	*it has functions that allows it interact with the object
 	*It also implements iterator and serializable
 */
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class ShopSystem implements Serializable {
	private CustomerList customers = new CustomerList();
	private OrderList orders = new OrderList();
	private ApplianceList appliances = new ApplianceList();
	private RepairPlanList repairPlans = new RepairPlanList();

	/**
	 * add a customer to the customerList
	 * @param The customer to be added
	 * @return if true or false if it suceed in adding the customer
	 */
	public boolean addCustomer(Customer customer) {
		if (customers.insertCustomer(customer)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * add an appliance to the applianceList
	 * @param The appliance to be added
	 * @return if true or false if it suceed in adding the appliance
	 */
	public boolean addAppliance(Appliance appliance) {
		if (appliances.insertAppliance(appliance)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * add int amount to the appliance quantity.
	 * @param applianceId is use to find the appliance 
	 * @param amount is the amount to be added to the appliance 
	 */
	public void addToInventory(int applianceId, int amount) {
		Appliance appliance = appliances.searchAppliances(applianceId);
		int total = appliance.getQuantity() + amount;
		appliance.setQuantity(total);
	}

	/**
	 * add an order
	 * @param size is how many appliance is being brought
	 * @param customer is the person buying the appliance
	 * @param appliance is the appliance being brought
	 * @return true or false if the order is made
	 */
	public boolean addOrder(int size, Customer customer, Appliance appliance) {
		double price = appliance.getPrice() * size;
		if (appliance.getQuantity() >= size) {
			appliance.setQuantity(appliance.getQuantity() - size);
			Order order = new Order(price, size, customer, appliance);
			orders.insertOrder(order);
			return true;
		}
		return false;
	}
	/**
	 * make and add a backOrder to orderList
	 * @param size is how many is being brought
	 * @param customer is the person buying the appliance
	 * @param appliance is the appliance
	 */
	public void addBackorder(int size, Customer customer, Appliance appliance) {
		orders.insertOrder(new Backorder(appliance.getPrice(), size, customer, appliance));
	}
 	/**
   	* fullfilled and remove the backOrder
 	* @param id is used to find the backOrder
 	* @return true or false if the backOrder is fullfilled
 	*/
	public boolean fulfillBackorder(int id) {
		Order order = orders.searchOrders(id);
		if (order instanceof Backorder) {
			if (addOrder(order.getQuantity(), order.getBuyer(), order.getAppliance())) {
				orders.removeOrder(id);
				return true;
			}
		}
		return false;
	}
	/**
	 * Add repair plan and insert it into repairPlanList
	 * @param customer is the person enrolling in repairplan
	 * @param appliance the appliance
	 * @param repairType is the type of repair plan
	 * @param repairCost is the cost
	 * @return true or false if repairplan is made
	 */
	public boolean addRepairPlan(Customer customer, Appliance appliance, int repairType, double repairCost) {
		RepairPlan plan = new RepairPlan(customer, appliance, repairType, repairCost);
		repairPlans.insertRepairPlan(plan);
		return false;
	} // end boolean addRepairPlan
	/**
	 * remove a repair plan
 	* @param customer the customer in the repair plan
	 * @param appliance is the appliance in the repair plan to be removed
 	* @return true or false if it removed
 	*/
	public boolean removeRepairPlan(Customer customer, Appliance appliance) {
		if (repairPlans.getRepairPlans() != null) {
			repairPlans.removeRepairPlan(customer, appliance);
			return true;
		}
		return false;
	} // end boolean removeRepairPlan
	/**
	 * check to see if customer have repairPlan
 	* @param customer to be checked
 	* @param appliance use to help check
 	* @return true or false if customer does have repair plan
 	*/
	public boolean hasRepairBalance(Customer customer, Appliance appliance) {
		if (repairPlans.getRepairPlans() != null) {
			return true;
		}
		return false;
	} // end boolean hasRepairBalance

	/**
	*return the cost of the repair plan
	*@param customer used to find the repairplan
	*@param appliance used to find the repairplan
	*/
	public RepairPlan repairCost(Customer customer, Appliance appliance) {
		return repairCost(customer, appliance);
	 }// end repairCost
	 
	/**
	 * print the repair revenue
	 * @return the revenue
	 */
	 public double totalRepairRevenue() {
		 double total = 0;
		 List<RepairPlan> plans = repairPlans.getTotalCost();
		 for(int index = 0; index < plans.size(); index++) {
			 total += plans.get(index).getRepairBalance();
		 }
		 return total;
	 }
	
	// end repairCost
	/**
	 * print all the appliances
	 */
	public void listAppliances() {
		Iterator<Appliance> applianceIterator = appliances.iterator();
		System.out.println("printing all appliance information");
		while (applianceIterator.hasNext()) {
			Appliance appliance = applianceIterator.next();
			System.out.println(appliance);
		}
	}
	/**
	 * print all the user
	 */
	public void listUsers() {
		Iterator<Customer> customerIterator = customers.iterator();
		System.out.println("printing all User information");
		while (customerIterator.hasNext()) {
			Customer customer = customerIterator.next();
			System.out.println(customer);
		}
	}
	/**
	 * print out all enrolled users
	 */
	public void listEnrolledUsers() {
		Iterator<RepairPlan> repairPlanIterator = repairPlans.iterator();
		System.out.println("printing all Users in repair plans");
		while (repairPlanIterator.hasNext()) {
			RepairPlan repairPlan = repairPlanIterator.next();
			System.out.println(repairPlan);
		}

	}
	/**
	 * print out all the backOrder
	 */
	public void listBackorders() {
		Iterator<Order> orderIterator = orders.iterator();
		System.out.println("printing all Backorders");
		while (orderIterator.hasNext()) {
			Order order = orderIterator.next();
			if (order instanceof Backorder) {
				System.out.println(order);
			}
		}

	}
	/**
	 * given an appliance id all  the appliance
	 * @param id used to find the appliance to print
	 */
	public void listAppliance(int id) {
		System.out.println("printing the appliance information");
		System.out.println(appliances.searchAppliances(id));
	}

	public OrderList getOrders() {
		return orders;
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

	public RepairPlanList getRepairPlans() {
		return repairPlans;
	}

	public void setRepairPlans(RepairPlanList newRepairPlan) {
		this.repairPlans = newRepairPlan;
	}
}
