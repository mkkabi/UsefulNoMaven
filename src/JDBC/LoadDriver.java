package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!
public class LoadDriver {

	public static void main(String[] args) {
		try {
            // The newInstance() call is a work around for some
			// broken Java implementations

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			// handle the error
		}

//After the driver has been registered with the DriverManager, 
//you can obtain a Connection instance that is connected to a particular database 
//by calling DriverManager.getConnection():				
		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "mkkabi", "pass");
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("select * from Persons");			
			// Do something with the Connection
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}
