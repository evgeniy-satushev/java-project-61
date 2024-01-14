package hexlet.code.games;

import hexlet.code.logic.Creatable;
import hexlet.code.logic.Engine;
import hexlet.code.logic.Numbers;
import hexlet.code.logic.Utils;
import org.apache.commons.math3.primes.Primes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * игра "Простые числа" заключается в том, что бы дать ответ - является ли данное число
 * простым или нет.
 * Пример:
 *      Answer: Answer 'yes' if given number is prime. Otherwise answer 'no'.
 *      Question: 19
 *      Your Answer: yes
 *      Correct!
 */
public class Prime implements Creatable {

    // имя пользователя (игрока) передаваемое через параметры конструктора.
    private final String userName;
    // количество раундов, настраиваемых через параметры конструктора.
    private final int rounds;

    /**
     * Конструктор принимает только имя пользователя и количество раундов.
     * @param name имя пользователя (игрока).
     * @param numberOfRounds количество раундов.
     */
    public Prime(final String name, final int numberOfRounds) {
        this.userName = name;
        this.rounds = numberOfRounds;
    }

    /**
     * Метод evenNumber() представляет окончательную сборку игры и последующий запуск её при вызове.
     * Метод подразделяет структуру в себе в виде Map, содержащую выражение (вопрос) как ключ
     * и ответ в виде значения Мар, далее выводится на экран условие, после чего Мар передаётся в
     * метод run(rounds, rulesAndRounds, userName) и запускает игру.
     * @see Engine
     */
    public void primeNumbers() {
        Map<String, Object> rulesAndRounds = fill();
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine.getRules(rules);
        Engine.run(rounds, rulesAndRounds, userName);
    }

    /**
     * Данный метод генерирует число, проверяет является ли число простым или нет.
     * Переопределённый метод интерфейса Creatable является индивидуальным
     * для каждой новой создаваемой игры.
     * В зависимости от количество раундов, происходит генерация примеров - "ключей"
     * и ответов на эти примеры - "значений", хранящиеся в Map.
     * @return Мар, содержащий в себе примеры - "ключи" и ответы - "значения".
     */
    @Override
    public Map<String, Object> fill() {
        Map<String, Object> temp = new HashMap<>();
        final Predicate<Integer> condition = Primes::isPrime;
        while (temp.size() < rounds) {
            int number = Utils.generate(Numbers.ONE_HUNDRED.getValue());
            temp.put(String.valueOf(number), condition.test(number) ? "yes" : "no");
        }
        return temp;
    }
}
