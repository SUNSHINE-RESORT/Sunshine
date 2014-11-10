package ApplicationLayer;

public class Customer {
	
	private int customerNo;
	private String email;
	private String phone;
	private String customerAddress;
	private String customerType;
	
	public Customer(){}
	public Customer(int customerNo, String email, String phone,
			String customerAddress, String customerType) {
		super();
		this.customerNo = customerNo;
		this.email = email;
		this.phone = phone;
		this.customerAddress = customerAddress;
		this.customerType = customerType;
	}
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	@Override
	public String toString() {
		return "Customer [customerNo=" + customerNo + ", email=" + email
				+ ", phone=" + phone + ", customerAddress=" + customerAddress
				+ ", customerType=" + customerType + "]";
	}
	
	
}
