package hexlet.code;

import java.util.Scanner;

public interface Engine {
        static String welcome() {
        System.out.println("Welcome to the Brain Games!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have yor name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello " + userName + '!');
        return userName;
    }
        void description();
        String wrongAnswer(String answer, int result, String userName);
        boolean exitGame(int correctAnswerCounter, String userName, boolean cycleOperation);
        int equalAnswer(String answer, String wrongAnswer, int result, int correctAnswerCounter);
        void getAnswer(String expression);
        // void showResult();
}
