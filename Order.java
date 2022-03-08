public class Order {
    private int orderID;
    private double orderPrice;
    private int quantity;

    public Order(int orderID, double orderPrice, int quantity) {
        this.orderID = orderID;
        this.orderPrice = orderPrice;
        this.quantity = quantity;
    }// end public Order class

    public void setPrice(double newPrice) {
        orderPrice = newPrice;
    }// end setOrder

    public void changeQuantity(int newQuantity){
        quantity = newQuantity;
    }// end changeQuantity
    
} // end class Order
