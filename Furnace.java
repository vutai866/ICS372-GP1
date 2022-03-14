
public class Furnace extends Appliance {
	int heatOutPut;
	public Furnace(String applianceName, String brandName, double price, int quantity,int heatOutPut) {
		super(applianceName, brandName, price, quantity);
		this.heatOutPut=heatOutPut;
	}

}
