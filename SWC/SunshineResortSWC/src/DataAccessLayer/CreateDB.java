package DataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CreateDB {
	public static void main(String[] args) throws SQLException
	{
		Connection conn = DBConnect.getConn();
		PreparedStatement prepareStatement;
					
		prepareStatement = conn.prepareStatement("CREATE DATABASE sunshine_resort");
		prepareStatement.execute();

	}

}
