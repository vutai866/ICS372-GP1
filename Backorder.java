
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

	// This method is used to establish the fulfillment of an order.
	public Order fulfilled() {
		Order order = new Order(super.getOrderPrice(), super.getQuantity(), super.getBuyer(), super.getAppliance());
		return order;
	}

	// toString method to return appliance and customer details
	public String toString() {
		return " Appliance Brand: " + getAppliance().getBrandName() + "\nAppliance Model: "
				+ getAppliance().getBrandName() + "\nCustomer Name: " + getBuyer().getCustomerPhoneNumber()
				+ "\nCustomer ID: " + getBuyer().getCustomerID() + "\nQuantity: " + getQuantity();
	}

}
