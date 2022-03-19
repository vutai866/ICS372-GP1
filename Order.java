
/**
 	* @authors Mwansa, Joseph, Tai, and Chee. 

 	*The Order Class is a blueprint for Order objects. 
 */
import java.util.*;

public class Order {
	private int orderID;
	private double orderPrice;
	private int quantity;
	private Customer buyer;
	private Appliance appliance;

	/**
	 * The Order class constructor initializes orderPrice, quantity,orderCustomer,
	 * and setAppliance variables
	 */
	public Order(double orderPrice, int quantity, Customer orderCustomer, Appliance setAppliance) {
		this.setOrderID(new Random().nextInt(999999999));
		this.setOrderPrice(orderPrice);
		this.setQuantity(quantity);
		this.setBuyer(orderCustomer);
		this.setAppliance(setAppliance);
	}

	// getters and setters

	/**
	 *  set/change the appliance's price 
	 * @param newPrice
	 */
	public void setPrice(double newPrice) {
		setOrderPrice(newPrice);
	}

	/**
	 *  set/change the appliance's quantity
	 * @param newQuantity
	 */
	public void changeQuantity(int newQuantity) {
		setQuantity(newQuantity);
	}

	/**
	 *  get/collect the order ID
	 * @param orderID
	 */
	public int getOrderID() {
		return orderID;
	}

	/**
	 *  set/change the order ID
	 * @param orderID
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	/**
	 *  get/collect the order price
	 * @param orderPrice
	 */
	public double getOrderPrice() {
		return orderPrice;
	}

	/**
	 *  set/change the order price
	 * @param orderPrice
	 */
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	/**
	 *  get/collect the order quantity
	 * @param quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 *  set/change the order quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 *  get/collect the buyser(customer)
	 * @param buyer
	 */
	public Customer getBuyer() {
		return buyer;
	}

	/**
	 *  set/change the customer/buyer
	 * @param buyer
	 */
	public void setBuyer(Customer buyer) {
		this.buyer = buyer;
	}

	/**
	 *  get/collect the appliance list
	 * @param appliance
	 */
	public Appliance getAppliance() {
		return appliance;
	}

	/**
	 *  set/change the appliance list
	 * @param appliance
	 */
	public void setAppliance(Appliance appliance) {
		this.appliance = appliance;
	}
}