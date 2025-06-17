package makingAdifference;

import java.security.SecureRandom;
import java.util.Scanner;

public class MultiplicationCAI {
    private static SecureRandom random = new SecureRandom();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            askQuestion();
        }
    }

    public static void askQuestion() {
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);

        while (true) {
            System.out.printf("How much is %d times %d?%n", num1, num2);
            int answer = scanner.nextInt();

            if (answer == num1 * num2) {
                System.out.println("Very good!");
                break;
            } else {
                System.out.println("No. Please try again.");
            }
        }

    }
}