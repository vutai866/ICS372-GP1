
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

	/**
	 *  Insert an order to the order list and return true when successful
	 * @param Order
	 */
	public boolean insertOrder(Order Order) {
		orders.add(Order);
		return true;
	}

	/**
	 *  remove an order from the last order from the order list and then return the list 
	 * @param OrderID
	 */
	public void removeOrder(int orderID) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderID() == orderID) {
				orders.remove(i);
				return;
			}
		}
	}

	/**
	 *  search for a particular order from the list of orders
	 * @param Order,OrderID
	 */
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

	/**
	 *  find the particular back order from order list 
	 * @param Order,targetOrder
	 */
	public Order findBackOrder() {
		Iterator<Order> orderIterator = orders.iterator();
		while (orderIterator.hasNext()) {
			Order targetOrder = orderIterator.next();
			if (targetOrder instanceof Backorder) {
				return targetOrder;
			}
		}
		return null;
	};

	/**
	 *  get and return the list of orders
	 * @param Order
	 */
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public Iterator<Order> iterator() {
		// TODO Auto-generated method stub
		return orders.iterator();
	}
}
