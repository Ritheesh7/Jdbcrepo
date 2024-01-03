package jdbcPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class P1FetchData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Registered the jdbc Driver");
		
		String dbURL ="jdbc:mysql://localhost:3306/animatedd_movies";
		String username="root";
		String password="root";
		String query="select *from movies";
		
		Connection con = DriverManager.getConnection(dbURL,username,password);
		System.out.println("connection successfull");
		
		Statement stmt =con.createStatement();
		ResultSet rs =	stmt.executeQuery(query);
		while(rs.next()) {
			System.out.print("tittle: " + rs.getString("tittle") + "\t");
			System.out.print("genre: " + rs.getString("genre") + "\t");
	    	System.out.print("director: " + rs.getString("director") + "\t");
	    	System.out.println("release_year: " +rs.getString("release_year"));
		}
		
		con.close();
		System.out.println("connection closed");
		
	}

}