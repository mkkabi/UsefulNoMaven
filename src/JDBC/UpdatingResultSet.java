
package JDBC;

import java.sql.*;

public class UpdatingResultSet {
	
		// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test";

	//  Database credentials
	static final String USER = "adsfasdf";
	static final String PASS = "";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String selectStatement = "SELECT ID, LastName, FirstName, Address, City FROM Persons";


			ResultSet rs = stmt.executeQuery(selectStatement);

			while (rs.next()) {

				int id = rs.getInt("ID");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				String address = rs.getString("Address");
				String city = rs.getString("City");
				
				if(rs.getString("City").equals("Moscow")){
					rs.updateString("City", "Nikolaev");
					rs.updateRow();
				}

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
		} catch (SQLException se) {//Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {//Handle errors for Class.forName
			e.printStackTrace();
		} finally {//finally block used to close resources
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {}// nothing we can do
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

}
