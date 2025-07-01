package liangArrays;

import java.util.Random;

public class RandomNumberChooser {
    public static int getRandom(int... numbers) {
        Random random = new Random();
        while (true) {
            int randomNumber = random.nextInt(54) + 1; // Generate a random number between 1 and 54
            boolean isExcluded = false;
            for (int excludedNumber : numbers) {
                if (randomNumber == excludedNumber) {
                    isExcluded = true;
                    break;
                }
            }
            if (!isExcluded) {
                return randomNumber;
            }
        }
    }

    public static void main(String[] args) {
        int randomNumber = getRandom(1, 2, 3, 4, 5);
        System.out.println("Random number: " + randomNumber);
    }

}
