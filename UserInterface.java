import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.*;

public class UserInterface {
	BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));//Used to read input.
	ShopSystem shop;
	
	public static void main(String[] args) {
		UserInterface userInterface = new UserInterface();
		try {
		userInterface.run();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void run() throws NumberFormatException, IOException {
		System.out.println("Welcome to the Appliance Shop Management System.");
		while(true) {
			/*This is the primary loop.
			 * Every time the program returns here, it lists out a numbered list
			 * of possible actions. One action, one use case, one method.
			 * The user will input an integer, and a switch statement will call
			 * the corresponding method.
			 * 
			 */
			System.out.println("What would you like to do?");
			System.out.println("1. \tAdd a new model");
			System.out.println("2. \tAdd a customer");
			System.out.println("3. \tAdd to invetnroy");
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
			System.out.println("15. \tQuit");
		
			int selection = Integer.parseInt( bufferedReader.readLine());
			
			switch(selection) {
			case 1:
				break;
			case 2:
				addCustomer();
				break;
			case 3:
				addToInventory();
				break;
			case 4:
				purchase();
			}
		}
	}
	
	public void listAppliance() {
		
		try {
		System.out.println("press one if you want to list all appliance"
				+ "press two if you want to print a specific appliance");
	
			int input = Integer.parseInt(bufferedReader.readLine());
			
			if(input == 1) {
				shop.listAppliances();
			}
			else if(input == 2) {
				System.out.println("what is the appliance id of the appliance you wish to look at?");
				int id = Integer.parseInt(bufferedReader.readLine());
				shop.listAppliance(id);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void addAppliance() {
		try {
			System.out.println("what is the brand name of the appliance?");
			String brandName = bufferedReader.readLine();
			System.out.println("what is the brand name of the appliance?");
			String modelName = bufferedReader.readLine();
			System.out.println("what is the price of the appliance");
			int price = Integer.parseInt(bufferedReader.readLine());
			System.out.println("what is the quantity of the appliance?");
			int quantity = Integer.parseInt(bufferedReader.readLine());

			Appliance appliance = new Appliance(modelName, brandName, price, quantity);
			if(shop.addAppliance(appliance)) {
				System.out.println("added sucessfully");
				System.out.println("the appliance id is:" + appliance.getApplianceID());
			}
			else {
				System.out.println("added unsucessfully");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
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

	public void addCustomer() {
		try {
			System.out.println("enter the customer name");
			String name = bufferedReader.readLine();
			System.out.println("enter the customer address");
			String address = bufferedReader.readLine();
			System.out.println("enter the customer phone number");
			int phoneNumber = Integer.parseInt(bufferedReader.readLine());

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
	};
	
	public void purchase() {
		try {
			System.out.println("Input desired Customer ID");
			int customerID = Integer.parseInt( bufferedReader.readLine());
			Customer customer = shop.getCustomers().searchCustomers(customerID);
			System.out.println("Input desired Appliance ID");
			int applianceID = Integer.parseInt( bufferedReader.readLine());
			Appliance appliance = shop.getAppliances().searchAppliances(applianceID);
			int quantity = Integer.parseInt(bufferedReader.readLine());
			if(shop.addOrder(quantity, customer, appliance)) {
				System.out.println("Order created sucessfully");
				return;
			}else {
				//This part relies on other things not yet finished.
				System.out.println("Quantity exceeds inventory. Would you like to create a backorder (y/n) ?");
				String answer = bufferedReader.readLine();
				answer = answer.toLowerCase();
				if(answer.equals("y")) {
					
				}
			}	
		}catch(Exception e) {
			System.out.println("invalid input");
			return;
		}
	}
	
	public void Save() {
		try {
			FileOutputStream file = new FileOutputStream("storeData");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(shop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

}
