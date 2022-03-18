
public class Furnace extends Appliance {
	int heatOutPut;
	public Furnace(String applianceName, String brandName, double price,int heatOutPut) {
		super(applianceName, brandName, price);
		this.heatOutPut=heatOutPut;
	}

}
