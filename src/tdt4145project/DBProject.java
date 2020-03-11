package tdt4145project;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


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
	
	private void addURLToDb(Connection con, String URL, String adresse, String land) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values ('%s','%s','%s')", URL, adresse, land);
			String sql = "insert into utgivelsesselskap " + " (URL, Adresse, Land)" + formatted;
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private void addFilmToDb(Connection con, String tittel, int lengde, int utgivelsesår, String lanseringsdato, String storyline, String Utgivelsesselskap_URL) {
		//Format utgivelsesår: YYYY-MM-DD

		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values ('%s',%s,%s,'%s','%s','%s')", tittel, lengde, utgivelsesår, lanseringsdato, storyline, Utgivelsesselskap_URL);
			String sql = "insert into filmatisering " + " (tittel, lengde, utgivelsesår, lanseringsdato, storyline, Utgivelsesselskap_URL)" + formatted;
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
			String sql = "insert into Musikk " + " (musikkID, komponent, fremfÃ¸rtAv)" + formatted;
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addInvolvedToDb(Connection con,String  navn, int  fødselsår ,String  fødselsland) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values ('%s', %s, '%s')", navn, fødselsår, fødselsland);
			String sql = "insert into involvertIFilm " + " (navn, fødselsår, fødselsland)" + formatted;
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

	private String checkURL(Connection con, String thisURL) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String sql = String.format("select URL from tdt4145.utgivelsesselskap where URL = '%s'",thisURL);
			ResultSet statement = myStat.executeQuery(sql);
			if (statement.next()) {
				return statement.getString("URL");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private int findFilmID(Connection con, String movieName) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String sql = String.format("select filmID from tdt4145.filmatisering where tittel = '%s'", movieName);
			ResultSet statement = myStat.executeQuery(sql);
			if (statement.next()) {
				return statement.getInt("filmID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	private void updateMovie(Connection con, String movieName, String URL) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Hvor lang er filmen (i min)?");
		int lengde = Integer.parseInt(myObj.nextLine());  // Read user input
		System.out.println("Hvilket år ble den utgitt?");
		int utgivelsesår = Integer.parseInt(myObj.nextLine());  // Read user input
		System.out.println("Hvilken dato ble den lansert? Format: YYYY-MM-DD");
		String lanseringsdato = myObj.nextLine();  // Read user input
		System.out.println("Hva handler den om");
		String storyline = myObj.nextLine();  // Read user input

		this.addFilmToDb(con, movieName, lengde, utgivelsesår, lanseringsdato, storyline, URL);

	}

	private int checkActor(Connection con, String ActorName) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String sql = String.format("select personNr from tdt4145.involvertifilm where navn = '%s'", ActorName);
			ResultSet statement = myStat.executeQuery(sql);
			if (statement.next()) {
				return statement.getInt("personNr");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	private void addActors(Connection con, int filmID) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Hvor mange skuespillere er det i filmen");
		int antallSkuespillere = Integer.parseInt(myObj.nextLine());
		for(int i = 0; i <= antallSkuespillere; i++) {
			System.out.println("Hva heter skuespilleren?");
			String skuespillerNavn = myObj.nextLine();
			int checkActor = checkActor(con, skuespillerNavn);
			if (checkActor == -1) {
				System.out.println("Hva er fødselsåret til skuespilleren?");
				int fødselsår = Integer.parseInt(myObj.nextLine());  // Read user input
				System.out.println("Hvilket land er skuespilleren fra?");
				String land = myObj.nextLine();  // Read user input
				this.addInvolvedToDb(con, skuespillerNavn, fødselsår, land);

			}
			System.out.println("Hvilken rolle spiller den?");
			String rolle = myObj.nextLine();  // Read user input
			int personNr = this.checkActor(con, skuespillerNavn);
			this.addActorToDb(con, personNr, filmID, rolle);

		}
	}

	public void addmovie(Connection con) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Hva heter filmen?");
		String movieName = myObj.nextLine();  // Read user input
		int checkMovie = findFilmID(con, movieName);
		if (checkMovie != -1) {
			System.out.println("Filmen eksisterer allerede");
		}
		else {
			System.out.println("Hvem har gitt ut filmen");
			String thisURL = myObj.nextLine();  // Read user input

			if(checkURL(con, thisURL) == null) {

				System.out.println("Hva er adressen til selskapet?");
				String adress = myObj.nextLine();  // Read user input
				System.out.println("Hvilket land er selskapet i?");
				String land = myObj.nextLine();  // Read user input
				this.addURLToDb(con, thisURL, adress, land);
			}
			this.updateMovie(con, movieName, thisURL);
			int filmID = this.findFilmID(con, movieName);
			this.addActors(con, filmID);
			System.out.println("Ferdig");


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
		//dbproject.addURLToDb(con, "DreamWorks", "New York", "USA");
		//dbproject.addFilmToDb(con,"Mamma Mia", 200, 2018, "2018-12-20", "Music", "DreamWorks");
		//dbproject.showDbInfo(con);
		//dbproject.addInvolvedToDb(con, 2345, "Niklas", 1996, "Norge");
		//dbproject.addCategoryToDb(con, 1, "Grøsser");
		//dbproject.addActorToDb(con, 23456, 1, "Teddybjørn");
		//dbproject.addCategoryToDb(con, 2, "Komedie");
		//dbproject.addHasCategoryToDb(con, 1, 2);
		//Hei
//		dbproject.addmovie(con);
	}
	
}

