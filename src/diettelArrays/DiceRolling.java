package diettelArrays;

import java.util.Random;

public class DiceRolling {
    public static void main(String[] args) {
        Random random = new Random();
        int[] sums = new int[11]; // Possible sums are 2-12, so array size is 11

        // Roll the dice 36,000,000 times
        for (int i = 0; i < 36000000; i++) {
            int die1 = random.nextInt(6) + 1; // Roll the first die
            int die2 = random.nextInt(6) + 1; // Roll the second die
            int sum = die1 + die2;
            sums[sum - 2]++; // Increment the count for the sum
        }

        // Display the results
        System.out.println("Sum\tFrequency");
        for (int i = 0; i < sums.length; i++) {
            System.out.println((i + 2) + "\t" + sums[i]);
        }
    }

}
