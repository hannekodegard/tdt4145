package tdt4145project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class User {

    DBProject dbProject = new DBProject();
    Connection con = dbProject.connect();
    String username;


    public void logIn(){
        Scanner input = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter username");
        String tmp_username = input.nextLine();  // Read user input
        System.out.println(checkUsername(tmp_username));

    }


    private boolean checkUsername(String username){
        Statement myStat;
        try {
            myStat = con.createStatement();
            String sql = "select * from bruker where brukernavn = '" + username +"';";
            ResultSet statement = myStat.executeQuery(sql);
            if(statement.next()){
                this.username = username;
                System.out.println("Logged into existing user.");
            }
            else{
                Statement myStat2 = con.createStatement();
                myStat2.executeUpdate("insert into bruker" + " values ('" + username + "')");
                System.out.println("New user added");
                this.username = username;
            }
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }


    public static void main(String[] args) {
       User u1 = new User();
        u1.logIn();
        System.out.println(u1.username);
    }
}
