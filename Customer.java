public class Customer {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private int customerPhoneNumber;

    public Customer(int customerID, String customerName, String customerAddress,
     int customerPhoneNumber) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }// end public Customer class

    public String toString(){
        return "Customer ID: " + customerID + "\nCustomer Name: " + customerName + 
            "\nCustomer Address: " + customerAddress + "\nCustomer Phone Number: " + 
            customerPhoneNumber;
    }// end public String toString()


}// end public class Customer


