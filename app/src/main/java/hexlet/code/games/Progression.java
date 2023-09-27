package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Progression extends Calc implements Engine {

    public void progression() {
        int capacity = 10;
        int correctAnswerCounter = 0;
        boolean cycleOperation = true;
        String answer;
        String checkWrongAnswer;
        String description = "What number is missing in the progression?";
        String userName = Cli.welcome();
        super.description(description);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        while (super.exitGame(correctAnswerCounter, userName, cycleOperation)) {
            //*********
            int hiddenElement = 0;
            int index = 0;
            int hideElementNumber = random.nextInt(0, 9);
            //*********
            StringBuilder question = new StringBuilder();
            String[] numbers = new String[capacity];
            getProgression(numbers, random);
            //*********
            for (String element : numbers) {
                if (index == hideElementNumber) {
                    hiddenElement = Integer.parseInt(element);
                    element = "..";
                }
                index++;
                question.append(" ".concat(element));
            }
            //*********
            super.showQuestion(question.toString());
            answer = Integer.toString(scanner.nextInt()).trim();
            checkWrongAnswer = super.showWrongAnswer(answer, hiddenElement, userName);
            correctAnswerCounter = super.equalAnswer(answer, checkWrongAnswer, hiddenElement, correctAnswerCounter);
        }
    }
    private void getProgression(String[] numbers, Random random) {
        int randomNumber = random.nextInt(3, 100);
        int step = random.nextInt(3, 30);
        int[] temp = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            randomNumber = randomNumber + step;
            temp[i] = randomNumber;
        }
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.toString(temp[i]);
        }
    }
}
