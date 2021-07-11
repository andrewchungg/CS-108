/**
 *  Program 3a
 *  Financials class with private variables, constructors, and methods relating to the financials of a Stock
 *  CS108-1
 *  6/6/2021
 *  @author Andrew Chung
  */

public class Financials {
	
	private double PE;			// Price to earnings ratio
	private double EPS;			// Earnings per share
	private boolean hasDiv;		// Indicates whether a company has dividends or not
	
	public Financials() {
		PE = 0.0;
		EPS = 0;
		hasDiv = false;
	}
	
	public Financials(double PE, double EPS, boolean hasDiv) {
		this.PE = PE;
		this.EPS = EPS;
		this.hasDiv = hasDiv;
	}
	
	public double getPE(){
		return PE;
	}
	
	public void setPE(double PE){
		this.PE = PE;
	}
	
	public double getEPS(){
		return EPS;
	}
	
	public void setEPS(double EPS){
		this.EPS = EPS;
	}
	
	public boolean hasDividends(){
		return hasDiv;
	}
	
	@Override
	public String toString(){
		return "Price/Earnings: " + PE + "; Earnings/Share: " + EPS + "; Dividends: " + hasDiv;
	}
}
