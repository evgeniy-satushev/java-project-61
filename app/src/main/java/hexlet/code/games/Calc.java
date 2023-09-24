package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Calc implements Engine {
    public void calculation() {
        int correctAnswerCounter = 0;
        int changeOperator = 0;
        int result = 0;
        char operator = '+';
        boolean cycleOperation = true;
        String userName = Engine.welcome();
        description();
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
            getAnswer(firstOperand + " " + operator + " " + secondOperand);
            String answer = Integer.toString(scanner.nextInt()).trim();
            String checkWrongAnswer = wrongAnswer(answer, result, userName);
            correctAnswerCounter = equalAnswer(answer, checkWrongAnswer, result, correctAnswerCounter);
        }
    }

    @Override
    public void description() {
        System.out.println("What is the result of the expression?");
    }

    @Override
    public String wrongAnswer(String answer, int result, String userName) {
        String correctAnswer = (result == Integer.parseInt(answer)) ? answer : Integer.toString(result);
        return "'" + answer + "'"
                .concat(" is wrong answer ;(. Correct answer was ")
                .concat(correctAnswer) + "\n"
                .concat(" try again ") + userName;
    }

    @Override
    public boolean exitGame(int correctAnswerCounter, String userName, boolean cycleOperation) {
        if (correctAnswerCounter == 3) {
            cycleOperation = false;
            System.out.println("Congratulation " + userName +'!');
        }
        return cycleOperation;
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

    @Override
    public void getAnswer(String expression) {
        System.out.println("Question : " + expression);
        System.out.print("Your Answer : ");
    }
}
