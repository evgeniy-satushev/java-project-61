package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Even extends Cli implements Engine {
    private final String description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private String userName;
    public void evenNumbers() {
        int correctAnswerCounter = 0;
        boolean cycleOperation = true;
        userName = super.welcome();
        super.description(description);
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        while (super.exitGame(correctAnswerCounter, userName, cycleOperation)) {
            int randomNumber = random.nextInt(10, 100);
            super.showQuestion(Integer.toString(randomNumber));
            String answer = sc.nextLine().trim();
            String checkWrongAnswer = super.showWrongAnswer(answer, randomNumber, userName);
            correctAnswerCounter = equalAnswer(answer, checkWrongAnswer, randomNumber, correctAnswerCounter);
        }
    }
    public boolean checkAnswer(String answer, int result) {
        if (result % 2 == 0 && "yes".equalsIgnoreCase(answer)) {
            return true;
        } else {
            return result % 2 != 0 && "no".equalsIgnoreCase(answer);
        }
    }
    @Override
    public int equalAnswer(String answer, String wrongAnswer, int result, int correctAnswerCounter) {
        if (checkAnswer(answer, result)) {
            System.out.println("Correct");
            correctAnswerCounter++;
        } else {
            System.out.println(wrongAnswer);
            correctAnswerCounter = 0;
        }
        return correctAnswerCounter;
    }
}
