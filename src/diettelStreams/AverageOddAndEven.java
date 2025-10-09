package diettelStreams;
import java.util.Random;

public class AverageOddAndEven {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[10];
        int oddCount = 0;
        int evenCount = 0;
        double sumAll = 0;
        double sumOdd = 0;
        double sumEven = 0;

        // Generate random numbers and calculate sums
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1001);
            sumAll += numbers[i];
            if (numbers[i] % 2 == 0) {
                evenCount++;
                sumEven += numbers[i];
            } else {
                oddCount++;
                sumOdd += numbers[i];
            }
        }

        // Calculate averages
        double averageAll = sumAll / numbers.length;
        double averageOdd = oddCount > 0 ? sumOdd / oddCount : 0;
        double averageEven = evenCount > 0 ? sumEven / evenCount : 0;

        // Display results
        System.out.println("Numbers: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("\nOdd count: " + oddCount);
        System.out.println("Even count: " + evenCount);
        System.out.printf("Average of all numbers: %.2f\n", averageAll);
        System.out.printf("Average of odd numbers: %.2f\n", averageOdd);
        System.out.printf("Average of even numbers: %.2f\n", averageEven);
    }
}
