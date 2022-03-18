
import java.util.Random;

public class FacadeInterface {
	Random random = new Random();
	ShopSystem shop;

	public FacadeInterface(ShopSystem shop) {
		this.shop = shop;
	}

	public void addToInventory() {
		int randomAppliance = random.nextInt(shop.getAppliances().getAppliances().size());
		int id = shop.getAppliances().getAppliances().get(randomAppliance).getApplianceID();
		System.out.println("enter amount you wish to add to inventory");
		int amount = new Random().nextInt(99);
		shop.addToInventory(id, amount);
	};

	public void purchase() {
		try {
			int randomAppliance = random.nextInt(shop.getAppliances().getAppliances().size());
			int randomCustomer = random.nextInt(shop.getCustomers().getCustomers().size());

			System.out.println("Input desired Customer ID");
			int customerID = shop.getCustomers().getCustomers().get(randomCustomer).getCustomerID();
			Customer customer = shop.getCustomers().searchCustomers(customerID);
			System.out.println("Input desired Appliance ID");
			int applianceID = shop.getAppliances().getAppliances().get(randomAppliance).getApplianceID();
			Appliance appliance = shop.getAppliances().searchAppliances(applianceID);
			int quantity = new Random().nextInt(3);
			if (shop.addOrder(quantity, customer, appliance)) {
				System.out.println("Order created sucessfully");
				return;
			} else if (appliance instanceof Furnace) {
				System.out.println("Quantity exceeds inventory. Furnaces can not be backordered");
			} else {
				// This part relies on other things not yet finished.
				System.out.println(
						"Quantity exceeds inventory. Would you like to partialy fill the order and backorder the remainder (y/n) ?");
				String answer = "y";
				answer = answer.toLowerCase();
				if (answer.equals("y") || answer.equals("yes")) {
					int backorderQuantity = quantity - appliance.getQuantity();
					quantity = appliance.getQuantity();
					shop.addOrder(quantity, customer, appliance);
					shop.addBackorder(backorderQuantity, customer, appliance);
				}
			}
		} catch (Exception e) {
			System.out.println("invalid input");
			return;
		}
	}

	public void withdrawCustomer() {
		try {

			Customer customer = shop.getRepairPlans().customerWithPlan();
			Appliance appliance = shop.getRepairPlans().applianceWithPlan();

			if (shop.removeRepairPlan(customer, appliance)) {
				System.out.println("Customer withdrawn sucessfully");
				return;
			} else {
				System.out.println("Customer not enrolled for repair plan");
			}

		} catch (Exception e) {
			System.out.println("invalid input");
			return;
		}
	}// end void withdrawCustomer

	public void printTotalRevenue() {
		System.out.println("The total revenue is: $" + shop.totalRepairRevenue());
	}

	public void chargeAllRepairPlans() {
		try {

			Customer customer = shop.getRepairPlans().customerWithPlan();
			Appliance appliance = shop.getRepairPlans().applianceWithPlan();

			if (shop.hasRepairBalance(customer, appliance)) {
				System.out.println("Customer: " + customer);
				System.out.println("Appliance: " + appliance);

				RepairPlan repairBalance = shop.getRepairPlans().searchRepairBalance(customer, appliance);
				System.out.println("Customer has repair balance: " + repairBalance);

				if (shop.hasRepairBalance(customer, appliance)) {
					System.out.println("You have a balance due. Make a payment? (y/n)");
					String answer = "y";
					answer = answer.toLowerCase();
					if (answer.equals("y") || answer.equals("yes")) {
						System.out.println("Enter payment amount: ");
						double payment = shop.getRepairPlans().searchRepairBalance(customer, appliance)
								.getRepairBalance();

						double newBalance = repairBalance.getRepairBalance() - payment;
						while (newBalance < 0) {
							System.out.println("Payment exceeds balance. Please enter a smaller amount: ");
							payment = shop.getRepairPlans().searchRepairBalance(customer, appliance).getRepairBalance()
									/ 2;
						}
						// Set new balance into RepairPlan Balance
						repairBalance.setRepairBalance(newBalance);
						System.out.println("Payment made sucessfully!\n");
						System.out.println("Your current balance is " + repairBalance.getRepairBalance());
						return;
					} else
						System.out.println("Payment not made. Thank you");

				}
				return;
			} else {
				// This part relies on other things not yet finished.
				System.out.println("Customer not enrolled for repair plan");
			}

		} catch (Exception e) {
			System.out.println("invalid input");
			return;
		}
	}

	public void enrollCustomer() {
		try {

			int randomCustomer = random.nextInt(shop.getCustomers().getCustomers().size());
			int randomApppliance = random.nextInt(shop.getAppliances().getAppliances().size());

			Customer customer = shop.getCustomers().getCustomers().get(randomCustomer);
			Appliance appliance = shop.getAppliances().getAppliances().get(randomApppliance);

			System.out.println("Input desired Repair Type ( 1:Full-covered, 2:Limited-covered, or 3:None)");
			int repairType = random.nextInt(3 + 1 - 1) + 1;

			double repairBalance = 0;

			if (shop.addRepairPlan(customer, appliance, repairType, repairBalance)) {
				System.out.println("Customer enrolled sucessfully");
				return;
			} else {
				System.out.println("Customer already enrolled");
			}
		} catch (Exception e) {
			System.out.print("enroll ");
			System.out.println("invalid input");
			return;
		}
	}// end void enrollCustomer

	public void fulfillBackorder() {
		System.out.println("Input desired backorderID");
		if (!(shop.getOrders().findBackOrder() == null)) {
			int backorderID = shop.getOrders().findBackOrder().getOrderID();
			shop.fulfillBackorder(backorderID);
		}

	}
}
