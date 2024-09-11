package diettel4;

import java.util.Scanner;

public class SumReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a target sum:");
        int targetSum = scanner.nextInt();

        int currentSum = 0;

        while (currentSum < targetSum) {
            System.out.println("Enter an integer:");
            int number = scanner.nextInt();
            currentSum += number;
        }

        System.out.println("Sum reached or exceeded: " + currentSum);
    }

}
