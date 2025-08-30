package joyceInheritance;

public class RaceHorse extends Horse{
    public final int NUMBER_OF_RACES;

    public RaceHorse(int numberOfRaces) {
        NUMBER_OF_RACES = numberOfRaces;
    }

    public int getNUMBER_OF_RACES() {
        return NUMBER_OF_RACES;
    }
}
