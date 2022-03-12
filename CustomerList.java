import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerList implements Iterable<Customer>{
	private List<Customer> customers = new ArrayList<>();
	
	public boolean insertCustomer(Customer customer){
		customers.add(customer);
		return true;
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
	
	public List<Customer> getCustomers() {
		return customers;
	}
		
	@Override
	public Iterator<Customer> iterator() {
		// TODO Auto-generated method stub
		return customers.iterator();
	}
}
