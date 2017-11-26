
import java.sql.SQLException;
import java.sql.Statement;

public class InsertingData extends ConnectDatabase {

	public InsertingData() {
		insertData();
	}
	
	private void insertData() {
		
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sqlQuery());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Data has been inserted into the table");
		
	}
	
	private String sqlQuery() {
		String sql = "INSERT INTO students (first_name, last_name, major) " +
				    " VALUES ('Fabio', 'Quintanilha', 'Computer Engineering')," +
			        		   " ('Lauren', 'Burton', 'Information Security')," +
					       " ('Tod', 'Macfly', 'Biology');";
		return sql;
	}
	
}
