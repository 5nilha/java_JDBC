import java.sql.*;

public class DemoDB {

	public static void main(String[] args) {
		
		try {
			System.out.println("Hello");
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/MoviesFavorites","postgres","admin");
			PreparedStatement statement = con.prepareStatement("SELECT * FROM filmfavorites;");
			ResultSet Rs = statement.executeQuery();
			
			while (Rs.next()) {
				System.out.printf("%-20s %s %d %10s %.2f", Rs.getString(2), "released in",  Rs.getInt(3), "Price", Rs.getDouble(6));
//				System.out.print(Rs.getString(2) + "      " +  "Released in " + Rs.getInt(3) + "      " + "Price: " + Rs.getDouble(6) );
				System.out.println("");
			}
		}
		catch (Exception ex ) {
			System.err.println(ex.getMessage());
		}
		
		
	}
	
}
