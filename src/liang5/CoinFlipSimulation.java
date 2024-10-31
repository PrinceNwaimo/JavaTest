package liang5;

import java.util.Random;

public class CoinFlipSimulation {
    public static void main(String[] args) {
        int numberOfFlips = 1_000_000; // Number of coin flips
        int headsCount = 0; // Counter for heads
        int tailsCount = 0; // Counter for tails

        // Random number generator
        Random random = new Random();

        // Simulate flipping the coin
        for (int i = 0; i < numberOfFlips; i++) {
            // Generate a random number (0 or 1)
            int flip = random.nextInt(2);
            if (flip == 0) {
                headsCount++; // Increment heads count
            } else {
                tailsCount++; // Increment tails count
            }
        }

        // Display the results
        System.out.printf("Number of heads: %d%n", headsCount);
        System.out.printf("Number of tails: %d%n", tailsCount);
    }
}
