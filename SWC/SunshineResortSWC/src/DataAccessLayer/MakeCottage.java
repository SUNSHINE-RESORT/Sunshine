package DataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ApplicationLayer.Cottage;
import ApplicationLayer.CottageType;

public class MakeCottage {
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet result = null;
	private List<Cottage> cottageList = new ArrayList<Cottage>();
	private ArrayList<CottageType> cottageTypeList = new ArrayList<CottageType>();
	
	public List<Cottage> selectAllCottages() {
		try {
			this.conn = DBConnect.getConn(); // Calling a static method to solve
			preparedStatement = conn
					.prepareStatement("select * from cottage_type natural join cottage");
			result = preparedStatement.executeQuery();

			while (result.next()) {
				int cottageNo = result.getInt("cottageNo");
				int noOfBed = result.getInt("noOfBed");
				String typeOfCottage = result.getString("typeOfCottage");
				double cottagePrice = result.getDouble("cottagePrice");
				cottageList.add(new Cottage(cottageNo, new CottageType(noOfBed,typeOfCottage,cottagePrice)));
				
			}
			
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			DBConnect.connClose();
			System.out.println("Closed Connection");
		}

		return cottageList;
	}
	
	public Cottage selectByCottageNo(int cottageNo) {
		Cottage cottage = new Cottage();
		try {
			preparedStatement = conn
					.prepareStatement("select * from cottage_type natural join cottage where cottage.cottageNo = ?");
			preparedStatement.setInt(1, cottageNo);
			result = preparedStatement.executeQuery();

			if (result.next()) {
				cottageNo = result.getInt("cottageNo");
				int noOfBed = result.getInt("noOfBed");
				String typeOfCottage = result.getString("typeOfCottage");
				double cottagePrice = result.getDouble("cottagePrice");
				cottage = new Cottage(cottageNo, new CottageType(noOfBed,typeOfCottage,cottagePrice));
				}
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			DBConnect.connClose();
			System.out.println("Closed Connection");
		}

		return cottage;
	}
	
	public void insertCottage(Cottage cottage){
		CottageType cottageType = cottage.getCottageType();
		try{
			this.conn = DBConnect.getConn();
			preparedStatement = conn.prepareStatement("insert into cottage VALUES(default,?,?)");
			//preparedStatement.setInt(1, cottage.getCottageNo());
			preparedStatement.setInt(1, cottageType.getNoOfBed());
			preparedStatement.setString(2, cottageType.getTypeOfCottage());
			preparedStatement.executeUpdate();
		}catch (SQLException e){
			System.out.println(e);
		}
		finally{
			DBConnect.connClose();
			System.out.println("Closed Connection");
		}
	}
	public void displayCottages() {
		for (Cottage cottage : cottageList) {
			System.out.println(cottage);
		}
	}
	public ArrayList<CottageType> getCottageTypeList() {
		return cottageTypeList;
	}
}
