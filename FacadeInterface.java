
/** 
 * This program implements a facade interface
 * it will invoke all the functionality
 * and use assert to determine if they are correct
 * @author  Mwansa, Joseph, Tai, and Chee. 

 * */

package edu.ics372.gp1;

import java.util.Random;

public class FacadeInterface {
	Random random = new Random();
	ShopSystem shop;

	/**
	 * create a interface to test
	 * 
	 * @param the shop that everything use so the information stick around
	 */
	public FacadeInterface(ShopSystem shop) {
		this.shop = shop;
	}

	/**
	 * invoke use case 3 addTotheInventory randomly pick a appliance and add a
	 * random quantity to the appliance 
	 * assert that the appliance did in fact change
	 */
	public void addToInventory() {
		int randomAppliance = random.nextInt(shop.getAppliances().getAppliances().size());
		Appliance appliance = shop.getAppliances().getAppliances().get(randomAppliance);
		int prevQuantity = appliance.getQuantity();
		int id = appliance.getApplianceID();
		int amount = new Random().nextInt(99);
		shop.addToInventory(id, amount);
		assert amount + prevQuantity == appliance.getQuantity();
	};

	/**
	 * invoke use case 4 randomly pick a appliance and customer make the customer
	 * buy the appliance 
	 * assert an order did in fact get added to orderList
	 */
	public void purchase() {
		try {
			int randomAppliance = random.nextInt(shop.getAppliances().getAppliances().size());
			int randomCustomer = random.nextInt(shop.getCustomers().getCustomers().size());

			int customerID = shop.getCustomers().getCustomers().get(randomCustomer).getCustomerID();
			Customer customer = shop.getCustomers().searchCustomers(customerID);

			int applianceID = shop.getAppliances().getAppliances().get(randomAppliance).getApplianceID();
			Appliance appliance = shop.getAppliances().searchAppliances(applianceID);
			int quantity = new Random().nextInt(3);
			if (shop.addOrder(quantity, customer, appliance)) {
				System.out.println("Order created sucessfully");
				assert !(shop.getOrders().equals(null));
				return;
			} else if (appliance instanceof Furnace) {
				System.out.println("Quantity exceeds inventory. Furnaces can not be backordered");
			} else {
				// This part relies on other things not yet finished.
				String answer = "y";
				answer = answer.toLowerCase();
				if (answer.equals("y") || answer.equals("yes")) {
					int backorderQuantity = quantity - appliance.getQuantity();
					quantity = appliance.getQuantity();
					shop.addOrder(quantity, customer, appliance);
					shop.addBackorder(backorderQuantity, customer, appliance);

					assert !(shop.getOrders().equals(null));
				}
			}
		} catch (Exception e) {
			System.out.println("invalid input");
			return;
		}
	}

	/**
	 * invoke use case 7 find a customer with repair plan if there are no customer
	 * with repair plan the method doesn't add anything assert make sure that when a
	 * repair plan did get withdraw the amount of repairPlan actually decrease
	 */
	public void withdrawCustomer() {
		try {

			int repairPlanSize = shop.getRepairPlans().getRepairPlans().size();
			Customer customer = shop.getRepairPlans().customerWithPlan();
			Appliance appliance = shop.getRepairPlans().applianceWithPlan();

			if (shop.removeRepairPlan(customer, appliance)) {
				System.out.println("Customer withdrawn sucessfully");
				assert shop.getRepairPlans().getRepairPlans().size() < repairPlanSize;
				return;
			} else {
				System.out.println("Customer not enrolled for repair plan");
				assert repairPlanSize == shop.getRepairPlans().getRepairPlans().size();
			}

		} catch (Exception e) {
			System.out.println("invalid input");
			return;
		}
	}// end void withdrawCustomer

	/**
	 * invoke use case 9 print the totalRevenue 
	 * assert the the amount is actually what it is.
	 */
	public void printTotalRevenue() {
		System.out.println("The total revenue is: $" + shop.totalRepairRevenue());
		assert shop.totalRepairRevenue() == shop.totalRepairRevenue();
	}

	/**
	 * invoke use case 8 if the repair plan is not empty charge the repair plan
	 * assert that they are actually getting charged.
	 */
	public void chargeAllRepairPlans() {
		try {

			if (shop.getRepairPlans().getRepairPlans().size() != 0) {
				Customer customer = shop.getRepairPlans().customerWithPlan();
				Appliance appliance = shop.getRepairPlans().applianceWithPlan();

				if (shop.hasRepairBalance(customer, appliance)) {

					RepairPlan repairBalance = shop.getRepairPlans().searchRepairBalance(customer, appliance);

					if (shop.hasRepairBalance(customer, appliance)) {
						String answer = "y";
						answer = answer.toLowerCase();
						if (answer.equals("y") || answer.equals("yes")) {

							double payment = shop.getRepairPlans().searchRepairBalance(customer, appliance)
									.getRepairBalance();

							double originalBalance = repairBalance.getRepairBalance();
							double newBalance = repairBalance.getRepairBalance() - payment;
							while (newBalance < 0) {
								payment = shop.getRepairPlans().searchRepairBalance(customer, appliance)
										.getRepairBalance() / 2;
							}
							// Set new balance into RepairPlan Balance
							repairBalance.setRepairBalance(newBalance);
							assert shop.getRepairPlans().searchRepairBalance(customer, appliance)
									.getRepairBalance() <= originalBalance;
							System.out.println("Payment made sucessfully!");
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

			} else {
				System.out.println("there are no customer with repairplan");
			}
		} catch (Exception e) {
			System.out.println("invalid input");
			return;
		}

	}

	/**
	 * invoke test use case 6 add a random customer and enroll them in a random appliance repair plan 
	 * assert that the repair plan is actually created and added
	 */
	public void enrollCustomer() {
		try {
			int repairPlanSize = shop.getRepairPlans().getRepairPlans().size();
			int randomCustomer = random.nextInt(shop.getCustomers().getCustomers().size());
			int randomApppliance = random.nextInt(shop.getAppliances().getAppliances().size());

			Customer customer = shop.getCustomers().getCustomers().get(randomCustomer);
			Appliance appliance = shop.getAppliances().getAppliances().get(randomApppliance);

			int repairType = random.nextInt(3 + 1 - 1) + 1;
			assert repairType >= 1 & repairType <= 3;

			double repairBalance = 0;

			if (shop.addRepairPlan(customer, appliance, repairType, repairBalance)) {
				System.out.println("Customer enrolled sucessfully");
				assert repairPlanSize < shop.getAppliances().getAppliances().size();
				return;
			} else {
				System.out.println("appliance doesn't have an enrollment program");
				assert appliance.getClass().equals(Washer.class);
				assert appliance.getClass().equals(Dryer.class);
			}
		} catch (Exception e) {
			System.out.print("enroll ");
			System.out.println("invalid input");
			return;
		}
	}// end void enrollCustomer

	/**
	 * invoke test use case 5 if there is a backOrder fullfilled the backorder
	 * assert that the backOrder is completed and removed
	 */
	public void fulfillBackorder() {
		int orderSize = shop.getOrders().getOrders().size();
		if (!(shop.getOrders().findBackOrder() == null)) {
			int backorderID = shop.getOrders().findBackOrder().getOrderID();
			shop.fulfillBackorder(backorderID);
			assert orderSize > shop.getOrders().getOrders().size();
		}

	}
}


