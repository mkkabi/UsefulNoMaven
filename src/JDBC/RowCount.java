
package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowCount {
	
	public static int getRowCount(ResultSet rs) throws SQLException {
		int rowCount = -1;
		int currRow = 0;
		
		/*
		Make sure that ResultSet is not null, save current row position; 
		zero indicates that there is not current row position - could be beforeFirst or afterLast
		*/
		if (rs != null){
			currRow = rs.getRow();
// afterLast, so set currRow negative			
			if(rs.isAfterLast()){
				currRow = -1;
			}
			

//move to the last row and get the position; if this method returns false, there are no results;
			if(rs.last()){
//Ger the row count; return the cursor to the position it was in before the method was called;
				rowCount = rs.getRow();
//if the currRow is negative. the cursor position was after the last row, 
//so return the cursor to the last row				
				if (currRow == -1){
					rs.afterLast();
				} else if (currRow ==0) { // else if the cursor is zero, 
					rs.beforeFirst();			//move the cursor to before the first row
				} else {
					rs.absolute(currRow);
				}
			}
		}
		return rowCount;
	}
}
