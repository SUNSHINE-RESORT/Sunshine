package DataAccessLayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnect {

	private static Connection conn = null;

	public static Connection getConn() throws SQLException
	{
		setConn();
		return conn;
	}

	private static void setConn() throws SQLException
	{
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost/sunshine_resort?user=root&password=2602");		

	}

	public static void connClose()
	{
		if (conn != null)
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				System.err.println(e);
			}
		}
	}

}
