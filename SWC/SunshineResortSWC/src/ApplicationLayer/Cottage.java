  package ApplicationLayer;



public class Cottage {
	private int cottageNo;
	private CottageType cottageType;
	
	public Cottage(){}
	public Cottage(int cottageNo, CottageType cottageType) {
		this.cottageNo = cottageNo;		
		this.cottageType = cottageType;
	}
	
	public int getCottageNo() {
		return cottageNo;
	}

	public void setCottageNo(int cottageNo) {
		this.cottageNo = cottageNo;
	}

	public CottageType getCottageType() {
		return cottageType;
	}

	public void setCottageType(CottageType cottageType) {
		this.cottageType = cottageType;
	}

	@Override
	public String toString() {
		return "Cottage [cottageNo=" + cottageNo + ", cottageType="
				+ cottageType + "]";
	}

		
	
}
