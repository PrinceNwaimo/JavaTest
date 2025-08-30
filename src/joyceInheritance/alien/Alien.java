package joyceInheritance.alien;

public class Alien {
    protected int eyes;
    protected int arms;
    protected int legs;

    public Alien(int eyes, int arms, int legs) {
        this.eyes = eyes;
        this.arms = arms;
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "Alien has " + eyes + " eyes, " + arms + " arms, and " + legs + " legs.";
    }
}
