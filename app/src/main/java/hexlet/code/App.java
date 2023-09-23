package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] games = new String[] {"1 - Greet", "2 - Even", "0 - Exit"};
        System.out.println("Please enter the game number and press Enter");
        Scanner sc = new Scanner(System.in);
        for (String game: games) {
            System.out.println(game);
        }
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 0:
                sc.close();
                break;
            case 1:
                Cli.welcome();
                break;
            case 2:
                Cli.welcome();
                Even even = new Even();
                even.evenNumbers();
                break;
        }
        sc.close();
    }
}
