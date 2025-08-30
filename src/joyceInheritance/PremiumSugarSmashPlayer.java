package joyceInheritance;

public class PremiumSugarSmashPlayer extends SugarSmashPlayer{
    private static final int NUM_LEVELS = 50;

    public PremiumSugarSmashPlayer(int id, String screenName) {
        super(id, screenName, NUM_LEVELS);
    }
}
