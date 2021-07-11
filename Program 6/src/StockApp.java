/**
 *  Program 6
 *  
 *  CS108-1
 *  6/17/2021
 *  @author Andrew Chung
  */

import java.util.ArrayList;
import java.util.Scanner;

public class StockApp {
	
	public static int totalAccounts = 0;
	public static ArrayList<StockAccount> accounts = new ArrayList<StockAccount>();
	
	public static void printMenu() {
		System.out.println("1. Create a new account.");
		System.out.println("2. Remove an existing account.");
		System.out.println("3. Add a new stock to an existing account.");
		System.out.println("4. Remove an existing stock from an account.");
		System.out.println("5. Update number of shares in a stock for an account");
		System.out.println("0. Exit");
	}
	
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		int in;
		int ID;
		String institutionName;
		String managerName;
		String retailName;
		
		System.out.println("Welcome to Stock Broker App!");
		
		do {
			printMenu();
			in = scnr.nextInt();
			
			if (in == 1) {
				System.out.println("Select the account type:");
				System.out.println("1. Institutional");
				System.out.println("2. Retail");
				in = scnr.nextInt();
				
				if (in == 1) {
					System.out.println("Enter the institution's name:");
					institutionName = scnr.next();
					System.out.println("Enter the manager's name:");
					managerName = scnr.next();
					//ID = totalAccounts;
					accounts.add(new Institutional(managerName, institutionName));
				}
				
				else if (in == 2) {
					System.out.println("Enter your name:");
					retailName = scnr.next();
					//ID = totalAccounts;
					accounts.add(new Retail(retailName));
				}
				
				else {
					System.out.println("Invalid. Returning to main menu.");
				}
				
			}
			
			else if (in == 2) {
				System.out.println("Enter your account ID:");
				ID = scnr.nextInt();
				
				StockAccount temp = null;
				
				for (StockAccount s: accounts) {
					if (s.getID() == ID) {
						temp = s;
					}
				}
				if (temp != null) {
					accounts.remove(temp);				// remove the account if it exists in the ArrayList
				}	
				
			}
			
			else if (in == 3) {
				System.out.println("Enter your account ID:");
				ID = scnr.nextInt();
				
				StockAccount temp = null;
				
				for (StockAccount s: accounts) {
					if (s.getID() == ID) {
						temp = s;
					}
				}
				
				if (temp != null) {										// if account ID exists
					System.out.println("Enter the name:");
					String name = scnr.next();
					System.out.println("Enter the ticker:");
					String ticker = scnr.next();
					System.out.println("Enter number of shares:");
					int numShares = scnr.nextInt();
					System.out.println("Enter current value:");
					double currValue = scnr.nextDouble();
					
					Stock s = new Stock(ticker, name, numShares, currValue);
					
					if (temp.addStock(s)) {
						temp.addStock(s);
						System.out.println("Stock added successfully.");
					}
					else {
						System.out.print("Stock already exists");
					}
				}
				
				else {
					System.out.println("No account with given ID exists");
				}
			}
			
			else if (in == 4) {
				System.out.println("Enter your account ID:");
				ID = scnr.nextInt();
				
				StockAccount temp = null;
				
				for (StockAccount s: accounts) {
					if (s.getID() == ID) {
						temp = s;
					}
				}
				
				if (temp == null) {
					System.out.println("No account with given ID exists");
				}
				
				else {
					System.out.println("Enter the ticker:");
					String ticker = scnr.next();
					boolean flag = false;
					
					for (Stock s : temp.getStocksOwned()) {
						if (s.getTicker().equals(ticker)) {
							flag = true;
							temp.removeStock(s);
						}
					}
					
					if (flag != true) {
						System.out.println("Ticker does not exist");
					}
		
				}
			}
			
			else if (in == 5) {
				System.out.println("Enter your account ID:");
				
				ID = scnr.nextInt();
				
				StockAccount temp = null;
				
				for (StockAccount s: accounts) {
					if (s.getID() == ID) {
						temp = s;
					}
				}
				
				if (temp == null) {
					System.out.println("No account with given ID exists");
				}
				
				else {
					System.out.println("Enter the ticker:");
					String ticker = scnr.next();
					boolean flag = false;
					Stock theStock = null;
					
					for (Stock s : temp.getStocksOwned()) {
						if (s.getTicker().equals(ticker)) {
							flag = true;
							theStock = s;
						}
					}
					
					if (flag != true) {
						System.out.println("Ticker does not exist");
					}
					
					else {
						System.out.println("Enter the following:");
						System.out.println("1. Buy shares");
						System.out.println("2. Sell shares");
						in = scnr.nextInt();
						
						if (in == 1) {
							System.out.println("Enter number of shares to buy:");
							in = scnr.nextInt();
							theStock.buyShares(in);
						}
						
						else if (in == 2) {
							System.out.println("Enter number of shares to sell:");
							in = scnr.nextInt();
							theStock.sellShares(in);
						}
					}
				}
			}
			
			else if (in == 0) {
				System.out.println("Thanks for using Stock App. Exiting!");
				break;
			}
			else {
				System.out.println("Invalid option entered.");
			}
			
		} while (in != 0);
		
		scnr.close();
	}
}