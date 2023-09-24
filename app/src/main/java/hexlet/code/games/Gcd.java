package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Gcd implements Engine {
    public void greatestCommonDiv() {
        int correctAnswerCounter = 0;
        int result;
        boolean cycleOperation = true;
        String userName = Engine.welcome();
        description();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        while (exitGame(correctAnswerCounter, userName, cycleOperation)) {
            String firstOperand = Integer.toString(random.nextInt(2 , 100));
            String secondOperand = Integer.toString(random.nextInt(2, 100));
            getAnswer(firstOperand.concat(" ").concat(secondOperand));
            String answer = Integer.toString(scanner.nextInt()).trim();
            result = evklidAlgorithmGCD(Integer.parseInt(firstOperand), Integer.parseInt(secondOperand));
            String checkAnswer = wrongAnswer(answer, result, userName);
            correctAnswerCounter = equalAnswer(answer, checkAnswer, result, correctAnswerCounter);
        }
    }
    @Override
    public void description() {
        System.out.println("Find the greatest common divisor of given numbers");
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
    public  void getAnswer(String expression) {
        System.out.println("Question : " + expression);
        System.out.print("Your Answer : ");
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
