
/**
 	* @authors Mwansa, Joseph, Tai, and Chee. 

 	*The Customer List stores Customer objects. The class also imports arrayList and list. 
 	*Customer List also implements Iterable.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerList implements Iterable<Customer> {
	private List<Customer> customers = new ArrayList<>();

	// insertCustomer adds a customer into the list of customers.
	public boolean insertCustomer(Customer customer) {
		customers.add(customer);
		return true;
	}

	// seachCustomer searches for a particular customer using the customer ID.
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
	
	// getCustomers returns the list of customers.
	public List<Customer> getCustomers() {
		return customers;
	}

	@Override
	public Iterator<Customer> iterator() {
		// TODO Auto-generated method stub
		return customers.iterator();
	}
}
