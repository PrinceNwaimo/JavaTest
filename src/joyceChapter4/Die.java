package joyceChapter4;

public class Die {
    private static final int LOWEST_DIE_VALUE = 1;
    private static final int HIGHEST_DIE_VALUE = 6;
    private int value;

    public Die() {
        value = (int)(Math.random() * HIGHEST_DIE_VALUE) + LOWEST_DIE_VALUE;
    }

    public int getValue() {
        return value;
    }
}
