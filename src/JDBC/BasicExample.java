package JDBC;

import java.sql.*;

public class BasicExample {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test";

	//  Database credentials
	static final String USER = "mkkabi";
	static final String PASS = "pass";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			//STEP 2: Register JDBC driver - not necessary in version 4 driver
			/* using the Class.forName() method is compatible with both JDBC
3.0 and JDBC 4.0 drivers. It is simply not needed when the driver supports
4.0. 		*/
			//Class.forName("com.mysql.jdbc.Driver");
			
			//STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//STEP 4: Execute a query
			stmt = conn.createStatement();
			String selectStatement = "SELECT PersonID, LastName, FirstName, Address, City FROM Persons";
			String createTablePersons = "CREATE TABLE Persons (PersonID int, LastName varchar(255), "
					  + "FirstName varchar(255), Address varchar(255), City varchar(255));";
			String addDataPersons = "INSERT INTO Persons (PersonID, LastName, FirstName, Address, City) "
					  + "Values('1', 'Vasichkin', 'Anatole', 'gogolia street', 'Moscow')";
			// Create table Persons and add data
//			stmt.execute(createTable);
//			stmt.execute(addDataPersons);

			ResultSet rs = stmt.executeQuery(selectStatement);

			//STEP 5: Extract data from result set
			while (rs.next()) {
				//Retrieve by column name
				int id = rs.getInt("PersonID");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				String address = rs.getString("Address");
				String city = rs.getString("City");

				//Display values
				System.out.println("ID: " + id + ", Name: " + first + " " + last + ", Address: " + address + ", City: " + city);
				//Or we can use numbers to access database fields from resultSet
				System.out.println("ID: " + rs.getInt(1) + ", Name: " + rs.getString(2) + " " + rs.getString(3) + 
						  ", Address: " + rs.getString(4) + ", City: " + rs.getString(5));
			}

			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			//finally block used to close resources
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
	}//end main
}//end FirstExample
