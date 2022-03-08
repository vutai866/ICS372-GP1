public class CustomerList implements Iterable<Customer>{
private List<Customer> customers = new ArrayList<>();

public boolean insertCustomer(Customer customer){
	customers.add(customer);
	return true;}

public List<Customer> getCustomers() {
	return customers;
}
	
@Override
public Iterator<Customer> iterator() {
	// TODO Auto-generated method stub
	return customers.iterator();
};
}
