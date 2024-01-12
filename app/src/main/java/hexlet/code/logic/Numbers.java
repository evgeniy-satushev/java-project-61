package hexlet.code.logic;

public enum Numbers {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    TEN(10),
    TWELVE(20),
    ONE_HUNDRED(100)
    ;
    private final int number;
    Numbers(final int number) {
        this.number = number;
    }
    public int getValue() {
        return number;
    }
}
