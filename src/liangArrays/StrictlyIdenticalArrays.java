package liangArrays;

import java.util.Scanner;

public class StrictlyIdenticalArrays {
    public static boolean equals(int[] list1, int[] list2) {
        if (list1.length != list2.length) {
            return false;
        }

        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != list2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter list1: ");
        int n = scanner.nextInt();
        int[] list1 = new int[n];
        for (int i = 0; i < n; i++) {
            list1[i] = scanner.nextInt();
        }

        System.out.print("Enter list2: ");
        n = scanner.nextInt();
        int[] list2 = new int[n];
        for (int i = 0; i < n; i++) {
            list2[i] = scanner.nextInt();
        }

        if (equals(list1, list2)) {
            System.out.println("Two lists are strictly identical");
        } else {
            System.out.println("Two lists are not strictly identical");
        }
    }

}
