package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] games = new String[] {
                "1 - Greet",
                "2 - Even",
                "3 - Calc",
                "4 - GCD",
                "0 - Exit"};
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
                Engine.welcome();
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
        }
        sc.close();
    }
}
