package joyceChapter5;

public class TwoDice2 {
    public static void main(String[] args) {

        Die die1 = new Die();
        Die die2 = new Die();


        die1.roll();
        die2.roll();


        System.out.println("Die 1: " + die1.getValue());
        System.out.println("Die 2: " + die2.getValue());


        if (die1.getValue() == die2.getValue()) {
            System.out.println("The dice are the same.");
        } else if (die1.getValue() > die2.getValue()) {
            System.out.println("Die 1 has a higher value.");
        } else {
            System.out.println("Die 2 has a higher value.");
        }
    }

}
