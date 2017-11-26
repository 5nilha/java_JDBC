import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable extends ConnectDatabase {
	
	public CreateTable() {
		createDBTable();
	}
	
	//This method creates a Table into the database
	private void createDBTable() {
		try {
			// Creating a statement to create a table
			String sqlCreateTable = "CREATE TABLE IF NOT EXISTS students (\n"
					+ " student_id integer PRIMARY KEY UNIQUE AUTO_INCREMENT,\n" 
					+ " first_name VARCHAR(20),\n"
					+ " last_name VARCHAR(20),\n" 
					+ " major VARCHAR(30)\n" + ")";

			Statement statement = conn.createStatement();
			statement.execute(sqlCreateTable);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Table has been created with success");
		
	}

}
