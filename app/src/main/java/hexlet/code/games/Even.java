package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {
    public void evenNumbers() {
        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        System.out.println(rules);
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int correctAnswerCounter = 0;
        boolean counter = true;
        while (counter) {
            int randomNumber = random.nextInt(10, 100);
            System.out.println("Question : " + randomNumber);
            System.out.print("Your Answer : ");
            String answer = sc.nextLine().trim();
            String correctAnswer = randomNumber % 2 == 0 ? "'yes'." : "'no'.";
            String wrongAnswer = "'" + answer + "'"
                    .concat(" is wrong answer ;(. Correct answer was ")
                    .concat(correctAnswer) + "\n"
                    .concat(" try again ") + Cli.getUserName();
            if (randomNumber % 2 == 0) {
                if ("yes".equalsIgnoreCase(answer)) {
                    System.out.println("Correct!");
                    correctAnswerCounter++;
                } else {
                    System.out.println(wrongAnswer);
                    correctAnswerCounter = 0;
                }
            } else {
                if ("no".equalsIgnoreCase(answer)) {
                    System.out.println("Correct!");
                    correctAnswerCounter++;
                } else {
                    System.out.println(wrongAnswer);
                    correctAnswerCounter = 0;
                }
            }
            if (correctAnswerCounter == 3) {
                counter = false;
                System.out.println("Congratulation " + Cli.getUserName() + '!');
            }
        }
    }
}
