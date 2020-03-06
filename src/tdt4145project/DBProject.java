package tdt4145project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBProject {
	
	String username = "root";
	String password ="vT<`HW&8k4w{Ldgn";
	String url = "jdbc:mysql://localhost:3306/tdt4145";
	
	public Connection connect() {
		Connection conn;
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
	    // Class.forName("com.mysql.cj.jdbc.Driver"); when you are using MySQL 8.0.	    
            // Properties for user and password.
            Properties p = new Properties();
            p.put("user", username);
            p.put("password", password);           
            conn = DriverManager.getConnection(url, p);
            System.out.println("A DB connection was established");
        } catch (Exception e)
    	{
            throw new RuntimeException("Unable to connect", e);
    	}
    	return conn;
    }
	
	private void addFilmToDb(Connection con) {
		
		
		
		String query = "insert into film (tittel, år, beskrivelse) values ((?), (?), (?))";
		PreparedStatement myStatement;
		try {
			myStatement = con.prepareStatement(query);
			myStatement.setString(1, "Lord of the rings return of the king");
			myStatement.setInt(2, 1990);
			myStatement.setString(3, "Sasaasasa");
			
			ResultSet rs = myStatement.executeQuery();
			
			
			while (rs.next()) {
				String navn = rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		DBProject dbproject = new DBProject();
		Connection con = dbproject.connect();
		dbproject.addFilmToDb(con);
		
	}
}

