package tdt4145project;
/**
 * Set username and check if user exists in database
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class User {

    Connection con;
    String username;

    public User(Connection con){
        this.con = con;
    }
    public void logIn(){
        /** Log in user */
        Scanner input = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter username");
        String tmp_username = input.nextLine();  // Read user input
        System.out.println(checkUsername(tmp_username));

    }


    private boolean checkUsername(String username){
        /** If user does not exist, insert new row in database*/
        Statement myStat;
        try {
            myStat = this.con.createStatement();
            String sql = "select * from bruker where brukernavn = '" + username +"';";
            ResultSet statement = myStat.executeQuery(sql);
            if(statement.next()){
                this.username = username;
                System.out.println("Logged into existing user.");
            }
            else{
                Statement myStat2 = this.con.createStatement();
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
        DBProject dbProject = new DBProject();
        Connection con = dbProject.connect();
        User u1 = new User(con);
        u1.logIn();
        System.out.println(u1.username);
    }
}
