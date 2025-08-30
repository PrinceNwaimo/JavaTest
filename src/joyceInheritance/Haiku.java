package joyceInheritance;

public class Haiku extends Poem{
    private static final int LINES = 3;

    public Haiku(String title) {
        super(title, LINES);
    }
}
