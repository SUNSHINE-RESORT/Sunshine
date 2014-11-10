package ApplicationLayer;


public class Company extends Customer{
	private String companyName;
	private String contactPerson;
	
	public Company(String companyName, String contactPerson) {
		this.companyName = companyName;
		this.contactPerson = contactPerson;
	}

	public Company() {
	}

	public Company(int customerNo, String email, String phone,
			String customerAddress, String customerType,String companyName, String contactPerson) {
		super(customerNo, email, phone, customerAddress, customerType);
		this.companyName = companyName;
		this.contactPerson = contactPerson;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", contactPerson="
				+ contactPerson + "]";
	}
	
	
}