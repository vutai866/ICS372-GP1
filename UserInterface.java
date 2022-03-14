import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.*;

public class UserInterface {
	BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));//Used to read input.
	ShopSystem shop;
	
	public static void main(String[] args) {
		System.out.println("Appliance Shop Management System.");
		while(true) {
			/*This is the primary loop.
			 * Every time the program returns here, it lists out a numbered list
			 * of possible actions. One action, one use case, one method.
			 * The user will input an integer, and a switch statement will call
			 * the corresponding method.
			 * 
			 */
			
		}
	}
	
	public void addAppliance() {
		try {
			
			System.out.println("what type of appliance do you wish to add?");
			System.out.println("type 1 for washer");
			System.out.println("type 2 for dryer");
			System.out.println("type 3 for refrigerator");
			System.out.println("type 4 for furnace");
			int input = Integer.parseInt(bufferedReader.readLine());

			System.out.println("what is the brand name of the appliance?");
			String brandName = bufferedReader.readLine();
			System.out.println("what is the model name of the appliance?");
			String modelName = bufferedReader.readLine();
			System.out.println("what is the price of the appliance");
			int price = Integer.parseInt(bufferedReader.readLine());
			System.out.println("what is the quantity of the appliance?");
			int quantity = Integer.parseInt(bufferedReader.readLine());
			Appliance appliance;
			
			if(input==1) {
				System.out.println("what is the monthly repair cost?");
				int monthlyRepairCost = Integer.parseInt(bufferedReader.readLine());
				appliance = new Washer(modelName, brandName, price, quantity,monthlyRepairCost);
				if (shop.addAppliance(appliance)) {
					System.out.println("added sucessfully");
					System.out.println("the appliance id is:" + appliance.getApplianceID());
				} else {
					System.out.println("added unsucessfully");
				}
			}
			else if(input==2) {
				System.out.println("what is the monthly repair cost?");
				int monthlyRepairCost = Integer.parseInt(bufferedReader.readLine());
				appliance = new Dryer(modelName, brandName, price, quantity,monthlyRepairCost);
				if (shop.addAppliance(appliance)) {
					System.out.println("added sucessfully");
					System.out.println("the appliance id is:" + appliance.getApplianceID());
				} else {
					System.out.println("added unsucessfully");
				}
			}
			else if(input==3) {
				System.out.println("what is the capcity of the refridgerator?");
				int capacity = Integer.parseInt(bufferedReader.readLine());
				appliance = new Refrigerator(modelName, brandName, price, quantity,capacity);
				if (shop.addAppliance(appliance)) {
					System.out.println("added sucessfully");
					System.out.println("the appliance id is:" + appliance.getApplianceID());
				} else {
					System.out.println("added unsucessfully");
				}
			
			}
			else if(input==4) {
				System.out.println("what is the heat output?");
				int heatOutPut = Integer.parseInt(bufferedReader.readLine());
				appliance = new Furnace(modelName, brandName, price, quantity,heatOutPut);
				if (shop.addAppliance(appliance)) {
					System.out.println("added sucessfully");
					System.out.println("the appliance id is:" + appliance.getApplianceID());
				} else {
					System.out.println("added unsucessfully");
				}
			}
			else {
				System.out.print("you did not type a number between 1 and 4");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
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
				System.out.println("Quantity exceeds inventory. Try creating a backorder ");
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
