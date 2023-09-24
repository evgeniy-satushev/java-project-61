package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Even implements Engine {
    public void evenNumbers() {
        String userName = Engine.welcome();
        description();
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int correctAnswerCounter = 0;
        boolean cycleOperation = true;
        while (exitGame(correctAnswerCounter, userName, cycleOperation)) {
            int randomNumber = random.nextInt(10, 100);
            getAnswer(Integer.toString(randomNumber));
            String answer = sc.nextLine().trim();
            String checkWrongAnswer = wrongAnswer(answer, randomNumber, userName);
            correctAnswerCounter = equalAnswer(answer, checkWrongAnswer, randomNumber, correctAnswerCounter);
        }
    }

    @Override
    public void description() {
        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        System.out.println(rules);
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
        if (result % 2 == 0 && "yes".equalsIgnoreCase(answer)) {
            System.out.println("Correct!");
            correctAnswerCounter++;
        } else if (result % 2 != 0 && "no".equalsIgnoreCase(answer)) {
            System.out.println("Correct!");
            correctAnswerCounter++;
        } else {
            correctAnswerCounter = 0;
            System.out.println(wrongAnswer);
        }
        return correctAnswerCounter;
    }

    @Override
    public void getAnswer(String expression) {
        System.out.println("Question : " + expression);
        System.out.print("Your Answer : ");
    }

    public String wrongAnswer(String answer, int result, String userName) {
        String correctAnswer = result % 2 == 0 ? "'yes'." : "'no'.";
        return "'" + answer + "'"
                .concat(" is wrong answer ;(. Correct answer was ")
                .concat(correctAnswer) + "\n"
                .concat(" try again ") + userName;
    }
}
