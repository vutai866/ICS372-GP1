
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
	public void setPrice(double newPrice) {
		setOrderPrice(newPrice);
	}

	public void changeQuantity(int newQuantity) {
		setQuantity(newQuantity);
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Customer getBuyer() {
		return buyer;
	}

	public void setBuyer(Customer buyer) {
		this.buyer = buyer;
	}

	public Appliance getAppliance() {
		return appliance;
	}

	public void setAppliance(Appliance appliance) {
		this.appliance = appliance;
	}

}