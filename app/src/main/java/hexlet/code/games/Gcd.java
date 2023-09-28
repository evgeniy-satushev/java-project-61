package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Gcd extends Cli implements Engine {
    private final String description = "Find the greatest common divisor of given numbers";
    private String userName;
    private int correctAnswerCounter = 0;
    private int result;
    private boolean cycleOperation = true;
    public void greatestCommonDiv() {
        userName = super.welcome();
        super.description(description);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        while (super.exitGame(correctAnswerCounter, userName, cycleOperation)) {
            String firstOperand = Integer.toString(random.nextInt(2, 25));
            String secondOperand = Integer.toString(random.nextInt(2, 25));
            super.showQuestion(firstOperand.concat(" ").concat(secondOperand));
            String answer = Integer.toString(scanner.nextInt()).trim();
            result = evklidAlgorithmGCD(Integer.parseInt(firstOperand), Integer.parseInt(secondOperand));
            String checkAnswer = super.showWrongAnswer(answer, result, userName);
            correctAnswerCounter = super.equalAnswer(answer, checkAnswer, result, correctAnswerCounter);
        }
    }
    public static int evklidAlgorithmGCD(int firstOperand, int secondOperand) {
        while (firstOperand != 0 && secondOperand != 0) {
            if (firstOperand > secondOperand) {
                firstOperand %= secondOperand;
            } else {
                secondOperand %= firstOperand;
            }
        }
        return firstOperand + secondOperand;
    }
}
