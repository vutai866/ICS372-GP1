import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApplianceList implements Iterable<Appliance>{
private List<Appliance> appliances = new ArrayList<>();

	public boolean insertAppliance(Appliance appliance){
		appliances.add(appliance);
		return true;
	}

	public List<Appliance> getAppliances() {
		return appliances;
	}
		
	@Override
	public Iterator<Appliance> iterator() {
		// TODO Auto-generated method stub
		return appliances.iterator();
	}
}