
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
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

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
