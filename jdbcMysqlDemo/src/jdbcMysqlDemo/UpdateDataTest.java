package jdbcMysqlDemo;
import java.sql.*;

public class UpdateDataTest {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "student";
		
		try {
			//Connecting database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			//Creating a statement
			Statement statement = myConn.createStatement();
			
			// Execute SQL query to Update an existing data
			
			String sql = "UPDATE employees "
						+ " set email='david@lottery.com'"
						+ " WHERE idemployees=6";
			
			statement.executeUpdate(sql);
			
			System.out.println("Update Complete");
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		

	}

}
