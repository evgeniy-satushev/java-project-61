package hexlet.code.logic;

import java.util.Random;

/**
 * Утилитарный класс "Утилиты" может содержать в себе методы
 * для упрощения написания логики игр.
 */
public class Utils {
    Utils() { }
    /**
     * Генерирует случайное число в переделах, установленными параметрами метода,
     * такие как "минимальное значение" и "максимальное значение".
     * @param min ограничение генерации числа по низу.
     * @param max ограничение генерации числа по верху.
     * @return случайно-сгенерированное число.
     */
    public static int generate(final int min, final int max) {
        return new Random().nextInt(min, max);
    }

    /**
     * Проверка числа на чётность.
     * @param number проверяемое число.
     * @return булево значение проверяемого числа.
     */
    public static boolean isEvenNumber(final int number) {
        return number % 2 == 0;
    }

}
