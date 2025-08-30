package joyceInheritance.alien;

public class Jupiterian extends Alien{
    public Jupiterian() {
        super(2, 4, 3);
    }

    @Override
    public String toString() {
        return "Jupiterian: " + super.toString();
    }
}
