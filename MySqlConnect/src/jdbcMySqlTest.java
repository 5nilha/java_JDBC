import java.sql.*;
public class jdbcMySqlTest {

	public static void main(String[] args) {
		
		try {
			//1. Get a connection to database 
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "root", "student");
			
			//2. Create a statement 
			Statement myStmt = myConn.createStatement();
			
			//3. Execute SQL query 
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM employees");
			
			//4. Process the result set 
			while (myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}