package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.math3.primes.Primes;

import java.util.Random;
import java.util.Scanner;

public class Prime extends Even implements Engine {
    private final String description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private String userName;
    public void primeNumbers() {
        int correctAnswerCounter = 0;
        boolean cycleOperation = true;
        userName = super.welcome();
        super.description(description);
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        while (super.exitGame(correctAnswerCounter, userName, cycleOperation)) {
            int randomNumber = random.nextInt(50);
            super.showQuestion(Integer.toString(randomNumber));
            String answer = sc.nextLine().trim();
            String checkWrongAnswer = showWrongAnswer(answer, randomNumber);
            correctAnswerCounter = super.equalAnswer(answer, checkWrongAnswer, randomNumber, correctAnswerCounter);
        }
    }
    public String showWrongAnswer(String answer, int result) {
        String correctAnswer = Primes.isPrime(result) ? "'yes'." : "'no'.";
        return "'" + answer + "'"
                .concat(" is wrong answer ;(. Correct answer was ")
                .concat(correctAnswer) + "\n"
                .concat("Let's try again ") + this.userName;
    }
    @Override
    public boolean checkAnswer(String answer, int result) {
        if (Primes.isPrime(result) && "yes".equalsIgnoreCase(answer)) {
            return true;
        } else {
            return !(Primes.isPrime(result)) && "no".equalsIgnoreCase(answer);
        }
    }
}
