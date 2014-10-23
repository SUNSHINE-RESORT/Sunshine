package ApplicationLayer;

public class CottageType {
	private int noOfBed;
	private String typeOfCottage;
	private double cottagePrice;
	
	public CottageType() {
	}
	
	public CottageType(int noOfBed, String typeOfCottage, double cottagePrice) {
		this.noOfBed = noOfBed;
		this.typeOfCottage = typeOfCottage;
		this.cottagePrice = cottagePrice;
	}



	public String getTypeOfCottage() {
		return typeOfCottage;
	}

	public void setTypeOfCottage(String typeOfCottage) {
		this.typeOfCottage = typeOfCottage;
	}

	public int getNoOfBed() {
		return noOfBed;
	}

	public void setNoOfBed(int noOfBed) {
		this.noOfBed = noOfBed;
	}

	public double getCottagePrice() {
		return cottagePrice;
	}

	public void setCottagePrice(double cottagePrice) {
		this.cottagePrice = cottagePrice;
	}

	@Override
	public String toString() {
		return "CottageType [typeOfCottage=" + typeOfCottage + ", noOfBed="
				+ noOfBed + ", cottagePrice=" + cottagePrice + "]";
	}
	
}