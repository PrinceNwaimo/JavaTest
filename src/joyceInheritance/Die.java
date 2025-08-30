package joyceInheritance;

import java.util.Random;

public class Die {
    protected int value;
    private Random random = new Random();

    public Die() {
        roll();
    }

    public void roll() {
        value = random.nextInt(6) + 1;
    }

    public int getValue() {
        return value;
    }
}
