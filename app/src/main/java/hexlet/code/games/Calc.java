package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Calc extends Cli implements Engine {
    private final String description = "What is the result of the expression?";
    private String userName;
    private int changeOperator = 0;
    private int result = 0;
    private char operator = '+';
    public void calculation() {
        int correctAnswerCounter = 0;
        boolean cycleOperation = true;
        userName = welcome();
        super.description(description);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        while (super.exitGame(correctAnswerCounter, userName, cycleOperation)) {
            int firstOperand = random.nextInt(1, 10);
            int secondOperand = random.nextInt(1, 10);
            setChangeOperator(firstOperand, secondOperand);
            super.showQuestion(firstOperand + " " + operator + " " + secondOperand);
            String answer = Integer.toString(scanner.nextInt()).trim();
            String checkWrongAnswer = super.showWrongAnswer(answer, result, userName);
            correctAnswerCounter = super.equalAnswer(answer, checkWrongAnswer, result, correctAnswerCounter);
        }
    }
    private void setChangeOperator(int firstOperand, int secondOperand) {
        switch (changeOperator) {
            case 0:
                result = firstOperand + secondOperand;
                operator = '+';
                changeOperator++;
                break;
            case 1:
                result = firstOperand - secondOperand;
                operator = '-';
                changeOperator++;
                break;
            case 2:
                result = firstOperand * secondOperand;
                operator = '*';
                changeOperator = 0;
                break;
            default:
                System.out.println("Incorrect input value");
        }
    }
}
