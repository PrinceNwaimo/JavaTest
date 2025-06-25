package joyceArrays;

import java.util.Random;

public class DrugTests2 {
    public static void main(String[] args) {
        int[] employees = new int[100];
        int[] selectionCount = new int[100];
        Random random = new Random();

        for (int week = 0; week < 52; week++) {
            int selectedEmployee = random.nextInt(100);
            selectionCount[selectedEmployee]++;
        }

        System.out.println("Employee selection count:");
        for (int i = 0; i < 100; i++) {
            if (selectionCount[i] > 0) {
                System.out.println("Employee " + (i + 1) + ": " + selectionCount[i] + " times");
            }
        }

        System.out.println("Employees who were never selected:");
        for (int i = 0; i < 100; i++) {
            if (selectionCount[i] == 0) {
                System.out.println("Employee " + (i + 1));
            }
        }
    }

}
