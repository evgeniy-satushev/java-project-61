package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] games = new String[] {
                "1 - Greet",
                "2 - Even",
                "3 - Calc",
                "4 - GCD",
                "5 - Progression",
                "0 - Exit"};
        System.out.println("Please enter the game number and press Enter");
        Scanner sc = new Scanner(System.in);
        for (String game: games) {
            System.out.println(game);
        }
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        choiceGame(choice, sc);
        sc.close();
    }
    private static void choiceGame(int numberOfGame, Scanner sc) {
        switch (numberOfGame) {
            case 0:
                sc.close();
                break;
            case 1:
                Cli cli = new Cli();
                cli.welcome();
                break;
            case 2:
                Even even = new Even();
                even.evenNumbers();
                break;
            case 3:
                Calc calc = new Calc();
                calc.calculation();
                break;
            case 4:
                Gcd gcd = new Gcd();
                gcd.greatestCommonDiv();
                break;
            case 5:
                Progression prog = new Progression();
                prog.progression();
        }
    }
}
