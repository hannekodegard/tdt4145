package tdt4145project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

public class Genre {
    Connection con;

    public Genre(Connection con){
        this.con = con;
    }

    public String getInput() {
        /** antar all informasjon gyldig*/
        Scanner input = new Scanner(System.in);  // Create a Scanner object

        //Use genre to find movies in genre
        System.out.println("Enter genre");
        String genre = input.nextLine();  // Read user input
        return genre;
    }
    public void MostCompany(String genre){
        /** through genre find the company with the most movies*/
        //find genre
        Statement myStat;
        try {
            myStat = con.createStatement();
            String sql = "select Utgivelsesselskap_URL from tdt4145.filmatisering inner join harkategori inner join kategori where kategori.beskrivelse = " + String.format("'%s'", genre);
            ResultSet statement = myStat.executeQuery(sql);

            List<String> URL_list = new ArrayList<>();
            if(statement.next()){
                URL_list.add(statement.getString("Utgivelsesselskap_URL"));
            }

            //Teller antall
            Map<String, Long> occurrences =
                    URL_list.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));
            System.out.println("Selskapet med flest filmer i sangeren " +genre + " er "+ occurrences);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void runGenreSearch(){
        MostCompany(getInput());
    }

    public static void main(String[] args) {
        DBProject dbProject = new DBProject();
        Connection con = dbProject.connect();
        Genre g = new Genre(con);
        g.runGenreSearch();
    }
}
