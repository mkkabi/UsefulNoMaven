package JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLITE_CreateDB {

	/**
	 * Connect to a sample database
	 *
	 * @param fileName the database file name
	 */
	public static void createNewDatabase(String fileName) {

		String url = "jdbc:sqlite:src/Resources/" + fileName;
		// if database file does not exist it will be created
		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				Statement st = conn.createStatement();
				String createTablePersons = "CREATE TABLE Persons (ID Integer PRIMARY KEY AUTOINCREMENT, LastName varchar(255), "
					  + "FirstName varchar(255), Address varchar(255), City varchar(255));";
				String addDataPersons = "INSERT INTO Persons (LastName, FirstName, Address, City) "
					  + "Values('Vasichkin', 'Anatole', 'gogolia street', 'Moscow')";
				String selectStatement = "SELECT ID, LastName, FirstName, Address, City FROM Persons";
				String selectStatement2 = "SELECT ID, LastName, FirstName, Address, City FROM Persons where ID=2";
		//		st.execute(createTablePersons);
		//		st.execute(addDataPersons);

			ResultSet rs = st.executeQuery(selectStatement2);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt(1) + ", Name: " + rs.getString(2) + " " + rs.getString(3) + 
						  ", Address: " + rs.getString(4) + ", City: " + rs.getString(5));
			}

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		createNewDatabase("test.db");
	}
}
