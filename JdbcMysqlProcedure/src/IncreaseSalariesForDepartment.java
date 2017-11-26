import java.sql.*;

import com.mysql.jdbc.Statement;

public class IncreaseSalariesForDepartment {

	public static void main(String[] args) {
		Connection myConn = null;
		CallableStatement myStatement = null;
		String url = "jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "student";

		try {

			// Connecting to Dtabase
			myConn = DriverManager.getConnection(url, user, password);

			String theDepartment = "Engineering";
			int theIncreaseAmount = 10000;

			// Shows salaries BEFORE
			System.out.println("salaries BEFORE\n");
			showSalaries(myConn, theDepartment);

			// prepare the store procedure call
			myStatement = myConn.prepareCall("{call increase_salaries_for_department(?, ?)}");

			// Set the parameters
			myStatement.setString(1, theDepartment);
			myStatement.setDouble(2, theIncreaseAmount);

			// Call stored procedure
			System.out.println("\n\nCalling stored procedure. increased_salaries_for_department('" + theDepartment
					+ "', " + theIncreaseAmount + ")");
			myStatement.execute();
			System.out.println("Finished calling stored procedure");

			// Shows salaries AFTER
			System.out.println("\n\nSalaries AFTER\n");
			showSalaries(myConn, theDepartment);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				close(myConn, myStatement);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void showSalaries(Connection myConn, String theDepartment) throws Exception {

		PreparedStatement preparedstatement = null;
		ResultSet result = null;

		try {
			String sqlStatement = "SELECT * FROM employees WHERE department=?";

			// prepare Statement
			preparedstatement = myConn.prepareStatement(sqlStatement);

			preparedstatement.setString(1, theDepartment); // argument position, parameter

			// Execute SQL query
			result = preparedstatement.executeQuery();

			// Process the result set
			while (result.next()) {
				String last_name = result.getString("last_name");
				String first_name = result.getString("first_name");
				double salary = result.getDouble("salary");
				String department = result.getString("department");

				System.out.printf("%s, %s, %s, %.2f\n", last_name, first_name, department, salary);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(preparedstatement, result);
		}

	}

	private static void close(Connection myConn, CallableStatement statement) throws SQLException {

		if (statement != null) {
			statement.close();
		}
		if (myConn != null) {
			myConn.close();
		}

	}

	private static void close(PreparedStatement statement, ResultSet result) throws SQLException {
		if (result != null) {
			result.close();
		}

		if (statement != null) {
			statement.close();
		}
	}

	public static void close(Connection myConn, Statement statement, ResultSet result) throws SQLException {
		if (result != null) {
			result.close();
		}

		if (statement != null) {
			statement.close();
		}
		if (myConn != null) {
			myConn.close();
		}

	}

}
