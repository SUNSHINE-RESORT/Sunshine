package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ApplicationLayer.CottageType;

public class MakeCottageType {

	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet result = null;
	private List<CottageType> cottageTypeList = new ArrayList<CottageType>();

	public List<CottageType> selectAllCottageTypes() {
		try {
			this.conn = DBConnect.getConn(); // Calling a static method to solve

			// the open/close issue of the
			// db
			preparedStatement = conn
					.prepareStatement("select * from cottage_type");

			result = preparedStatement.executeQuery();

			while (result.next()) {
				int noOfBed = result.getInt("noOfBed");
				String typeOfCottage = result.getString("typeOfCottage");
				double cottagePrice = result.getDouble("cottagePrice");
				cottageTypeList.add(new CottageType(noOfBed, typeOfCottage,
						cottagePrice));
			}
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			DBConnect.connClose();
			System.out.println("Closed Connection");
		}
		
		
		
		return cottageTypeList;
	}

	public CottageType selectByTypeOfCottage(String typeOfCottage) {
		CottageType cottageType = null;
		try {
			this.conn = DBConnect.getConn();
			preparedStatement = conn
					.prepareStatement("select * from cottage_type where typeOfCottage = ? ");
			preparedStatement.setString(1, typeOfCottage);
			result = preparedStatement.executeQuery();

			if (result.next()) {
				int noOfBed = result.getInt("noOfBed");
				typeOfCottage = result.getString("typeOfCottage");
				double cottagePrice = result.getDouble("cottagePrice");
				cottageType = new CottageType(noOfBed, typeOfCottage,
						cottagePrice);
			}
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			DBConnect.connClose();
			System.out.println("Closed Connection");
		}
		return cottageType;
	}
	
	public void insertCottageType(CottageType cottageType) {
		try {
			this.conn = DBConnect.getConn(); // Calling a static method to solve
			// the open/close issue of the
			// db

			preparedStatement = conn
					.prepareStatement("insert into cottage_type VALUES(?,?,?)");
			preparedStatement.setInt(1, cottageType.getNoOfBed());
			preparedStatement.setString(2, cottageType.getTypeOfCottage());
			preparedStatement.setDouble(3, cottageType.getCottagePrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e);
		}

		finally {
			DBConnect.connClose();
			System.out.println("Closed Connection");
		}

	}
	public void displayCottageTypes() {
		for (CottageType cottageType : cottageTypeList) {
			System.out.println(cottageType);
		}
	}
	
}
