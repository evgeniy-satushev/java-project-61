package hexlet.code.games;

import hexlet.code.logic.Creatable;
import hexlet.code.logic.Engine;
import hexlet.code.logic.Numbers;
import hexlet.code.logic.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Игра "Проверка на чётность" заключается в том, что бы дать ответ - является ли данное число
 * чётным или нет.
 * Пример:
 *      Answer 'yes' if the number is even, otherwise answer 'no'.
 *      Question: 26
 *      Your Answer: yes
 *      Correct!
 */
public class Even implements Creatable {

    // имя пользователя (игрока) передаваемое через параметры конструктора.
    private final String userName;
    // количество раундов, настраиваемых через параметры конструктора.
    private final int rounds;

    /**
     * Конструктор принимает только имя пользователя и количество раундов.
     * @param name имя пользователя (игрока).
     * @param numberOfRounds количество раундов.
     */
    public Even(final String name, final int numberOfRounds) {
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
    public void evenNumber() {
        Map<String, Object> rulesAndRounds = fill();
        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.getRules(rules);
        Engine.run(rounds, rulesAndRounds, userName);
    }

    /**
     * Данный метод генерирует число, проверяет его на чётность и сохраняет корректный результат.
     * Переопределённый метод интерфейса Creatable является индивидуальным
     * для каждой новой создаваемой игры.
     * В зависимости от количество раундов, происходит генерация примеров - "ключей"
     * и ответов на эти примеры - "значений", хранящиеся в Map.
     * @return Мар, содержащий в себе примеры - "ключи" и ответы - "значения".
     */
    @Override
    public Map<String, Object> fill() {
        Map<String, Object> temp = new HashMap<>();
        Predicate<Integer> condition = Utils::isEvenNumber;
        while (temp.size() < rounds) {
            int number = Utils.generate(Numbers.ONE_HUNDRED.getValue());
            temp.put(String.valueOf(number), condition.test(number) ? "yes" : "no");
        }
        return temp;
    }
}
