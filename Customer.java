
/**
 	* @authors Mwansa, Joseph, Tai, and Chee. 

 	*The Customer Class is a blueprint for customer objects. 
 */
import java.util.*;

/**
 * The Customer class constructor initializes customerID,
 * customerName,customerAddress, and customerPhonenumber variables
 */
public class Customer {
	private int customerID;
	private String customerName;
	private String customerAddress;
	private String customerPhoneNumber;

	// getters and setters
	/**
	 *  get/collect the customer ID
	 * @param customerID
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 *  set/change the customer ID
	 * @param customerID
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 *  get/collect the customer name
	 * @param customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 *  set/change the customer name
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 *  get/collect the customer address
	 * @param customerAddress
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}

	/**
	 *  set/change the customer address
	 * @param customerAddress
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	/**
	 *  get/collect the customer phone number
	 * @param customerPhoneNumber
	 */
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	/**
	 *  set/change the customer phone number
	 * @param customerPhoneNumber
	 */
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	/**
	 *  Add a new customer and store his/her information to system
	 * @param customerName,customerAddress,customerPhoneNumber
	 */
	/*
	 * In this constructor the system generates an 9 digit id when a customer is
	 * created
	 */
	public Customer(String customerName, String customerAddress, String customerPhoneNumber) {
		this.customerID = new Random().nextInt(999999999);
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhoneNumber = customerPhoneNumber;
	}

	// This toString method returns all of the customer details
	public String toString() {
		return "Customer ID: " + customerID + "\nCustomer Name: " + customerName + "\nCustomer Address: "
				+ customerAddress + "\nCustomer Phone Number: " + customerPhoneNumber;

	}

}
