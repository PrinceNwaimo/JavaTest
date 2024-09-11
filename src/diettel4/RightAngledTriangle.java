package diettel4;

import java.util.Scanner;

public class RightAngledTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base length of the triangle (1-10):");
        int baseLength = scanner.nextInt();

        while (baseLength < 1 || baseLength > 10) {
            System.out.println("Invalid input. Please enter a number between 1 and 10:");
            baseLength = scanner.nextInt();
        }

        for (int i = 1; i <= baseLength; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
