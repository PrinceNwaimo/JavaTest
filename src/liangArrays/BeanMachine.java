package liangArrays;

import java.util.Random;
import java.util.Scanner;

public class BeanMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the number of balls to drop: ");
        int numBalls = scanner.nextInt();

        System.out.print("Enter the number of slots in the bean machine: ");
        int numSlots = scanner.nextInt();

        int[] slots = new int[numSlots];

        for (int i = 0; i < numBalls; i++) {
            StringBuilder path = new StringBuilder();
            int position = 0;
            for (int j = 0; j < numSlots - 1; j++) {
                if (random.nextBoolean()) {
                    path.append("R");
                    position++;
                } else {
                    path.append("L");
                }
            }
            System.out.println(path.toString());
            slots[position]++;
        }

        // Print histogram
        int maxHeight = findMax(slots);
        for (int i = maxHeight; i > 0; i--) {
            for (int j = 0; j < numSlots; j++) {
                if (slots[j] >= i) {
                    System.out.print("O ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < numSlots; i++) {
            System.out.print("--");
        }
        System.out.println();
    }

    private static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

}
