package hexlet.code.games;

import hexlet.code.logic.Creatable;
import hexlet.code.logic.Engine;
import hexlet.code.logic.Numbers;
import hexlet.code.logic.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

/**
 * Игра "Калькулятор" представляет собой произвольное выражение двух случайно-сгенерированных числе,
 * на которое требуется дать ответ.
 * Пример:
 *      Answer: What is the result of the expression?
 *      Question: 11 * 11
 *      Your Answer: 121
 *      Correct!
 */
public class Calc implements Creatable {

    //имя пользователя (игрока) передаваемое через параметры конструктора.
    private final String userName;
    // количество раундов, настраиваемых через параметры конструктора.
    private final int rounds;
    // список операторов.
    private final List<String> operators = List.of("+", "-", "*");

    /**
     * Конструктор принимает только имя пользователя и количество раундов.
     * @param name пользователя (игрока).
     * @param numberOfRounds количество раундов.
     */
    public Calc(final String name, final int numberOfRounds) {
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
    public void calc() {
        Map<String, Object> rulesAndRounds = fill();
        String rules = "What is the result of the expression?";
        Engine.getRules(rules);
        Engine.run(rounds, rulesAndRounds, userName);
    }

    /**
     * Метод fill() генерирует операции (сложения, вычитания или умножения) в зависимости от
     * случайно-сгенерированных операторов, содержащихся в списке operators.
     * Переопределённый метод интерфейса Creatable является индивидуальным
     * для каждой новой создаваемой игры.
     * В зависимости от количество раундов, происходит генерация примеров - "ключей"
     * и ответов на эти примеры - "значений", хранящиеся в Map.
     * @return Мар, содержащий в себе примеры - "ключи" и ответы - "значения".
     */
    @Override
    public Map<String, Object> fill() {
        Map<String, Object> rulesAndRounds = new HashMap<>();
        while (rulesAndRounds.size() < rounds) {
            int x = Utils.generate(Numbers.TWELVE.getValue());
            int y = Utils.generate(Numbers.TWELVE.getValue());
            String operator = operators.get(Utils.generate(Numbers.ZERO.getValue(), rounds));
            String question =  x + " " + operator + " " + y;
            rulesAndRounds.put(question, getCorrectAnswer(x, y, operator, String::equals));
        }
        return rulesAndRounds;
    }

    /**
     * В зависимости от принимаемого знака оператора реализует операцию (сложения, вычитания, умножения).
     * @param x случайно-сгенерированное число.
     * @param y случайно-сгенерированное число.
     * @param operator произвольный оператор из списка List<String> operators.
     * @param condition функциональный интерфейс, задающий логику проверки операторов,
     *                 для определения числовой операции.
     * @return в зависимости от сработанного условия (сумма, разность, умножение) чисел в виде строки.
     */
    private String getCorrectAnswer(int x, int y, String operator, BiPredicate<String, String> condition) {
        if (condition.test("+", operator)) {
            return String.valueOf(x + y);
        }
        return condition.test("*", operator) ? String.valueOf(x * y) : String.valueOf(x - y);
    }
}
