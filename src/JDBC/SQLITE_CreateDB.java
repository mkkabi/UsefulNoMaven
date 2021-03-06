package JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
				
//				st.execute(createTablePersons);
//				st.execute(Quieries.addDataPersons);
				

			ResultSet rs = st.executeQuery(Quieries.selectStatement); 
			
			//Information about a 
			ResultSetMetaData rsmd = rs.getMetaData();
				System.out.println(
				"\nColumn count "+ rsmd.getColumnCount()		
				+"\n is Autoincrement " + rsmd.isAutoIncrement(1)
				+"\nTable name: " + rsmd.getTableName(1)
				+ "\nCatalog name "+rsmd.getCatalogName(1)
				+"\nColumn Class name "+rsmd.getColumnClassName(1)+"\n");

			while (rs.next()) {
				System.out.println("ID: " + rs.getInt(1) + ", Name: " + rs.getString(2) + " " + rs.getString(3) + 
						  ", Address: " + rs.getString(4) + ", City: " + rs.getString(5));
			}

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		createNewDatabase("test.db");
	}
}