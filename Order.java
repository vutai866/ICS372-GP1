public class Order {
    private int orderID;
    private double orderPrice;
    private int quantity;
    private Customer buyer;
    private Appliance appliance;

    public Order(int orderID, double orderPrice, int quantity, Customer orderCustomer, Appliance setAppliance) {
        this.setOrderID(orderID);
        this.setOrderPrice(orderPrice);
        this.setQuantity(quantity);
        this.setBuyer(orderCustomer);
        this.setAppliance(setAppliance);
    }// end public Order class

    public void setPrice(double newPrice) {
        setOrderPrice(newPrice);
    }// end setOrder

    public void changeQuantity(int newQuantity){
        setQuantity(newQuantity);
    }// end changeQuantity

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
    
} // end class Order
