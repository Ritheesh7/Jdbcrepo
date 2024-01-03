package jdbcPrograms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class P5UpdateData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		String dbURL = "jdbc:mysql://localhost:3306/animatedd_movies";
		String username = "root";
		String password = "root";
		String query = "update movies set release_year='2001' where tittle='movie2'" ;
		String query2 = "select * from movies";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(dbURL, username, password);
		
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
		
		ResultSet rs = stmt.executeQuery(query2);
		
		  while(rs.next()) {
		    	 
		    	 System.out.print("tittle: " + rs.getString("tittle") + "\t");
		    	 System.out.print("genre: " + rs.getString("genre") + "\t");
		    	 System.out.print("director: " + rs.getString("director") + "\t");
		    	 System.out.println("release_year: " +rs.getString("release_year"));
		    	 
		     }
			
		con.close();
		
	}

}


