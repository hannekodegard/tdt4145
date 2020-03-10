package tdt4145project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Roles {
    DBProject dbProject = new DBProject();
    Connection con = dbProject.connect();


    public void getInput(){
        /** kan anta at alle inputs er gyldige navn*/
        Statement myStat;

        Scanner input = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter actor");
        String actor = input.nextLine();  // Read user input

        try {
            myStat = con.createStatement();
            String sql = "select personNr from involvertIFilm where navn = '" + actor +"';";
            ResultSet statement = myStat.executeQuery(sql);


            // find movies
            if(statement.next()) {
                String personNr = statement.getString("personNr");

                String sql2 = "select filmatisering_filmID, rolle from skuespillerIFilm where involvertIFilm_personNr = '" + personNr + "';";
                ResultSet statement2 = myStat.executeQuery(sql2);
                while (statement2.next()) {
                    String filmID = statement2.getString("filmatisering_filmID");
                    String rolle = statement2.getString("rolle");

                    //find movie names
                    String sql3 = "select tittel from filmatisering where filmID = '" + filmID + "';";
                    Statement myStat2 = con.createStatement();
                    ResultSet statement3 = myStat2.executeQuery(sql3);
                    statement3.next();
                    String tittel = statement3.getString("tittel");
                    System.out.println(actor + " spiller i filmene: \n" + tittel + " som " + rolle + "\n");
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

    public static void main(String[] args) {
        Roles r = new Roles();
        r.getInput();
    }
}
