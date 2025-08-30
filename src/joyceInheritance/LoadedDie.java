package joyceInheritance;

import java.util.Random;

public class LoadedDie extends Die{
    private Random random = new Random();

    @Override
    public void roll() {
        value = random.nextInt(5) + 2; // generates a random number between 2 and 6
    }
}
