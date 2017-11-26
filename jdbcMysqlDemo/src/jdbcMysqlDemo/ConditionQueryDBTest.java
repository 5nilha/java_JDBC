package jdbcMysqlDemo;
import java.sql.*;

public class ConditionQueryDBTest {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/company_demo?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "student";
		
		try {
			
			//Connecting Database
			Connection myConnection= DriverManager.getConnection(url, user, password);
			
			//Query with salary > 80000 AND department= legal
			//Prepare a SQL statement  / PraparedStatement can be reused
			String sql = "SELECT * FROM employees "
						+ "WHERE salary > ? and department=?";
			PreparedStatement sqlStatement = myConnection.prepareStatement(sql);
			
			//Set the parameters
			sqlStatement.setDouble(1,  80000);
			sqlStatement.setString(2,  "Legal");	
			
			// Execute SQL Query
			ResultSet myRs = sqlStatement.executeQuery();
			
			// Display the result set 
			display(myRs);
			
			
			
			//Reusing the preparedStatement to another query with salary > 25000, department = HR
			System.out.println("Query database for salary > 25000, department = HR");
			sqlStatement.setDouble(1,  25000);
			sqlStatement.setString(2, "HR");
			
			//Execute query
			myRs = sqlStatement.executeQuery();
			
			//Display the result
			display(myRs);
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			System.out.println(myRs.getString("first_name") + " " + myRs.getString("last_name") + ", " + myRs.getString("salary") + ", " + myRs.getString("department") );
		}
		System.out.println("");
	}

}
