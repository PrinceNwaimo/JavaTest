package joyceInheritance.alien;

public class Martian extends Alien{
    public Martian() {
        super(4, 2, 2);
    }

    @Override
    public String toString() {
        return "Martian: " + super.toString();
    }

}
