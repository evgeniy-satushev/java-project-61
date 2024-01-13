package hexlet.code.logic;

import java.util.List;

/**
 * Данный класс использует числовые константы для передачи и взаимодействия
 * с другими методами где будут использоваться целочисленные значения.
 */
public enum Numbers {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    TEN(10),
    TWELVE(20),
    ONE_HUNDRED(100);
    private final int number;
    Numbers(final int num) {
        this.number = num;
    }

    /**
     * Предназначен для получения целочисленного представления объекта перечисления.
     * @return целочисленное представление.
     */
    public int getValue() {
        return number;
    }

    /**
     * Предназначен для получения списка всех объектов перечисления.
     * @return список всех объектов перечисления.
     */
    public static List<Numbers> getAll() {
        return List.of(ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, TEN, TWELVE, ONE_HUNDRED);
    }
}
