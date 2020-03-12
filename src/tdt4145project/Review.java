package tdt4145project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Review {

    private Connection con;

    public Review(Connection con){
        this.con = con;
    }

    private String getInput(){
        Scanner input = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter the title of the series:");
        return input.nextLine(); //Return user input
    }

    public void listSeries(){
        //Shows a list of all the series in the database
        Statement myStat; //Declares a statement called myStat

        try {
            myStat = this.con.createStatement(); //Creates a statement
            String sql = "select tittel from tdt4145.filmatisering where serie"; //Shows the title of all series
            ResultSet statement = myStat.executeQuery(sql); //Excecutes the select statement
            while (statement.next()) {
                //While there is more lines in the row, print out the title
                System.out.println(statement.getString("tittel"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String findFilmID(String title){
        //Shows a list of all episodes in a given seriesa
        Statement myStat;
        try {
            myStat = this.con.createStatement();
            String sql = String.format("select filmID from tdt4145.filmatisering where filmatisering.tittel = '%s'", title);
            ResultSet statement = myStat.executeQuery(sql);
            if (statement.next()) {
                return statement.getString("filmID");
            }
            else {
                System.out.println("This title doesn't exist in the database");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private void searchSeries(String title){
        //Shows a list of all episodes in a given series
        String filmID = this.findFilmID(title);
        Statement myStat;
        try {
            myStat = this.con.createStatement();
            String sql = String.format("select episodeNr from tdt4145.episode where filmatisering_filmID = '%s'", filmID);
            ResultSet statement = myStat.executeQuery(sql);
            while (statement.next()) {
                System.out.println(title + ": episodeNr "+statement.getString( statement.getInt("episodeNr")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void runSeriesSearch(){
        searchSeries(getInput());
    }

    public void addReview(User u1){

//        User u1 = new User(this.con);
//        u1.logIn();

        Scanner input = new Scanner(System.in); // Create a Scanner object

        // Choose the series
        System.out.println("Enter the title of the series:");
        String tittel = input.nextLine();

        // Choose the episode
        System.out.println("Enter the episode number:");
        int episodeNr = input.nextInt();

        // Add a rating
        System.out.println("Add a rating (number between one and ten):");
        int rating = input.nextInt();

        // Add a review
        System.out.println("Add a review:");
        String review = input.nextLine();

        // Add the rating and review to the database
        addReviewToDB(u1, episodeNr, rating, review);

    }

    private void addReviewToDB(User bruker_brukernavn, int episode_episodeNr, int rating, String beskrivelse) {
        //Adds a review to the database //Skjønner ikke hvordan denne kobles til riktig når vi ikke har tittel?
        Statement myStat;

        try {
            myStat = this.con.createStatement();
            String formatted = String.format(" values (%s,'%s',%s,'%s')", episode_episodeNr, bruker_brukernavn.username, rating, beskrivelse);
            String sql = "insert into ratingEpisode " + " (episode_episodeNr, bruker_brukernavn, rating, beskrivelse)" + formatted;
            myStat.executeUpdate(sql);
            System.out.println("Insert complete");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //Testing the functionality
        DBProject dbProject = new DBProject();
        Connection con = dbProject.connect();




    }
}
