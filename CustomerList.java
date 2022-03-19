
/**
 	* @authors Mwansa, Joseph, Tai, and Chee. 

 	*The Customer List stores Customer objects. The class also imports arrayList and list. 
 	*Customer List also implements Iterable.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CustomerList implements Iterable<Customer> {
	private List<Customer> customers = new ArrayList<>();

	/**
	 *  Insert a customer to the customer list and return true when successful
	 * @param customer
	 */
	public boolean insertCustomer(Customer customer) {
		customers.add(customer);
		return true;
	}
	
	public Customer random() {
		Iterator<Customer> customerIterator = customers.iterator();
		int randomNumber = new Random().nextInt(customers.size());
		int count = 0;
		while (customerIterator.hasNext()) {
			Customer targetAppliance = customerIterator.next();
			if (count == randomNumber) {
				return targetAppliance;
			}
			count++;
		}
		return null;
	}

	/**
	 *  search for the particular customer by customerID
	 * @param customerID
	 */
	public Customer searchCustomers(int customerID) {
		Iterator<Customer> customerIterator = customers.iterator();
		while (customerIterator.hasNext()) {
			Customer targetCustomer = customerIterator.next();
			if (targetCustomer.getCustomerID() == customerID) {
				return targetCustomer;
			}
		}
		return null;
	}
	
	/**
	 *  get/collect the customer list
	 * @param customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}

	@Override
	public Iterator<Customer> iterator() {
		// TODO Auto-generated method stub
		return customers.iterator();
	}
}
