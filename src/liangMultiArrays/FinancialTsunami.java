package liangMultiArrays;

import java.util.Scanner;

public class FinancialTsunami {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of banks and the limit: ");
        int n = scanner.nextInt();
        double limit = scanner.nextDouble();

        double[] balance = new double[n];
        double[][] borrowers = new double[n][n];

        // Read bank information
        for (int i = 0; i < n; i++) {
            balance[i] = scanner.nextDouble();
            int count = scanner.nextInt();
            for (int j = 0; j < count; j++) {
                int borrower = scanner.nextInt();
                double amount = scanner.nextDouble();
                borrowers[i][borrower] = amount;
            }
        }

        // Find unsafe banks
        boolean[] unsafe = new boolean[n];
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < n; i++) {
                if (!unsafe[i]) {
                    double totalAssets = balance[i];
                    for (int j = 0; j < n; j++) {
                        totalAssets += borrowers[j][i];
                    }
                    if (totalAssets < limit) {
                        unsafe[i] = true;
                        changed = true;
                        for (int j = 0; j < n; j++) {
                            borrowers[i][j] = 0;
                        }
                    }
                }
            }
        }

        // Print unsafe banks
        System.out.print("Unsafe banks are ");
        boolean first = true;
        for (int i = 0; i < n; i++) {
            if (unsafe[i]) {
                if (first) {
                    System.out.print(i);
                    first = false;
                } else {
                    System.out.print(" " + i);
                }
            }
        }
    }

}
