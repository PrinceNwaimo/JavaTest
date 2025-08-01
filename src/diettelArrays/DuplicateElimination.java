package diettelArrays;

import java.util.Scanner;

public class DuplicateElimination {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = -1;
        }

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter a number between 10 and 100: ");
            int number = scanner.nextInt();
            while (number < 10 || number > 100) {
                System.out.println("Number is out of range. Please enter a number between 10 and 100.");
                number = scanner.nextInt();
            }
            numbers[i] = number;
        }

        System.out.println("Original numbers:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // Remove duplicates
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != -1) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[j] == numbers[i]) {
                        numbers[j] = -1;
                    }
                }
            }
        }

        System.out.println("Numbers without duplicates:");
        for (int number : numbers) {
            if (number != -1) {
                System.out.print(number + " ");
            }
        }
    }

}
