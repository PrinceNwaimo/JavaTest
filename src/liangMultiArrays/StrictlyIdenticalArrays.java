package liangMultiArrays;

import java.util.Scanner;

public class StrictlyIdenticalArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];

        System.out.println("Enter list1:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter list2:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m2[i][j] = scanner.nextInt();
            }
        }

        if (equals(m1, m2)) {
            System.out.println("The two arrays are strictly identical");
        } else {
            System.out.println("The two arrays are not strictly identical");
        }
    }

    public static boolean equals(int[][] m1, int[][] m2) {
        if (m1.length != m2.length) {
            return false;
        }

        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length) {
                return false;
            }
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

}
