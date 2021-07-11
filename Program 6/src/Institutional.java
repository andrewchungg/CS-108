import java.util.ArrayList;

public class Institutional implements StockAccount {

	public int ID;
	public String manager;
	public String name;		// name of institution
	public String category;
	public ArrayList<Stock> stocksOwned;
	
	public Institutional(){
		ID = StockApp.totalAccounts;
		StockApp.totalAccounts++;
		manager = "Manager" + ID;
		name = "Institutional" + ID;
		category = "Institutional";
		stocksOwned = new ArrayList<Stock>();
	}
	
	public Institutional(String manager, String name){
		ID = StockApp.totalAccounts;
		StockApp.totalAccounts++;
		this.manager = manager;
		this.name = name;
		category = "Institutional";
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
		category = "Institutional";
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
		if(stocksOwned.contains(s)) {	
			return false;						// return false if Stock already exists
		}
		else {
			stocksOwned.add(s);
			return true;						// add the Stock to the ArrayList stocksOwned and returns true
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
