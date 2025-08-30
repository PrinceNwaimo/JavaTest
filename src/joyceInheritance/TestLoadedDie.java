package joyceInheritance;

public class TestLoadedDie {
    public static void main(String[] args) {
        int dieWinsFair = 0;
        int dieWinsLoaded = 0;

        Die die1 = new Die();
        Die die2 = new Die();
        Die die = new Die();
        LoadedDie loadedDie = new LoadedDie();

        for (int i = 0; i < 1000; i++) {
            die1.roll();
            die2.roll();
            if (die1.getValue() > die2.getValue()) {
                dieWinsFair++;
            }

            die.roll();
            loadedDie.roll();
            if (die.getValue() > loadedDie.getValue()) {
                dieWinsLoaded++;
            }
        }

        System.out.println("Die wins " + dieWinsFair + " times out of 1000 against another fair die.");
        System.out.println("Die wins " + dieWinsLoaded + " times out of 1000 against a loaded die.");
    }
}

