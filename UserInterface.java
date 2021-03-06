
/**
 	* @authors Mwansa, Joseph, Tai, and Chee. 

 	*This is theUserInterface Class 
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserInterface {
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));// Used to read input.
	ShopSystem shop = new ShopSystem();

	/**
	 * this is the main method that start the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UserInterface userInterface = new UserInterface();
		try {
			userInterface.run();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * the run method execute the code and ask which function the user want to
	 * invoke
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void run() throws NumberFormatException, IOException {
		System.out.println("Welcome to the Appliance Shop Management System.");
		try {
			load();
		} catch (Exception e) {
			this.testBed();
		}
		while (true) {
			/*
			 * This is the primary loop. Every time the program returns here, it lists out a
			 * numbered list of possible actions. One action, one use case, one method. The
			 * user will input an integer, and a switch statement will call the
			 * corresponding method.
			 * 
			 */
			System.out.println("What would you like to do?");
			System.out.println("0. \tExit");
			System.out.println("1. \tAdd a new model");
			System.out.println("2. \tAdd a customer");
			System.out.println("3. \tAdd to inventory");
			System.out.println("4. \tBuy a model");
			System.out.println("5. \tFulfill a backorder");
			System.out.println("6. \tEnroll a customer in a repair plan");
			System.out.println("7. \tWithdraw a customer from a repair plan");
			System.out.println("8. \tCharge all repair plans");
			System.out.println("9. \tPrint total revenue from all repair plans.");
			System.out.println("10. \tList appliances");
			System.out.println("11. \tList all users in repair plans");
			System.out.println("12. \tList all users");
			System.out.println("13. \tList all backorders");
			System.out.println("14. \tSave");
			System.out.println("15. \tHelp");

			System.out.print("Your selection: ");
			int selection = Integer.parseInt(bufferedReader.readLine());

			switch (selection) {
			case 0:
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			case 1:
				addAppliance();
				break;
			case 2:
				addCustomer();
				break;
			case 3:
				addToInventory();
				break;
			case 4:
				purchase();
				break;
			case 5:
				fulfillBackorder();
				break;
			case 6:
				enrollCustomer();
				break;
			case 7:
				withdrawCustomer();
				break;
			case 8:
				chargeAllRepairPlans();
				break;
			case 9:
				printTotalRevenue();
				break;
			case 10:
				listAppliance();
				break;
			case 11:
				listEnrolledUsers();
				break;
			case 12:
				listUsers();
				break;
			case 13:
				listBackorders();
				break;
			case 14:
				save();
				break;
			case 15:
				help();
				System.out.println("Help!");
				break;
			default:
				break;
			}
		}
	}

	/**
	 * make a testBed that generate 20 appliances and 5 customers and then test all
	 * the function
	 */
	public void testBed() {
		TestBed testBed = new TestBed(shop);

		System.out.println("Do you want to generate a test bed and invoke the functionality?");
		System.out.println("type y or yes");
		try {
			String Answer = bufferedReader.readLine();
			if (Answer.equalsIgnoreCase("yes") || Answer.equalsIgnoreCase("y")) {
				testBed.makeAppliances();
				testBed.makeCustomers();
				testBed.test();
			}
		} catch (IOException e1) {
			System.out.println(" you inputed incorrectly");
		}
	}

	/**
	 * print information about what each function does
	 */
	public void help() {
		System.out.println("What would you like to do?");
		System.out.println("0. \tExit - Quit the program");
		System.out.println("1. \tAdd a new model - Create a new appliance model");
		System.out.println("2. \tAdd a customer - Add a new customer ");
		System.out.println("3. \tAdd to inventory - add qauntity to an appliance");
		System.out.println("4. \tBuy a model - a customer can buy an appliance");
		System.out.println("5. \tFulfill a backorder - if you have a backorder this fuction will fullfill it");
		System.out.println("6. \tEnroll a customer in a repair plan - if a customer want a repair plan this"
				+ " function enroll them in one");
		System.out.println("7. \tWithdraw a customer from a repair plan - if the customer don't want to be part of the"
				+ " repair plan anymore this function remove them");
		System.out.println("8. \tCharge all repair plans - If there are repair plan make the customer pay for them ");
		System.out.println(
				"9. \tPrint total revenue from all repair plans. - print the amount of money made from repair plan");
		System.out.println("10. \tList appliances - list either all or one specify by the user");
		System.out.println("11. \tList all users in repair plans - list all the repair plan");
		System.out.println("12. \tList all users - list every customer registered");
		System.out.println("13. \tList all backorders - list all the backorder");
		System.out.println("14. \tSave - save the information");
		System.out.println("15. \tHelp - ask for help regarding what each function does");
	}// end help

	/**
	 * print all the users
	 */
	public void listUsers() {
		System.out.println("Getting ready to print all User information");
		shop.listUsers();
	}

	/**
	 * find all the users that are enrolled and print them
	 */
	public void listEnrolledUsers() {
		System.out.println("Getting ready to print all Users in repair plans");
		shop.listEnrolledUsers();
	}

	public void listBackorders() {
		System.out.println("Getting ready to print all Backorders");
		shop.listBackorders();
	}

	/**
	 * print appliance depends on the users
	 * print all or specific appliances
	 */
	public void listAppliance() {

		try {
			System.out.println("press one if you want to list all appliance"
					+ "press two if you want to print a specific appliance");

			int input = Integer.parseInt(bufferedReader.readLine());

			if (input == 1) {
				shop.listAppliances();
			} else if (input == 2) {
				System.out.println("what is the appliance id of the appliance you wish to look at?");
				int id = Integer.parseInt(bufferedReader.readLine());
				shop.listAppliance(id);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * add an appliance 
	 */
	public void addAppliance() {
		try {
			System.out.println("What type of appliance do you wish to add?");
			System.out.println("type 1 for Washer");
			System.out.println("type 2 for Dryer");
			System.out.println("type 3 for Refrigerator");
			System.out.println("type 4 for Furnace");
			int input = Integer.parseInt(bufferedReader.readLine());
			if (input == 1 || input == 2 || input == 3 || input == 4) {
				System.out.println("what is the brand name of the appliance?");
				String brandName = bufferedReader.readLine();
				System.out.println("what is the model name of the appliance?");
				String modelName = bufferedReader.readLine();
				System.out.println("what is the price of the appliance");
				int price = Integer.parseInt(bufferedReader.readLine());
				Appliance appliance;
				if (input == 1) {
					System.out.println("what is the monthly repair cost?");
					int monthlyRepairCost = Integer.parseInt(bufferedReader.readLine());
					appliance = new Washer(modelName, brandName, price, monthlyRepairCost);
					if (shop.addAppliance(appliance)) {
						System.out.println("Added Sucessfully");
						System.out.println("The appliance id is:" + appliance.getApplianceID());
					} else {
						System.out.println("Added Unsucessfully");
					}
				} else if (input == 2) {
					System.out.println("What is the monthly repair cost?");
					int monthlyRepairCost = Integer.parseInt(bufferedReader.readLine());
					appliance = new Dryer(modelName, brandName, price, monthlyRepairCost);
					if (shop.addAppliance(appliance)) {
						System.out.println("added sucessfully");
						System.out.println("the appliance id is:" + appliance.getApplianceID());
					} else {
						System.out.println("added unsucessfully");
					}
				} else if (input == 3) {
					System.out.println("what is the capcity of the refridgerator?");
					int capacity = Integer.parseInt(bufferedReader.readLine());
					appliance = new Refrigerator(modelName, brandName, price, capacity);
					if (shop.addAppliance(appliance)) {
						System.out.println("added sucessfully");
						System.out.println("the appliance id is:" + appliance.getApplianceID());
					} else {
						System.out.println("added unsucessfully");
					}
				} else if (input == 4) {
					System.out.println("what is the heat output?");
					int heatOutPut = Integer.parseInt(bufferedReader.readLine());
					appliance = new Furnace(modelName, brandName, price, heatOutPut);
					if (shop.addAppliance(appliance)) {
						System.out.println("added sucessfully");
						System.out.println("the appliance id is:" + appliance.getApplianceID());
					} else {
						System.out.println("added unsucessfully");
					}
				}
			} else {
				System.out.println("you did not type a number between 1 and 4" + "\n try again");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * add appliance quantity to appliance list
	 */
	public void addToInventory() {

		try {
			System.out.println("enter appliance id");
			int id = Integer.parseInt(bufferedReader.readLine());
			System.out.println("enter amount you wish to add to inventory");
			int amount = Integer.parseInt(bufferedReader.readLine());

			shop.addToInventory(id, amount);

		} catch (IOException e) {
			e.printStackTrace();
		}
	};

	/**
	 * add a new customer
	 */
	public void addCustomer() {
		try {
			System.out.println("enter the customer name");
			String name = bufferedReader.readLine();
			System.out.println("enter the customer address");
			String address = bufferedReader.readLine();
			System.out.println("enter the customer phone number");
			String phoneNumber = bufferedReader.readLine();

			Customer customer = new Customer(name, address, phoneNumber);

			if (shop.addCustomer(customer)) {
				System.out.println("added successfully");
				System.out.println("the customer id is:" + customer.getCustomerID());
			} else {
				System.out.println("added unsucessfully");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * make a purchase/order
	 */
	public void purchase() {
		try {
			System.out.println("Input desired Customer ID");
			int customerID = Integer.parseInt(bufferedReader.readLine());
			Customer customer = shop.getCustomers().searchCustomers(customerID);
			System.out.println("Input desired Appliance ID");
			int applianceID = Integer.parseInt(bufferedReader.readLine());
			Appliance appliance = shop.getAppliances().searchAppliances(applianceID);
			int quantity = Integer.parseInt(bufferedReader.readLine());
			if (shop.addOrder(quantity, customer, appliance)) {
				System.out.println("Order created sucessfully");
				return;
			} else if (appliance instanceof Furnace) {
				System.out.println("Quantity exceeds inventory. Furnaces can not be backordered");
			} else {
				// This part relies on other things not yet finished.
				System.out.println(
						"Quantity exceeds inventory. Would you like to partialy fill the order and backorder the remainder (y/n) ?");
				String answer = bufferedReader.readLine();
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

	/**
	 * full fill back orders 
	 */
	public void fulfillBackorder() throws NumberFormatException, IOException {
		System.out.println("Input desired backorderID");
		int backorderID = Integer.parseInt(bufferedReader.readLine());
		shop.fulfillBackorder(backorderID);

	}

	/**
	 * Save the program 
	 */
	public void save() {
		try {
			FileOutputStream file = new FileOutputStream("storeData");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(shop);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

	/**
	 * Load the program
	 */
	public void load() throws IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream("storeData");
		ObjectInputStream in = new ObjectInputStream(file);
		shop = (ShopSystem) in.readObject();

		in.close();
	}

	/**
	 * Enroll customer in repairPlan
	 */
	public void enrollCustomer() {
		try {
			System.out.println("Input desired Customer ID");
			int customerID = Integer.parseInt(bufferedReader.readLine());
			Customer customer = shop.getCustomers().searchCustomers(customerID);
			System.out.println("Input desired Appliance ID");
			int applianceID = Integer.parseInt(bufferedReader.readLine());
			Appliance appliance = shop.getAppliances().searchAppliances(applianceID);
			System.out.println("Input desired Repair Type ( 1:Full-covered, 2:Limited-covered, or 3:None)");
			int repairType = Integer.parseInt(bufferedReader.readLine());

			double repairBalance = 0;

			if (shop.addRepairPlan(customer, appliance, repairType, repairBalance)) {
				System.out.println("Customer enrolled Sucessfully");
				return;
			} else {
				System.out.println("Customer already enrolled!");
			}
		} catch (Exception e) {
			System.out.println("invalid input");
			return;
		}
	}// end void enrollCustomer

	/**
	 * remove customer from repairPlan
	 */
	public void withdrawCustomer() {
		try {
			System.out.println("Input desired Customer ID");
			int customerID = Integer.parseInt(bufferedReader.readLine());
			Customer customer = shop.getCustomers().searchCustomers(customerID);
			System.out.println("Input desired Appliance ID");
			int applianceID = Integer.parseInt(bufferedReader.readLine());
			Appliance appliance = shop.getAppliances().searchAppliances(applianceID);
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

	/**
	 * make a payment from customer for repair plan
	 */
	public void chargeAllRepairPlans() {
		try {
			System.out.println("Input desired Customer ID");
			int customerID = Integer.parseInt(bufferedReader.readLine());
			Customer customer = shop.getCustomers().searchCustomers(customerID);
			System.out.println("Input desired Appliance ID");
			int applianceID = Integer.parseInt(bufferedReader.readLine());
			Appliance appliance = shop.getAppliances().searchAppliances(applianceID);

			if (shop.hasRepairBalance(customer, appliance)) {
				System.out.println("Customer: " + customer);
				System.out.println("Appliance: " + appliance);

				RepairPlan repairBalance = shop.getRepairPlans().searchRepairBalance(customer, appliance);
				System.out.println("Customer has repair balance: " + repairBalance);

				if (shop.hasRepairBalance(customer, appliance)) {
					System.out.println("You have a balance due. Make a payment? (y/n)");
					String answer = bufferedReader.readLine();
					answer = answer.toLowerCase();
					if (answer.equals("y") || answer.equals("yes")) {
						System.out.println("Enter payment amount: ");
						double payment = Double.parseDouble(bufferedReader.readLine());

						double newBalance = repairBalance.getRepairBalance() - payment;
						while (newBalance < 0) {
							System.out.println("Payment exceeds balance. Please enter a smaller amount: ");
							payment = Double.parseDouble(bufferedReader.readLine());
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
				System.out.println("Customer not enrolled for repair plan");
			}

		} catch (Exception e) {
			System.out.println("invalid input");
			return;
		}
	}// end void chargeAllRepairPlans

	/**
	 * print the total revenue from the repair plan 
	 */
	public void printTotalRevenue() {
		System.out.println("The total revenue is: $" + shop.totalRepairRevenue());
	}

}
