
/**
 	* @authors Mwansa, Joseph, Tai, and Chee. 

 	*The Order List stores Order objects. The class also imports arrayList and list. 
 	*Order List also implements Iterable.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderList implements Iterable<Order> {
	private List<Order> orders = new ArrayList<>();

	// insertOrder adds an order into the list of orders.
	public boolean insertOrder(Order Order) {
		orders.add(Order);
		return true;
	}

	// removeOrder removes an order from the last of orders by using the orderID
	public void removeOrder(int orderID) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderID() == orderID) {
				orders.remove(i);
				return;
			}
		}
	}

	// searchOrder searches the list of orders using an order ID to find a
	// particular order.
	public Order searchOrders(int orderID) {
		Iterator<Order> orderIterator = orders.iterator();
		while (orderIterator.hasNext()) {
			Order targetOrder = orderIterator.next();
			if (targetOrder.getOrderID() == orderID) {
				return targetOrder;
			}
		}
		return null;
	}
	
	public Order findBackOrder() {
		Iterator<Order> orderIterator = orders.iterator();
		while (orderIterator.hasNext()) {
			Order targetOrder = orderIterator.next();
			if (targetOrder instanceof BackOrder) {
				return targetOrder;
			}
		}
		return null;
	};

	// getOrders returns a list of orders.
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public Iterator<Order> iterator() {
		// TODO Auto-generated method stub
		return orders.iterator();
	}
}
