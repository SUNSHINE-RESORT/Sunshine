package DataAccessLayer;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ApplicationLayer.Cottage;
import ApplicationLayer.CottageType;

public class CottageAdmin {
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet result = null;
	private List<Cottage> cottageList = new ArrayList<Cottage>();
	private List<CottageType> cottageTypeList = new ArrayList<CottageType>();

	public CottageAdmin() {
		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/sunshine_resort?user=root&password=2602");
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	public List<CottageType> readCottageType(String cottageType) {
		try {
			preparedStatement = conn
					.prepareStatement("select * from cottage_type where typeOfCottage = ? ");
			preparedStatement.setString(1, cottageType);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				int noOfBed = result.getInt("noOfBed");
				String typeOfCottage = result.getString("typeOfCottage");
				double cottagePrice = result.getDouble("cottagePrice");
				cottageTypeList.add(new CottageType(noOfBed,typeOfCottage,cottagePrice));
			}
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			DBConnect.connClose();
			System.out.println("Closed Connection");
		}
		return cottageTypeList;
	}

	public List<Cottage> readCottage(int cottageNo) {
		try {
			preparedStatement = conn
					.prepareStatement("select * from cottage_type natural join cottage where cottage.cottageNo = ?");
			preparedStatement.setInt(1, cottageNo);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				CottageType cottageType = new CottageType();
				cottageType.setNoOfBed(result.getInt("noOfBed"));
				cottageType.setTypeOfCottage(result.getString("typeOfCottage"));
				cottageType.setCottagePrice(result.getDouble("cottagePrice"));
				Cottage cottage = new Cottage();
				cottage.setCottageType(cottageType);
				cottage.setCottageNo(result.getInt("cottageNo"));
				cottageList.add(cottage);
			}
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			DBConnect.connClose();
			System.out.println("Closed Connection");
		}

		return cottageList;
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
}
