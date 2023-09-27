package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Calc extends Cli implements Engine {
    public void calculation() {
        int correctAnswerCounter = 0;
        int changeOperator = 0;
        int result = 0;
        char operator = '+';
        boolean cycleOperation = true;
        String answer;
        String checkWrongAnswer;
        String userName = welcome();
        String description = "What is the result of the expression?";
        super.description(description);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        while(exitGame(correctAnswerCounter, userName, cycleOperation)) {
            int firstOperand = random.nextInt(1, 10);
            int secondOperand = random.nextInt(1, 10);
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
            }
            super.showQuestion(firstOperand + " " + operator + " " + secondOperand);
            answer = Integer.toString(scanner.nextInt()).trim();
            checkWrongAnswer = super.showWrongAnswer(answer, result, userName);
            correctAnswerCounter = super.equalAnswer(answer, checkWrongAnswer, result, correctAnswerCounter);
        }
    }
}
