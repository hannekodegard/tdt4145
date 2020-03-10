package tdt4145project;

import java.sql.*;
import java.util.Properties;

public class DBProject {
	
	String username = "root";
	String password ="Gruppe21";
	String url = "jdbc:mysql://localhost:3306/tdt4145";
	
	public Connection connect() {
		Connection conn;
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
		/** Denne her er statisk, så den må endres for å gi mening å bruke*/
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
		/** Denne her er statisk, så den må endres for å gi mening å bruke*/

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
	
	private void addMusicToDb(Connection con, int musikkID, String  komponent, int  fremførtAv) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values (%s,'%s','%s')", musikkID, komponent, fremførtAv);
			String sql = "insert into Musikk " + " (musikkID, komponent, fremførtAv)" + formatted;
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addInvolvedToDb(Connection con, int personNR,String  navn, int  fødselsår,String  fødselsland) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values (%s,'%s', %s, '%s')", personNR, navn, fødselsår, fødselsland);
			String sql = "insert into involvertIFilm " + " (personNR, navn, fødselsår, fødselsland)" + formatted;
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addActorToDb(Connection con, int involvertIFilm_personNr, int filmatisering_filmID, String rolle) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values (%s,%s,'%s')", involvertIFilm_personNr, filmatisering_filmID, rolle);
			String sql = "insert into skuespillerIFilm " + " (involvertIFilm_personNr, filmatisering_filmID, rolle)" + formatted;
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addWriterToDb(Connection con, int involvertIFilm_personNr, int filmatisering_filmID) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values (%s,%s)", involvertIFilm_personNr, filmatisering_filmID);
			String sql = "insert into manusforfatterHarSkrevet " + " (involvertIFilm_personNr, filmatisering_filmID)" + formatted;
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addProducerToDb(Connection con, int involvertIFilm_personNr, int filmatisering_filmID) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values (%s,%s)", involvertIFilm_personNr, filmatisering_filmID);
			String sql = "insert into regissørRegissertFilm " + " (involvertIFilm_personNr, filmatisering_filmID)" + formatted;
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addFormatToDb(Connection con, String type, int filmID) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values ('%s',%s)", type, filmID);
			String sql = "insert into format " + " (type, filmID)" + formatted;
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addCategoryToDb(Connection con, int sjangerID, String beskrivelse) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values (%s,'%s')", sjangerID, beskrivelse);
			String sql = "insert into kategori " + " (sjangerID, beskrivelse)" + formatted;
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addMusicInMovieToDb(Connection con, int Musikk_musikkID, int filmatisering_filmID) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values (%s,%s)", Musikk_musikkID, filmatisering_filmID);
			String sql = "insert into musikkI " + " (Musikk_musikkID, filmatisering_filmID)" + formatted;
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addEpisodeToDb(Connection con, int episodeNr, int sesong, int filmatisering_filmID) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values (%s,%s,%s)", episodeNr, sesong, filmatisering_filmID);
			String sql = "insert into episode " + " (episodeNr, sesong, filmatisering_filmID)" + formatted;
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addHasCategoryToDb(Connection con, int filmatisering_filmID, int kategori_sjangerID) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values (%s,%s)", filmatisering_filmID, kategori_sjangerID);
			String sql = "insert into harKategori " + " (filmatisering_filmID, kategori_sjangerID)" + formatted;
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
<<<<<<< HEAD
		//dbproject.addURLToDb(con);
		//dbproject.addFilmToDb(con);
		//dbproject.showDbInfo(con);
		//dbproject.addInvolvedToDb(con, 2345, "Niklas", 1996, "Norge");
		//dbproject.addCategoryToDb(con, 1, "Gr�sser");
		//dbproject.addActorToDb(con, 23456, 1, "Teddybj�rn");
		//dbproject.addCategoryToDb(con, 2, "Komedie");
		//dbproject.addHasCategoryToDb(con, 1, 2);
		//Hei
=======

>>>>>>> 13f2b3b0c49727565271448f61808964b4df58f1
	}
	
}

