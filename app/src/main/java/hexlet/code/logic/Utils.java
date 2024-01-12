package hexlet.code.logic;

import java.util.Random;

/**
 * Утилитарный класс "Утилиты" может содержать в себе методы
 * для упрощения написания логики игр.
 */
public class Utils {
    Utils() { }

    /**
     * Генерирует случайное число в переделах заданных в параметрах значений минимума до максимума.
     * @param min минимальное значение.
     * @param max максимальное значение.
     * @return случайно-сгенерированное число.
     */
    public static int generate(final int min, final int max) {
        return new Random().nextInt(min, max);
    }

    /**
     * Перегруженный метод generate, которой на вход принимает только один параметр.
     * @param number максимальное значение.
     * @return случайно-сгенерированное число.
     */
    public static int generate(final int number) {
        return generate(Numbers.ONE.getValue(), number);
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
