package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String userName;
    public static void welcome() {
        System.out.println("Welcome to the Brain Games!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have yor name? ");
        userName = scanner.nextLine();
        System.out.println("Hello " + userName + '!');
    }

    public static String getUserName() {
        return userName;
    }
}
