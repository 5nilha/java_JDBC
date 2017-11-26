package jdbcMysqlDemo;
import java.sql.*;

public class InsertDataTets {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "student";
		
		try {
			//Connecting to the database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			//Creating a Statement 
			Statement statement = myConn.createStatement();
			
			//Execute SQL query
			String sql = "INSERT INTO employees (idemployees, last_name, first_name, email) " 
						+ "VALUES (6, 'Brown', 'David', 'david.brown@foo.com'), "
						+ "(7, 'Bale', 'Christian', 'chris.bale@dog.com')";
			
			statement.executeUpdate(sql);
			
			System.out.println("Insert complete");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
