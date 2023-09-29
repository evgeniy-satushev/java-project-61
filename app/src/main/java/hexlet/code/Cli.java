package hexlet.code;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class Cli implements Engine {
    public String welcome() {
        System.out.println("Welcome to the Brain Games!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + '!');
        return userName;
    }
    @Override
    public void description(String rules) {
        System.out.println(rules);
    }
    @Override
    public void showQuestion(String expression) {
        System.out.println("Question: " + expression);
        System.out.print("Your Answer: ");
    }
    @Override
    public boolean exitGame(int correctAnswerCounter, String userName, boolean cycleOperation) {
        if (correctAnswerCounter == 3) {
            cycleOperation = false;
            System.out.println("Congratulations, " + userName + '!');
        }
        return cycleOperation;
    }
    @Override
    public String showWrongAnswer(String answer, int result, String userName) {
        String correctAnswer;
        if (NumberUtils.isCreatable(answer)) {
            correctAnswer = (result == Integer.parseInt(answer)) ? answer : Integer.toString(result);
        } else {
            correctAnswer = result % 2 == 0 ? "'yes'." : "'no'.";
        }
        return "'" + answer + "'"
                .concat(" is wrong answer ;(. Correct answer was ")
                .concat(correctAnswer) + "\n"
                .concat("Let's try again, ") + userName;
    }
    @Override
    public int equalAnswer(String answer, String wrongAnswer, int result, int correctAnswerCounter) {
        if (Integer.parseInt(answer) == result) {
            correctAnswerCounter++;
            System.out.println("Correct!");
        } else {
            System.out.println(wrongAnswer);
            correctAnswerCounter = 0;
        }
        return correctAnswerCounter;
    }
}
