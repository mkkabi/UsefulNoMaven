package Connections;

import java.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL_DB_Connection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//	  Connecting to Derby Database
//        String host = "jdbc:derby://localhost:80/sys";
//        Connection con = DriverManager.getConnection( host, "root", "pass" );
//        Statement st = con.createStatement();
//        String sql = "Select * from sys_config";
//        ResultSet result = st.executeQuery(sql);
//        result.next();
//        System.out.println(result.getString("Name"));

    }

    public static void connect() {
	String host = "jdbc:mysql://localhost:3306/poshiv";
	Connection connection = null;
	try {
	    Class.forName("com.mysql.jdbc.Driver");

	    connection = DriverManager.getConnection(host, "root", "pass");
	    Statement st = connection.createStatement();
	    String sql = "Select * from jos_users";
	    ResultSet result = st.executeQuery(sql);
	    result.next();
	    System.out.println(result.getString("username"));

	    //int rsI = st.executeUpdate(sql);
	    System.out.println("Hi");
	} catch (Exception e) {
	    System.out.println(e);
	} finally {
	    if (connection != null) {
		try {
		    connection.close();
		    System.out.println("Database connection terminated");
		} catch (Exception e) { /* ignore close errors */ }
	    }
	}
    }

}
