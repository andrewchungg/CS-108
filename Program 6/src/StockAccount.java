import java.util.ArrayList;

public interface StockAccount {
	
	void setName(String name);
	
	String getName();
	
	void setCategory();
	
	String getCategory();
	
	int getID();
	
	ArrayList<Stock> getStocksOwned();
	
	boolean addStock(Stock s);
	
	boolean removeStock(Stock s);
}
