
package JDBC;

public class Quieries {
	public static String createTablePersons = "CREATE TABLE Persons (ID int NOT NULL AUTO_INCREMENT, LastName varchar(255), "
					  + "FirstName varchar(255), Address varchar(255), City varchar(255), PRIMARY KEY (ID));";
	public static String selectStatement = "SELECT ID, LastName, FirstName, Address, City FROM Persons";
	
	public static String addDataPersons = "INSERT INTO Persons (LastName, FirstName, Address, City) "
					  + "Values('Vasichkin', 'Anatole', 'gogolia street', 'Moscow')";
	
	String createTablePersonsSQLITE = "CREATE TABLE Persons (ID Integer PRIMARY KEY AUTOINCREMENT, LastName varchar(255), "
					  + "FirstName varchar(255), Address varchar(255), City varchar(255));";
	
}
