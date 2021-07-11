import java.util.ArrayList;

public class Retail implements StockAccount {

	public int ID;
	public String name;
	public String category;
	public ArrayList<Stock> stocksOwned;
	
	public Retail(){
		ID = StockApp.totalAccounts;
		StockApp.totalAccounts++;
		name = "Retail" + ID;
		category = "Retail";
		stocksOwned = new ArrayList<Stock>();
	}
	
	public Retail(String name){
		ID = StockApp.totalAccounts;
		StockApp.totalAccounts++;
		this.name = name;
		category = "Retail";
		stocksOwned = new ArrayList<Stock>();
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setCategory() {
		category = "Retail";
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public ArrayList<Stock> getStocksOwned() {
		return stocksOwned;
	}

	@Override
	public boolean addStock(Stock s) {
		if (stocksOwned.size() > 10 || stocksOwned.contains(s)) {
			return false;						// If total Stocks is more than 10 or Stock already exists, return false
		}
		else {
			stocksOwned.add(s);
			return true;						// Adds given Stock to the ArrayList and returns true
		}
	}

	@Override
	public boolean removeStock(Stock s) {
		boolean flag = false;
		if (s.numShares == 0) {
			stocksOwned.remove(s);
			flag = true;						// Removes the given Stock only if the numShares are 0, returns true 
		}
		else if (!stocksOwned.contains(s) || s.numShares >0 ) {
			flag = false;						// return false if numShares >0 or Stock does not exist
		}
		return flag;
	}
}
