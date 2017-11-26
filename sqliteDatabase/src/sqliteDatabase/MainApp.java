package sqliteDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainApp {

	public static final String DB_NAME = "testjava.db";
	public static final String CONNECTION_MACOS_DB = "jdbc:sqlite:../sqliteDatabase/" + DB_NAME;
	public static final String CONNECTION_WINDOWSOS_DB = "jdbc:sqlite:..\\sqliteDatabase\\" + DB_NAME;
	
	public static final String TABLE_CONTACTS = "contacts";
	
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_PHONE = "phone";
	public static final String COLUMN_EMAIL = "email";
	
	public static void main(String[] args) {
	
		try {
			Connection conn = DriverManager.getConnection(CONNECTION_MACOS_DB); 
			Statement statement = conn.createStatement();
			
//			conn.setAutoCommit(false);
			
			statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
			statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
							"(" + COLUMN_NAME + " TEXT," +
							      COLUMN_PHONE + " INTEGER," +
							      COLUMN_EMAIL + " TEXT);");
			
			statement.execute("UPDATE " + TABLE_CONTACTS +
							  " SET " + COLUMN_PHONE + "= 3682121111" +
							  " WHERE " + COLUMN_NAME + "= 'Jane';");
			
			statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE " + COLUMN_NAME + "= 'Joe';");
			
			insertContact(statement, "Fabio", "(407)856-1221", "fabio@email.com");
			insertContact(statement, "Joe", "(407)446-1787", "joe@email.com");
			insertContact(statement, "Jane", "(368)212-1111", "jane@email.com");
			insertContact(statement, "Fido", "(888)754-3443 ", "fido@email.com");

							  
//			statement.execute("INSERT INTO contacts (name, phone, email)" +
//							  "VALUES ('Joe', 4074461787, 'joe@email.com')," + 
//									 "('Jane', 2768810901, 'jane@email.com')," +
//									 "('Fido', 9743215498, 'fido@email.com')");
			
//			statement.executeQuery("UPDATE contacts SET phone = 5688990000 WHERE name='Jane'");
			
//			statement.executeQuery("DELETE FROM contacts WHERE name='Jane'");
			
//			statement.execute("SELECT * FROM contacts;");
//			ResultSet result = statement.getResultSet();
			
			ResultSet result = statement.executeQuery("SELECT * FROM "+ TABLE_CONTACTS + ";");
					
			while (result.next()) {
				System.out.println(result.getString(COLUMN_NAME) + "   |   " + 
								   result.getString(COLUMN_PHONE) +  "   |   " + 
								   result.getString(COLUMN_EMAIL) );
			}
			
			result.close();
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	private static void insertContact(Statement statement, String name, String phone, String email) throws SQLException{
		statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" + COLUMN_NAME + ", " + 
																 COLUMN_PHONE + ", " + 
																 	COLUMN_EMAIL + ") " +
						 "VALUES ('" + name + "', '" + phone + "', '" + email + "');");
	}
	
}
