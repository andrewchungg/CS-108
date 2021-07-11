/**
 * Financial
 * Created for CS-108 Summer 2020
 * @author Manan Katwala
 * @date 14 June 2020
 */
public class Financials {
	double PE;
	double EPS;
	boolean hasDiv;
	
	public Financials() {
		PE = 0.0;
		EPS = 0.0;
		hasDiv = false;
	}
	
	public Financials(double PE, double EPS, boolean hasDiv) {
		this.PE = PE;
		this.EPS = EPS;
		this.hasDiv = hasDiv;
	}

	public double getPE() {
		return PE;
	}

	public void setPE(double pE) {
		PE = pE;
	}

	public double getEPS() {
		return EPS;
	}

	public void setEPS(double ePS) {
		EPS = ePS;
	}

	public boolean hasDividends() {
		return this.hasDiv;
	}
	
	@Override
	public String toString() {
		return "Price/Earnings: " + PE + "; Earnings/Share: "  + EPS + "; Dividends: " + hasDiv;
	}
	
	
}
