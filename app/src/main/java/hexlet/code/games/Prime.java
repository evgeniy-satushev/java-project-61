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
     * @param userName имя пользователя (игрока).
     * @param rounds количество раундов.
     */
    public Prime(final String userName, int rounds) {
        this.userName = userName;
        this.rounds = rounds;
    }

    /**
     * Метод evenNumber() представляет окончательную сборку игры и последующий запуск её при вызове.
     * Метод подразделяет структуру в себе в виде Map, содержащую выражение (вопрос) как ключ
     * и ответ в виде значения Мар, далее выводится на экран условие, после чего Мар передаётся в
     * метод run(rounds, rulesAndRounds, userName) и запускает игру.
     * @see Engine
     */
    public void primeNumbers() {
        Map<String, String> rulesAndRounds = fill();
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
    public Map<String, String> fill() {
        Map<String, String> temp = new HashMap<>();
        final Predicate<Integer> condition = Primes::isPrime;
        while (temp.size() < rounds) {
            int number = Utils.generate(Numbers.ONE_HUNDRED.getValue());
            temp.put(String.valueOf(number), condition.test(number) ? "yes" : "no");
        }
        return temp;
    }
}
