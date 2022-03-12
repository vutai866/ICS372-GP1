import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderList implements Iterable<Order>{
private List<Order> Orders = new ArrayList<>();

	public boolean insertOrder(Order Order){
		Orders.add(Order);
		return true;
	}
	
	public Order searchOrders(int orderID) {
		Iterator<Order> orderIterator = orders.iterator();
		while(orderIterator.hasNext()) {
			Order targetOrder  = orderIterator.next();
			if(targetOrder.getOrderID() == orderID) {
				return targetOrder;
			}
		}
		return null;
	}

	public List<Order> getOrders() {
		return Orders;
	}
		
	@Override
	public Iterator<Order> iterator() {
		// TODO Auto-generated method stub
		return Orders.iterator();
	}
}
