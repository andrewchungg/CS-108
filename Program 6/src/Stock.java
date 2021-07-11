/**
 * Stock for Stock Broker App
 * Created for CS-108 Summer 2020
 * @author Manan Katwala
 * @date 14 June 2020
 */
 
public class Stock {
	
	String name;
	String ticker;
	int numShares;
	double currValue;
	double totValue;
	Financials quarFinancials;
	Financials annFinancials;
	
	
	public Stock(String ticker, String name,int numShares, double currValue) {
		this.name = name;
		this.ticker = ticker;
		this.numShares = numShares;
		this.currValue = currValue;
		this.totValue = numShares * currValue;
	}
	
	public void buyShares(int shares) {
		numShares += shares;
		totValue = numShares * currValue;
	}
	
	public void sellShares(int shares) { 
		if(shares <= numShares) 
			numShares -= shares;
		totValue = numShares * currValue;
	}
	
	public void setFinancials(Financials financial, String option) {
		if(option.equals("quarter"))
			quarFinancials = financial;
		else if(option.equals("annual"))
			annFinancials = financial;
		else 
			System.out.println("Error: Wrong Option");
	}
	
	public String getFinancials(String option) {
		if(option.equals("quarter"))
		   return quarFinancials.toString();
		else if(option.equals("annual"))
			return annFinancials.toString();
		else 
			return "Error: Wrong Option";
	}
	
	public String getInfo() {
		return "Program 3a, Andrew Chung";
	}
	
	public String getStockInfo() {
		return name + " (" + ticker + "); Total Shares Owned: " + numShares + "; Total Value: " +  totValue;
	}
	
	public int getShares() {
		return numShares;
	}
	
	public String getTicker() {
		return ticker;
	}
}
