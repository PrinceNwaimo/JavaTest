package liangMultiArrays;

import java.util.Arrays;
import java.util.Scanner;

public class IdenticalArrays {
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
            System.out.println("The two arrays are identical");
        } else {
            System.out.println("The two arrays are not identical");
        }
    }

    public static boolean equals(int[][] m1, int[][] m2) {
        int[] flatM1 = flatten(m1);
        int[] flatM2 = flatten(m2);

        Arrays.sort(flatM1);
        Arrays.sort(flatM2);

        return Arrays.equals(flatM1, flatM2);
    }

    public static int[] flatten(int[][] m) {
        int[] flat = new int[m.length * m[0].length];
        int index = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                flat[index++] = m[i][j];
            }
        }
        return flat;
    }

}
