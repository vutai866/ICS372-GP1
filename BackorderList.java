import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BackorderList implements Iterable<Backorder> {
	private List<Backorder> backorders = new ArrayList<>();

	public List<Backorder> getBackorders() {
		return backorders;
	}

	@Override
	public Iterator<Backorder> iterator() {
		// TODO Auto-generated method stub
		return backorders.iterator();
	}
}
