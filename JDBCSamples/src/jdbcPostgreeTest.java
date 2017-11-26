import java.sql.*;

// Should install the driver at Properties -> Java build Path - > library -> add JAR
// the jar file should be pasted in a folder inside the project to be used in the library
public class jdbcPostgreeTest {

	public static void main(String[] args) {
		
	
		Connection myConn;
		try {
			myConn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/MoviesFavorites", "postgres","admin");
			
			Statement statement = myConn.createStatement();	
			
			ResultSet myRs = statement.executeQuery("select * from filmfavorites");
			
			while(myRs.next()) {
				System.out.println(myRs.getString("movietitle"));
			}
			
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		
	}

}
