package jdbcMysqlDemo;
import java.sql.*;


public class DeleteDataTest {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "student";
		
		try {
			
			//Connect to the data base
			Connection myConnection = DriverManager.getConnection(url, user, password);
			
			//Create statement
			Statement statement = myConnection.createStatement();
			
			// Execute sql query
			String sql = "DELETE FROM employees WHERE last_name='Brown'";
			statement.executeUpdate(sql);
			
			System.out.println("Delete Complete");
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
