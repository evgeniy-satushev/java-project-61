package hexlet.code.games;

import hexlet.code.logic.Creatable;
import hexlet.code.logic.Engine;
import hexlet.code.logic.Numbers;
import hexlet.code.logic.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Игра "Прогрессия" генерирует числовую прогрессию с фиксированным шагом
 * и заменяя один из случайных значений в ней на "..", предлагая пользователю (игроку)
 * отгадать значение вместо двоеточий.
 * Пример:
 *      Answer: What number is missing in the progression?.
 *      Question: 14 28 46 92 .. 368
 *      Your Answer: 184
 *      Correct!
 */
public class Progression implements Creatable {

    // имя пользователя (игрока) передаваемое через параметры конструктора.
    private final String userName;
    // количество раундов, настраиваемых через параметры конструктора.
    private final int rounds;

    /**
     * Конструктор принимает только имя пользователя и количество раундов.
     * @param name имя пользователя (игрока).
     * @param numberOfRounds количество раундов.
     */
    public Progression(final String name, final int numberOfRounds) {
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
    public void progression() {
        Map<String, Object> rulesAndRounds = fill();
        String rules = "What number is missing in the progression?";
        Engine.getRules(rules);
        Engine.run(rounds, rulesAndRounds, userName);
    }

    /**
     * Данный метод генерирует числовую прогрессию с одним спрятанным значением и
     * имеющий вид "..", так же, в качестве корректного ответа вместо ".." он сохраняется.
     * Переопределённый метод интерфейса Creatable является индивидуальным
     * для каждой новой создаваемой игры.
     * В зависимости от количество раундов, происходит генерация примеров - "ключей"
     * и ответов на эти примеры - "значений", хранящиеся в Map.
     * @return Мар, содержащий в себе примеры - "ключи" и ответы - "значения".
     */
    @Override
    public Map<String, Object> fill() {
        Map<String, Object> temp = new HashMap<>();
        while (temp.size() < rounds) {
            String progression = getProgression();
            String modifiedProgression = getProgressionWinHiddenElement(progression);
            temp.put(modifiedProgression, getHiddenElement(progression, modifiedProgression));
        }
        return temp;
    }

    /**
     * Предназначен только для генерации числовой последовательности с неизменным шагом.
     * @return числовую прогрессию в виде строки.
     */
    private String getProgression() {
        List<String> keys = new ArrayList<>();
        int number = Utils.generate(Numbers.TWELVE.getValue());
        int step = Utils.generate(Numbers.TEN.getValue());
        int length = Utils.generate(Numbers.FIVE.getValue(), Numbers.TEN.getValue());
        for (int i = 0; i < length; i++) {
            number += step;
            keys.add(String.valueOf(number));
        }
        return String.join(" ", keys);
    }

    /**
     * Создаёт новую прогрессию с произвольно одним "спрятанным" элементом на основе
     * переданной числовой прогрессии в виде строки.
     * @param progression числовая прогрессия в виде строки.
     * @return прогрессию с одним "спрятанным" в произвольном порядке элементом.
     */
    private String getProgressionWinHiddenElement(final String progression) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        int hide = Utils.generate((progression.length() / Numbers.THREE.getValue()));
        for (String number : progression.split(" ")) {
            if (index == hide) {
                stringBuilder
                        .append("..")
                        .append(" ");
            } else {
                stringBuilder
                        .append(number)
                        .append(" ");
            }
            index++;
        }
        return stringBuilder.toString().trim();
    }

    /**
     * Находит и возвращает значение которое было заменено в числовой последовательности.
     * @param progression числовая прогрессия в виде строки.
     * @param modifiedProgression прогрессия с одним "спрятанным" в произвольном порядке элементом.
     * @return элемент, который был спрятан в числовой прогрессии.
     */
    private String getHiddenElement(final String progression, final String modifiedProgression) {
        String[] temp = modifiedProgression.split(" ");
        int index = 0;
        for (String number : progression.split(" ")) {
            if (!temp[index++].equals(number)) {
                return number;
            }
        }
        return "";
    }
}
