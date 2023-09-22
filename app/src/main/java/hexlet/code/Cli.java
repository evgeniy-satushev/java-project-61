package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void welcome() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have yor name? ");
        Scanner sc = new Scanner(System.in);
        String userName = "";
        if (sc.hasNextLine()) {
            userName = sc.nextLine();
        } else {
            System.out.println("Pleas enter your user name");
        }
        System.out.println("Hello " + userName + '!');
    }
}
