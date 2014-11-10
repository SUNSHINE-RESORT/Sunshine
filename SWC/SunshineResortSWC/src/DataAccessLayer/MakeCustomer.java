package DataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ApplicationLayer.Company;
import ApplicationLayer.Tourist;

public class MakeCustomer {
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet result = null;
	private List<Tourist> touristList = new ArrayList<Tourist>();
	private List<Company> companyList = new ArrayList<Company>();
	
	public List<Tourist> selectAllTourist() {
		try {
			this.conn = DBConnect.getConn(); // Calling a static method to solve

			// the open/close issue of the
			// db
			preparedStatement = conn
					.prepareStatement("select *  from tourist join customer");
			result = preparedStatement.executeQuery();

			while (result.next()) {
				
				int customerNo = result.getInt("customerNo");
				String email = result.getString("email");
				String phone = result.getString("phone");
				String customerAddress = result.getString("customerAddress");
				String customerType = result.getString("customerType");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				touristList.add(new Tourist(customerNo,email,phone,customerAddress,customerType,firstName,lastName));
			}

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			DBConnect.connClose();
			System.out.println("Closed Connection");
		}
		return touristList;

	}
	
	public List<Company> readCompany() {
		try {
			this.conn = DBConnect.getConn(); // Calling a static method to solve

			// the open/close issue of the
			// db
			preparedStatement = conn
					.prepareStatement("select * from company join customer");
			result = preparedStatement.executeQuery();

			while (result.next()) {
				int customerNo = result.getInt("customerNo");
				String email = result.getString("email");
				String phone = result.getString("phone");
				String customerAddress = result.getString("customerAddress");
				String customerType = result.getString("customerType");
				String companyName = result.getString("companyName");
				String contactPerson = result.getString("contactPerson");
				companyList.add(new Company(customerNo,email,phone,customerAddress,customerType,companyName,contactPerson));
			}

		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			DBConnect.connClose();
			System.out.println("Closed Connection");
		}
		return companyList;

	}
	
	public void displayTourists(){
		for(Tourist tourist : touristList){
			System.out.println(tourist);
		}
	}
	
	public void diplayCompany(){
		for(Company company : companyList){
			System.out.println(company);
		}
	}
}
