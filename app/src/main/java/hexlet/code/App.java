package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App.showGameNames();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        choiceGame(choice, sc);
        sc.close();
    }
    private static void showGameNames() {
        String gameNames = "Greet Even Calc GCD Progression Prime Exit";
        String[] games = gameNames.split(" ");
        int index = 1;
        for (int i = 0; i < games.length; i++) {
            games[i] = Integer.toString(index++)
                    .concat(" ")
                    .concat("-")
                    .concat(" ")
                    .concat(games[i]);
            if (index == games.length) {
                index = 0;
            }
        }
        System.out.println("Please enter the game number and press Enter");
        for (String game: games) {
            System.out.println(game);
        }
        System.out.print("Your choice: ");
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
                break;
            case 6:
                Prime prime = new Prime();
                prime.primeNumbers();
                break;
            default:
                System.out.println("Incorrect input value");
        }
    }
}
