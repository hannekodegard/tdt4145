package tdt4145project;
/**
 * Used to control the view of actors and their roles in the movies they have acted in.
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Roles {
    Connection con;

    public Roles(Connection con){
        this.con = con;
    }



    private String getInput() {
        /** Get input from user */

        Scanner input = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter actor");
        String actor = input.nextLine();  // Read user input
        return actor;
    }
    private void listMovies(String actor){
        /** Find search name in database and print the wanted data*/
        Statement myStat;
        try {
            myStat = this.con.createStatement();
            String sql = "select personNr from involvertIFilm where navn = '" + actor +"';";
            ResultSet statement = myStat.executeQuery(sql);


            // find movies
            if(statement.next()) {
                String personNr = statement.getString("personNr");
                System.out.println(actor + " spiller i filmene: \n");
                String sql2 = "select filmatisering_filmID, rolle from skuespillerIFilm where involvertIFilm_personNr = '" + personNr + "';";
                ResultSet statement2 = myStat.executeQuery(sql2);
                while (statement2.next()) {
                    String filmID = statement2.getString("filmatisering_filmID");
                    String rolle = statement2.getString("rolle");

                    //find movie names
                    String sql3 = "select tittel from filmatisering where filmID = '" + filmID + "';";
                    Statement myStat2 = this.con.createStatement();
                    ResultSet statement3 = myStat2.executeQuery(sql3);
                    statement3.next();
                    String tittel = statement3.getString("tittel");
                    System.out.println( tittel + " som " + rolle + "\n");
                }
                System.out.println("----------------------");
                System.out.println("All results printed.");

            }
            else {
                System.out.println("This person does not exist in the database.");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void runRoleSearch(){
        listMovies(getInput());

    }

    public static void main(String[] args) {
        DBProject dbProject = new DBProject();
        Connection con = dbProject.connect();
        Roles r = new Roles(con);
        r.runRoleSearch();
    }
}
