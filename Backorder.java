
public class Backorder extends Order {

	public Backorder( double orderPrice, int quantity, Customer orderCustomer, Appliance setAppliance) {
		super(orderPrice, quantity, orderCustomer, setAppliance);
		// TODO Auto-generated constructor stub
	}
	
	public Order fulfilled() {
		Order order = new Order(super.getOrderPrice(),super.getQuantity(),super.getBuyer(),super.getAppliance());
		return order;
	}
	  public String toString(){
	        return " Applaince Brand: " + getAppliance().getBrandName() + "\nAppliance Model: " + getAppliance().getBrandName()+ 
	            "\nCustomer Name: " + getBuyer().getCustomerPhoneNumber() + "\nCustomer ID: " + getBuyer().getCustomerID()
	            + "\nQuantity: " + getQuantity();
	  }

}
