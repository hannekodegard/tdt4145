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

	private void addFormatToDb(Connection con,  String type) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values ('%s')", type);
			String sql = "insert into format " + " (type)" + formatted;
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addFilmHasFormatToDb(Connection con, int filmID, String type) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values (%s,'%s')", filmID, type);
			String sql = "insert into filmatisering_has_format " + " (filmID, type)" + formatted;
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addFilmToDb(Connection con, String tittel, int lengde, int utgivelsesår, String lanseringsdato, String storyline, String Utgivelsesselskap_URL, int serie) {
		//Format utgivelsesår: YYYY-MM-DD

		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values ('%s',%s,%s,'%s','%s','%s', %s)", tittel, lengde, utgivelsesår, lanseringsdato, storyline, Utgivelsesselskap_URL, serie);
			String sql = "insert into filmatisering " + " (tittel, lengde, utgivelsesår, lanseringsdato, storyline, Utgivelsesselskap_URL, serie)" + formatted;
			myStat.executeUpdate(sql);
			System.out.println("Insert complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addMusicToDb(Connection con, String  komponent, String  fremførtAv) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values ('%s','%s')", komponent, fremførtAv);
			String sql = "insert into Musikk " + " (komponent, fremførtAv)" + formatted;
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
	
	private void addCategoryToDb(Connection con, String beskrivelse) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values ('%s')", beskrivelse);
			String sql = "insert into kategori " + " (beskrivelse)" + formatted;
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
	
	private void addEpisodeToDb(Connection con, int sesong, int filmatisering_filmID) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String formatted = String.format(" values (%s,%s)", sesong, filmatisering_filmID);
			String sql = "insert into episode " + " (sesong, filmatisering_filmID)" + formatted;
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

	private int isSeries(Connection con, int filmID) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String sql = String.format("select serie from tdt4145.filmatisering where filmID = %s", filmID);
			ResultSet statement = myStat.executeQuery(sql);
			if (statement.next()) {
				return statement.getInt("serie");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
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
		System.out.println("Er dette en serie?");
		String erserie = myObj.nextLine();  // Read user input
		int serie = 0;
		if (erserie.equals("Ja") || erserie.equals("ja")) {
			serie = 1;
		}
		else {
			System.out.println("Er dette en episode av en serie?");
			String erEpisode = myObj.nextLine();  // Read user input
			System.out.println(erEpisode);
			if (erEpisode.equals("Ja") || erEpisode.equals("ja")) {
				System.out.println("Hvilken serie tilhører episoden?");
				String filmNavn = myObj.nextLine();  // Read user input
				System.out.println("Hvilken sesong tilhører den?");
				int episodeSesong = Integer.parseInt(myObj.nextLine());  // Read user input
				int filmID = findFilmID(con, filmNavn);
				if (filmID == -1) {
					System.out.println("Serien eksisterer ikke");
				} else {
					int isSeries = isSeries(con, filmID);
					if (isSeries == 0) {
						System.out.println("Filmen eksisterer, men er ikke en serie");
					} else {
						this.addEpisodeToDb(con, episodeSesong, filmID);
						serie = 1;
						System.out.println("Serie lagt til");
					}
				}
			}
		}
		this.addFilmToDb(con, movieName, lengde, utgivelsesår, lanseringsdato, storyline, URL, serie);

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
			e.printStackTrace();
		}
		return -1;
	}

	private int checkGenre(Connection con, String sjangerNavn) {
		Statement myStat;
		try {
			myStat = con.createStatement();
			String sql = String.format("select sjangerID from tdt4145.kategori where beskrivelse = '%s'", sjangerNavn);
			ResultSet statement = myStat.executeQuery(sql);
			if (statement.next()) {
				return statement.getInt("sjangerID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	private void addActors(Connection con, int filmID) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Hvor mange skuespillere er det i filmen");
		int antallSkuespillere = Integer.parseInt(myObj.nextLine());
		if ( antallSkuespillere > 0) {
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
	}

	private void addWriter(Connection con, int filmID) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Hvor mange manusskribenter er det i filmen");
		int antallSkribenter = Integer.parseInt(myObj.nextLine());
		if (antallSkribenter > 0) {
		for(int i = 1; i <= antallSkribenter; i++) {
			System.out.println("Hva heter skribenten?");
			String skribentNavn = myObj.nextLine();
			int checkActor = checkActor(con, skribentNavn);
			if (checkActor == -1) {
				System.out.println("Hva er fødselsåret til skribenten?");
				int fødselsår = Integer.parseInt(myObj.nextLine());  // Read user input
				System.out.println("Hvilket land er skribenten fra?");
				String land = myObj.nextLine();  // Read user input
				this.addInvolvedToDb(con, skribentNavn, fødselsår, land);

			}
			int personNr = this.checkActor(con, skribentNavn);
			this.addWriterToDb(con, personNr, filmID);
		}
		}
	}

	private void addProducer(Connection con, int filmID) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Hva heter produsenten?");
		String produsentNavn = myObj.nextLine();
		int checkActor = checkActor(con, produsentNavn);
		if (checkActor == -1) {
			System.out.println("Hva er fødselsåret til produsenten?");
			int fødselsår = Integer.parseInt(myObj.nextLine());  // Read user input
			System.out.println("Hvilket land er produsenten fra?");
			String land = myObj.nextLine();  // Read user input
			this.addInvolvedToDb(con, produsentNavn, fødselsår, land);
			}
		int personNr = this.checkActor(con, produsentNavn);
		this.addProducerToDb(con, personNr, filmID);

	}

	private void addMusic(Connection con, int filmID) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Hvor mange sanger er det i filmen");
		int antallSkribenter = Integer.parseInt(myObj.nextLine());
		if (antallSkribenter > 0) {
			for(int i = 1; i <= antallSkribenter; i++) {
				System.out.println("Hva heter sanfen");
				String sangTittel = myObj.nextLine();
				System.out.println("Hvem har komponert sangen");
				String komponist = myObj.nextLine();  // Read user input
				System.out.println("Hvem er sangen fremført av?");
				String fremførtAv = myObj.nextLine();  // Read user input
				this.addMusicToDb(con, komponist, fremførtAv);
				//this.addMusicInMovieToDb(con, musicID, filmID);

			}
		}
	}


	private void addFormat(Connection con, int filmID) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Kan filmen streames?");
		String stream = myObj.nextLine();
		if(stream.toUpperCase().equals("JA")) {

		}

	}

	private void addGenre(Connection con, int filmID) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Hvilken sjanger er filmen");
		String sjangerNavn = myObj.nextLine();
		int checkGenre = checkGenre(con, sjangerNavn);
		if (checkGenre == -1) {
			this.addCategoryToDb(con, sjangerNavn);
		}
		int genreID = checkGenre(con, sjangerNavn);
		this.addHasCategoryToDb(con, filmID, genreID);


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
			this.addActors(con, filmID); //Tillater flere skuespillere
			this.addProducer(con, filmID); //Antar bare en produsent
			this.addWriter(con, filmID); //Tillater flere manusforfattere
			this.addMusic(con, filmID);
			this.addGenre(con, filmID);
			this.addFormat(con, filmID);
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
		dbproject.addmovie(con);
	}
	
}

