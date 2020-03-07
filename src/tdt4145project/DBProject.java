package tdt4145project;

import java.sql.*;
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
	
	private void addURLToDb(Connection con) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String sql = "insert into utgivelsesselskap " + " (URL, Adresse, Land)" + " values ('Hannes', 'Norge', 'Norge')";
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private void addFilmToDb(Connection con) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String sql = "insert into filmatisering " + " (filmID, tittel, lengde, utgivelsesår, lanseringsdato, storyline, Utgivelsesselskap_URL)" + " values (1, 'Ted', 120, 2012, null, 'plot', 'Hannes')";
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void showDbInfo(Connection con) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String sql = "select * from utgivelsesselskap";
			ResultSet statement = myStat.executeQuery(sql);
			while (statement.next()) {
				System.out.println(statement.getString("URL") + ", " + statement.getString("Adresse") + ", " + statement.getString("Land"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DBProject dbproject = new DBProject();
		Connection con = dbproject.connect();
		//dbproject.addURLToDb(con);
		//dbproject.addFilmToDb(con);
		dbproject.showDbInfo(con);
		
	}
	
}

