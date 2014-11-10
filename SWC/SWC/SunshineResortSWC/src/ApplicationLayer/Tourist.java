package ApplicationLayer;


public class Tourist extends Customer{
	private String firstName;
	private String lastName;
	
	public Tourist() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	public Tourist(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Tourist(int customerNo, String email, String phone,
			String customerAddress, String customerType,String firstName, String lastName) {
		super(customerNo, email, phone, customerAddress, customerType);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Tourist [firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
	
	
	
}
