package hexlet.code.games;

import hexlet.code.logic.Creatable;
import hexlet.code.logic.Engine;
import hexlet.code.logic.Numbers;
import hexlet.code.logic.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Игра "Наибольший общий делитель" будет требовать от пользователя
 * посчитать "НОД" между двумя случайно-сгенерированными числами.
 * Пример:
 *      Answer: Find the greatest common divisor of given numbers.
 *      Question: 14 7
 *      Your Answer: 7
 *      Correct!
 */
public class Gcd implements Creatable {

    // имя пользователя (игрока) передаваемое через параметры конструктора.
    private final String userName;
    // количество раундов, настраиваемых через параметры конструктора.
    private final int rounds;

    /**
     * Конструктор принимает только имя пользователя и количество раундов.
     * @param name имя пользователя (игрока).
     * @param numberOfRounds количество раундов.
     */
    public Gcd(final String name, final int numberOfRounds) {
        this.userName = name;
        this.rounds = numberOfRounds;
    }

    /**
     * Метод calc() представляет окончательную сборку игры и последующий запуск её при вызове.
     * Метод подразделяет структуру в себе в виде Map, содержащую выражение (вопрос) как ключ
     * и ответ в виде значения Мар, далее выводится на экран условие, после чего Мар передаётся в
     * метод run(rounds, rulesAndRounds, userName) и запускает игру.
     * @see Engine
     */

    public void greatestCommonDiv() {
        Map<String, String> rulesAndRounds = fill();
        String rules = "Find the greatest common divisor of given numbers.";
        Engine.getRules(rules);
        Engine.run(rounds, rulesAndRounds, userName);
    }

    /**
     * Метод fill() генерирует два произвольных числа и находит их наибольший общий делитель.
     * Переопределённый метод интерфейса Creatable является индивидуальным
     * для каждой новой создаваемой игры.
     * В зависимости от количество раундов, происходит генерация примеров - "ключей"
     * и ответов на эти примеры - "значений", хранящиеся в Map.
     * @return Мар, содержащий в себе примеры - "ключи" и ответы - "значения".
     */
    @Override
    public Map<String, String> fill() {
        Map<String, String> rulesAndRounds = new HashMap<>();
        while (rulesAndRounds.size() < rounds) {
            int x = Utils.generate(Numbers.ONE_HUNDRED.getValue());
            int y = Utils.generate(Numbers.ONE_HUNDRED.getValue());
            String question =  x + " " + y;
            String correctAnswer = String.valueOf(gcdByEuclidAlgorithm(x, y));
            rulesAndRounds.put(question, correctAnswer);
        }
        return rulesAndRounds;
    }

    /**
     * Рекурсивный метод по нахождению наибольшего общего делителя.
     * @param x случайно-сгенерированное значение.
     * @param y случайно-сгенерированное значение.
     * @return наибольший общий делитель двух передаваемых значений.
     */
    private int gcdByEuclidAlgorithm(int x, int y) {
        if (y == Numbers.ZERO.getValue()) {
            return x;
        }
        return gcdByEuclidAlgorithm(y, x % y);
    }
}
