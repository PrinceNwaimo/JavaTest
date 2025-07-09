package liangMultiArrays;

import java.util.Arrays;

public class Sort2DArray {
    public static void main(String[] args) {
        int[][] array = {
                {4, 2},
                {1, 7},
                {4, 5},
                {1, 2},
                {1, 1},
                {4, 1}
        };

        System.out.println("Before sorting:");
        printArray(array);

        sort(array);

        System.out.println("After sorting:");
        printArray(array);
    }

    public static void sort(int m[][]) {
        Arrays.sort(m, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }

}
