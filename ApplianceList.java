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

	/**
	 *  Add a new appliance to the list of appliances
	 * @param appliance
	 */
	public boolean insertAppliance(Appliance appliance) {
		appliances.add(appliance);
		return true;
	}

	/**
	 *  search for appliance in the appliance list by its ID 
	 * @param applianceID
	 */
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

	/**
	 *  get/collect the appliance list
	 * @param appliances
	 */
	public List<Appliance> getAppliances() {
		return appliances;
	}

	@Override
	public Iterator<Appliance> iterator() {
		// TODO Auto-generated method stub
		return appliances.iterator();
	}
}
