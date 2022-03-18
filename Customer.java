import java.util.*;

public class Customer {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
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

   //* 
    public Customer(String customerName, String customerAddress,
     String customerPhoneNumber) {
	/* 
	the system is suppose to generate a id when a customer is created
	generate a 9 digit id
	*/
        this.customerID = new Random().nextInt(999999999);
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }// end public Customer class
	
    public String toString(){
        return "Customer ID: " + customerID + "\nCustomer Name: " + customerName + 
            "\nCustomer Address: " + customerAddress + "\nCustomer Phone Number: " + 
            customerPhoneNumber;
        
//        + " Has service plan: "  ;
    }// end public String toString()
	//*/

}// end public class Customer


