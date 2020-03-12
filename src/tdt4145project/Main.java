package tdt4145project;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    DBProject dbProject = new DBProject();
    Connection con = dbProject.connect();


    Roles roles = new Roles(con);
    User user = new User(con);
    Genre genre = new Genre(con);
    Review review = new Review(con);

    public void runProgram(){
        String choice = "0";
        user.logIn();

        Scanner input = new Scanner(System.in);

        while (!choice.equals("q")) {
            System.out.println("Hva vil du gjøre?");
            System.out.println("1) Søk på skuespiller og se roller \n2) Se største filmselskap innen hver sjanger\n3) Legg til ny film\n4) Se alle serier\nq) Quit application");

            choice = input.nextLine();

            if (choice.equals("1")) {
                roles.runRoleSearch();
            }
            else if (choice.equals("2")){
                System.out.println("Valg 2");
            }
            else if (choice.equals("3")){

            }
            else if (choice.equals("4")){
                review.listSeries();
                review.runSeriesSearch();
                review.addReview(user);
            }
            System.out.println("\n\n");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.runProgram();


    }
}
