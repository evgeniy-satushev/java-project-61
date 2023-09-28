package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Progression extends Calc implements Engine {

    private final String description = "What number is missing in the progression?";
    private String userName;
    private final int capacity = 10;
    private int correctAnswerCounter = 0;
    private boolean cycleOperation = true;
    public void progression() {
        userName = super.welcome();
        super.description(description);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        while (super.exitGame(correctAnswerCounter, userName, cycleOperation)) {
            StringBuilder question = new StringBuilder();
            String[] numbers = new String[capacity];
            getProgression(numbers, random);
            int hiddenElement = getAnswer(question, numbers, random);
            super.showQuestion(question.toString());
            String answer = Integer.toString(scanner.nextInt()).trim();
            String checkWrongAnswer = super.showWrongAnswer(answer, hiddenElement, userName);
            correctAnswerCounter = super.equalAnswer(answer, checkWrongAnswer, hiddenElement, correctAnswerCounter);
        }
    }
    private void getProgression(String[] numbers, Random random) {
        int randomNumber = random.nextInt(3, 50);
        int step = random.nextInt(3, 9);
        int[] temp = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            randomNumber = randomNumber + step;
            temp[i] = randomNumber;
        }
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.toString(temp[i]);
        }
    }
    private int getAnswer(StringBuilder question, String[] numbers, Random random) {
        int hiddenElement = 0;
        int index = 0;
        int hideElementNumber = random.nextInt(0, 9);
        for (String element : numbers) {
            if (index == hideElementNumber) {
                hiddenElement = Integer.parseInt(element);
                element = "..";
            }
            index++;
            question.append(" ".concat(element));
        }
        return hiddenElement;
    }
}
