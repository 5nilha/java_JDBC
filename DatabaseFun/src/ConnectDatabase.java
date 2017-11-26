import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

	private String url = "jdbc:mysql://localhost:3306/javaclass?autoReconnect=true&useSSL=false";
	private String user = "root";
	private String password = "student";
	protected Connection conn;
	
	public ConnectDatabase() {
		connectingDB();
	}
	
	private void connectingDB() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection with database has been established");
	}
	
}
