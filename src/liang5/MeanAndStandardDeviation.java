package liang5;

    import java.util.Scanner;

    public class MeanAndStandardDeviation {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Array to store the numbers
            double[] numbers = new double[10];

            // Prompt the user to enter ten numbers
            System.out.println("Enter ten numbers:");
            for (int i = 0; i < 10; i++) {
                System.out.print("Number " + (i + 1) + ": ");
                numbers[i] = scanner.nextDouble();
            }

            // Calculate the mean
            double sum = 0;
            for (double number : numbers) {
                sum += number;
            }
            double mean = sum / numbers.length;

            // Calculate the standard deviation
            double sumOfSquares = 0;
            for (double number : numbers) {
                sumOfSquares += Math.pow(number - mean, 2);
            }
            double standardDeviation = Math.sqrt(sumOfSquares / (numbers.length - 1));

            // Display the results
            System.out.printf("Mean: %.2f%n", mean);
            System.out.printf("Standard Deviation: %.2f%n", standardDeviation);

            // Close the scanner
            scanner.close();
        }
    }


