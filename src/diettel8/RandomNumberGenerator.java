package diettel8;

import java.security.SecureRandom;
import java.util.Scanner;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        System.out.print("Enter the number of random numbers to generate: ");
        int n = scanner.nextInt();

        System.out.println("Random numbers between 10 and 100:");
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(91) + 10; // Generates numbers between 10 and 100
            System.out.println(randomNumber);
        }
    }
}
