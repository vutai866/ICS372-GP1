
/**
 	* @authors Mwansa, Joseph, Tai, and Chee. 

 	*The Appliance List stores Appliance objects. The class also imports arrayList and list. 
 	*Appliance List also implements Iterable.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApplianceList implements Iterable<Appliance> {
	private List<Appliance> appliances = new ArrayList<>();

	// insertAppliance adds an appliance into the list of appliances.
	public boolean insertAppliance(Appliance appliance) {
		appliances.add(appliance);
		return true;
	}

	// seachAppliance searches for a particular appliance using the appliance ID.
	public Appliance searchAppliances(int applianceID) {
		Iterator<Appliance> applianceIterator = appliances.iterator();
		while (applianceIterator.hasNext()) {
			Appliance targetAppliance = applianceIterator.next();
			if (targetAppliance.getApplianceID() == applianceID) {
				return targetAppliance;
			}
		}
		return null;
	}

	// getAppliaces returns a list of all the appliances.
	public List<Appliance> getAppliances() {
		return appliances;
	}

	@Override
	public Iterator<Appliance> iterator() {
		// TODO Auto-generated method stub
		return appliances.iterator();
	}
}
