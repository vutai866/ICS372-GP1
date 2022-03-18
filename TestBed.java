import java.util.Random;

public class TestBed {
	ShopSystem shop;

	public TestBed(ShopSystem shop) {
		super();
		this.shop = shop;
	}
	
	public void test() {
		// using assert statement we check our result from our userinterface to see if they are correct
		// our userinterface don't return anything so i dont know how we can check. 
		
	}
	
	public void makeCustomers() {

		Customer chee = new Customer("chee", "1835 73rd Ave NE Medina Washington", "6126079639" );
		Customer tai = new Customer("tai", "1562 12th ave N MPLS MN","6121275743" );
		Customer jarosch = new Customer("jarosch", "200 16th ave n MPLS MN", "6126239743");
		Customer boston = new Customer("boston","1234 15th ave N Mpls MN","6129372812");
		Customer john = new Customer("john", "20 17th ave N MPLS MN", "6120284732" );
		shop.getCustomers().insertCustomer(boston);
		shop.getCustomers().insertCustomer(chee);
		shop.getCustomers().insertCustomer(tai);
		shop.getCustomers().insertCustomer(jarosch);
		shop.getCustomers().insertCustomer(john);
	}

	public void makeAppliances() {
		for (int i = 0; i > 20; i++) {
			int rand = new Random().nextInt(4);
			double price = new Random().nextInt(9999);
			if (rand == 0) {
				int repairPlanCost = new Random().nextInt(1000);
				Appliance appliance = new Washer("washer"+i, "sears"+i, price , repairPlanCost);
				shop.getAppliances().insertAppliance(appliance);
			}else if (rand == 1){
				int repairPlanCost = new Random().nextInt(1000);
				Appliance appliance = new Dryer("dryer"+i, "drya20s"+i, price , repairPlanCost);
				shop.getAppliances().insertAppliance(appliance);
				
			}else if (rand == 2) {
				int capacity = new Random().nextInt(50);
				Appliance appliance = new Refrigerator("Refrigerator"+i, "Coldg0"+i, price , capacity);
				shop.getAppliances().insertAppliance(appliance);
			}else if (rand == 3) {
				int HeatOutPut = new Random().nextInt(999999);
				Appliance appliance = new Furnace("Furnace"+i, "HeatOne23"+i, price , HeatOutPut);
				shop.getAppliances().insertAppliance(appliance);
			}
		}
	}

}
