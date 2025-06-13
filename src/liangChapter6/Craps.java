package liangChapter6;

import java.util.Random;

public class Craps {
    public static void main(String[] args) {
        Random random = new Random();
        int roll1 = random.nextInt(6) + 1;
        int roll2 = random.nextInt(6) + 1;
        int sum = roll1 + roll2;

        System.out.println("You rolled " + roll1 + " + " + roll2 + " = " + sum);

        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("You lose");
        } else if (sum == 7 || sum == 11) {
            System.out.println("You win");
        } else {
            System.out.println("point is " + sum);
            int point = sum;
            boolean win = false;

            while (true) {
                roll1 = random.nextInt(6) + 1;
                roll2 = random.nextInt(6) + 1;
                sum = roll1 + roll2;
                System.out.println("You rolled " + roll1 + " + " + roll2 + " = " + sum);

                if (sum == point) {
                    win = true;
                    break;
                } else if (sum == 7) {
                    break;
                }
            }

            if (win) {
                System.out.println("You win");
            } else {
                System.out.println("You lose");
            }
        }
    }

}
