
/**
 * @authors Mwansa, Joseph, Tai, and Chee.
 * 
 *          The Backorder Class extends order and is a blueprint for backorders
 *          objects.
 */
public class Backorder extends Order {
	/**
	 * The Backorder class constructor initializes orderPrice, quantity,
	 * orderCustomer, setAppliance variables with the constructor of the super
	 * class, Order
	 */
	public Backorder(double orderPrice, int quantity, Customer orderCustomer, Appliance setAppliance) {
		super(orderPrice, quantity, orderCustomer, setAppliance);
		// TODO Auto-generated constructor stub
	}

	/**
	 * The method fullfilled the order
	 * turn it into a regular order to be remenbered
	 */
	public Order fulfilled() {
		Order order = new Order(super.getOrderPrice(), super.getQuantity(), super.getBuyer(), super.getAppliance());
		return order;
	}

	
	/**
	 * a to string method that show what backorder look like when print
	 */
	public String toString() {
		return " Appliance Brand: " + getAppliance().getBrandName() + "\nAppliance Model: "
				+ getAppliance().getBrandName() + "\nCustomer Name: " + getBuyer().getCustomerPhoneNumber()
				+ "\nCustomer ID: " + getBuyer().getCustomerID() + "\nQuantity: " + getQuantity();
	}

}
