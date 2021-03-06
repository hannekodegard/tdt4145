package tdt4145project;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    Roles roles = new Roles(con);
    User user = new User(con);
    Genre genre = new Genre(con);

    public void runProgram() {
        String choice = "0";
        user.logIn();

        Scanner input = new Scanner(System.in);

        while (!choice.equals("q")) {
            System.out.println("Hva vil du gjøre?");
            System.out.println(
                    "1) Søk på skuespiller og se roller \n2) Se største filmselskap innen hver sjanger\n3) Legg til ny film\nq) Quit application");

            choice = input.nextLine();

            if (choice.equals("1")) {
                roles.runRoleSearch();
            } else if (choice.equals("2")) {
                genre.runGenreSearch();
            } else if (choice.equals("3")) {
                dbProject.addmovie(con);
            } else if (choice.equals("2")) {
                genre.runGenreSearch();
            } else if (choice.equals("3")) {
                dbProject.addmovie(con);
            } else if (choice.equals("2")) {
                genre.runGenreSearch();
            } else if (choice.equals("3")) {
                dbProject.addmovie(con);
            } else if (choice.equals("2")) {
                genre.runGenreSearch();
            } else if (choice.equals("3")) {
                dbProject.addmovie(con);
            }
            System.out.println("\n\n");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.runProgram();

    }

}
