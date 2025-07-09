package liangMultiArrays;

import java.util.Scanner;

public class MarkovMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matrix = new double[3][3];

        System.out.println("Enter a 3-by-3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        if (isMarkovMatrix(matrix)) {
            System.out.println("It is a Markov matrix");
        } else {
            System.out.println("It is not a Markov matrix");
        }
    }

    public static boolean isMarkovMatrix(double[][] m) {
        // Check if each element is positive
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] <= 0) {
                    return false;
                }
            }
        }

        // Check if the sum of the elements in each column is 1
        for (int j = 0; j < m[0].length; j++) {
            double sum = 0;
            for (int i = 0; i < m.length; i++) {
                sum += m[i][j];
            }
            if (Math.abs(sum - 1) > 0.00001) {
                return false;
            }
        }

        return true;
    }

}
