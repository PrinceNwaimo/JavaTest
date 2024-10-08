package diettel5;

import java.util.Scanner;

public class ModifiedDiamondPrintingProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read odd number of rows between 1 and 19
        int rows;
        do {
            System.out.print("Enter odd number of rows (1-19): ");
            rows = scanner.nextInt();
        } while (rows < 1 || rows > 19 || rows % 2 == 0);

        // Print top half of diamond
        for (int i = 0; i < rows / 2 + 1; i++) {
            // Print spaces
            for (int j = 0; j < rows / 2 - i; j++) {
                System.out.print(" ");
            }
            // Print asterisks
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Print bottom half of diamond
        for (int i = rows / 2 - 1; i >= 0; i--) {
            // Print spaces
            for (int j = 0; j < rows / 2 - i; j++) {
                System.out.print(" ");
            }
            // Print asterisks
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        scanner.close();
    }

}
