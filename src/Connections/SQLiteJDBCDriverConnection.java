
package Connections;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*

http://www.sqlitetutorial.net/sqlite-java/create-table/

*/
public class SQLiteJDBCDriverConnection {
private final String url = "jdbc:sqlite:test.db";
    
    /**
     * Connect to a sample database
     */
    public static void connect(String url) {
	try (Connection conn = DriverManager.getConnection("jdbc:sqlite:"+url)) {
	    if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
		System.out.println("Connected to "  + meta.getDriverName());
	    }
	}catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void createNewDatabase(String url) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:"+url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:tests.db";

        String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {e.printStackTrace();}
    }

    public static void main(String[] args) {
        createNewTable();
    }
}
