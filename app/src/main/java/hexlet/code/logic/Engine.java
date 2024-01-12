package hexlet.code.logic;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static org.apache.commons.lang3.math.NumberUtils.isCreatable;

/**
 * Класс "Движок" отвечает за общение с пользователем,
 * выводя результат каждого взаимодействия пользователя с игрой на экран.
 */
public class Engine {
    Engine() { }

    /**
     *  Метод взаимодействует с ответами игрока и проверяет правильность ответов выводя результат на экран,
     *  а также, если правилами игры от пользователя будет требоваться дать ответ в виде числа,
     *  то при вводе символа, не являющемся целочисленным числом, игра будет завершена.
     *  При условии, требующие от игрока дать ответ в виде строки, при неправильном ответе игра так же завершится.
     *  Метод run() напрямую завязан с утилитарными методами данного класса,
     *  которые реагируют на каждое действие игрока и каждый раз выводит результат на экран.
     * @param rounds количество раундов.
     * @param rulesAndRounds Map, содержащий в себе в виде ключа - "пример",
     *                      а в качестве значения будет - "ответ" на него.
     * @param userName представляет собой имя пользователя (игрока).
     */

    public static void run(final int rounds, final Map<String, String> rulesAndRounds, final String userName) {
        int correctAnswerCounter = 0;
        Scanner sc = new Scanner(System.in);
        for (Map.Entry<String, String> entry : rulesAndRounds.entrySet()) {
            Engine.getQuestion(entry.getKey());
            if (isCreatable(entry.getValue())) {
                String answer;
                try {
                    answer = String.valueOf(sc.nextInt());
                } catch (InputMismatchException e) {
                    Engine.showIncorrectAnswer(sc.nextLine(), entry.getValue(), userName);
                    break;
                }
                if (!answer.equals(entry.getValue())) {
                    Engine.showIncorrectAnswer(answer, entry.getValue(), userName);
                    break;
                } else {
                    correctAnswerCounter++;
                    Engine.printCorrectWord();
                }
            } else {
                String answer = sc.nextLine();
                if (!answer.equals(entry.getValue())) {
                    Engine.showIncorrectAnswer(answer, entry.getValue(), userName);
                    break;
                } else {
                    correctAnswerCounter++;
                    Engine.printCorrectWord();
                }
            }
        }
        if (correctAnswerCounter == rounds) {
            Engine.endGame(userName);
        }
    }

    /**
     * Вывод вопроса на экран.
     * @param rules вопрос, который определён в каждой игре.
     */
    public static void getRules(final String rules) {
        System.out.println(rules);
    }

    /**
     * При неправильном ответе пользователя (игрока) происходит вывод на экран
     * ответа игрока совместно с правильным результатом.
     * @param response содержит ответ пользователя (игрока).
     * @param correctAnswer содержит правильный ответ в задаче.
     * @param userName имя пользователя (игрока).
     */
    private static void showIncorrectAnswer(final String response, final String correctAnswer, final String userName) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'"
                + "\nLet's try again, %s!", response, correctAnswer, userName);
    }

    /**
     * При успешном завершении всех установленных раундов выводится поздравления игрока.
     * @param userName имя пользователя (игрока).
     */
    private static void endGame(final String userName) {
        System.out.printf("Congratulations, %s!", userName);
    }

    /**
     * Вывод на экран пример задачи и просьбы дать ответ на неё.
     * @param question пример задачи на которую нужно ответить.
     */
    private static void getQuestion(final String question) {
        System.out.printf("Question: %s\nYour Answer: ", question);
    }

    /**
     * Вывод слова Correct! на экран при даче правильного ответа.
     */
    private static void printCorrectWord() {
        System.out.println("Correct!");
    }
}
