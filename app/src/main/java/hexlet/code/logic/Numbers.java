package hexlet.code.logic;

import java.util.List;

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
    Numbers(final int number) {
        this.number = number;
    }
    private final int number;
    public int getValue() {
        return number;
    }
    public static List<Numbers> getAll() {
        return List.of(ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, TEN, TWELVE, ONE_HUNDRED);
    }
}
