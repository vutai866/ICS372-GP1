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
				shop.addOrder(quantity, customer, appliance);
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
