import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveData extends ConnectDatabase {
	
	public RetrieveData() {
		getData();
	}

	private void getData() {
		try {
			//Prepare the SQL statement
			PreparedStatement myStatement = conn.prepareStatement(sqlQuery());
			
			//Execute the Query and display the result
			ResultSet result = myStatement.executeQuery();
			DisplayData(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private String sqlQuery() {
		String sql = "SELECT * FROM students";
		return sql;
	}
	
	private void DisplayData(ResultSet result) throws SQLException {
		while (result.next()) {
			System.out.println(result.getInt("student_id") + "    " + result.getString("first_name") + "    " + result.getString("last_name") + "    " + result.getString("major"));
		}
	}	
}
