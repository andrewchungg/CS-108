/**
 *  Program 3a
 *  Base class with objects of Financials class
 *  CS108-1
 *  6/6/2021
 *  @author Andrew Chung
  */

public class Stock {
	
	private String ticker;			// ticker or symbol of the stock
	private String name;			// name of listed public company
	private int numShares;			// total quantity of shares owned
	private double currValue;			// current value of the stock
	private double totValue; 			// total value of the stocks owned (totValue = currValue*numShares)
	private Financials quarFinancials;			// finances for the last quarter
	private Financials annFinancials;			// finances for the last annual year
	
	public Stock(String ticker, String name, int numShares, double currValue) {
		this.ticker = ticker;
		this.name = name;
		this.numShares = numShares;
		this.currValue = currValue;
		totValue = numShares * currValue;
	}
	
	public String getStockInfo() {
		return name + " (" + ticker + "); Total Shares Owned: " + numShares + "; Total Value: " + totValue;
	}
	
	public void buyShares(int shares) {
		numShares = numShares + shares;
		totValue = numShares * currValue;		// Recalculating total value
	}
	
	public void sellShares(int shares) {
		numShares = numShares - shares;
		totValue = numShares * currValue;		// Recalculating total value
	}
	
	
	/**
	 * Sets either quarFinancials or annFinancials to the Financials object passed as the parameter
	 * @param financial
	 * @param option
	 */
	public void setFinancials(Financials financial, String option) {
		if (option.equals("quarter")) {
			quarFinancials = financial;
		}
		if (option.equals("annual")) {
			annFinancials = financial;
		}
	}
	
	/**
	 * Returns out the financials of a company using the toString() method depending on the option "quarter" or "annual"
	 * @param option
	 * @return Financials string
	 */
	public String getFinancials(String option){
		String returnString = "";
		if (option.equals("quarter")) {
			returnString = quarFinancials.toString();
		}
		else if (option.equals("annual")) {
			returnString = annFinancials.toString();
		}
		return returnString;
	}
	
	public String getInfo() {
		return "Program 3a, Andrew Chung";
	}
}
