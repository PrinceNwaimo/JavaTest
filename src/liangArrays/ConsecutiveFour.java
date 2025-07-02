package liangArrays;

import java.util.Scanner;

public class ConsecutiveFour {
    public static boolean isConsecutiveFour(int[] values) {
        for (int i = 0; i < values.length - 3; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2] && values[i] == values[i + 3]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of values: ");
        int n = scanner.nextInt();
        int[] values = new int[n];

        System.out.print("Enter the values: ");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        if (isConsecutiveFour(values)) {
            System.out.println("The list has consecutive fours");
        } else {
            System.out.println("The list has no consecutive fours");
        }
    }

}
