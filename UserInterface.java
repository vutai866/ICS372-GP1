import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;

public class UserInterface {
	BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));//Used to read input.
	ShopSystem shop;
	
	public static void main(String[] args) {
		System.out.println("hello world");
	}
	
	
	
	public void purchase() {
		try {
			System.out.println("Input desired Customer ID");
			int customerID = Integer.parseInt( bufferedReader.readLine());
			Customer customer = shop.searchCustomers(customerID);
			System.out.println("Input desired Appliance ID");
			int applianceID = Integer.parseInt( bufferedReader.readLine());
			Appliance appliance = shop.searchAppliances(applianceID);
			int quantity = Integer.parseInt(bufferedReader.readLine());
			if(quantity > appliance.getQuantity()) {
				System.out.println("Quantity exceeds inventory. Try creating a backorder ");
				return;
			}else {
				//This part relies on other things not yet finished.
			}
			
			
			
		}catch(Exception e) {
			System.out.println("invalid input");
			return;
		}
	}

}
