package joyceInheritance;

import java.util.Arrays;
import java.util.Scanner;

public class LessonWithRentalDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LessonWithRental[] lessonWithRentals = new LessonWithRental[4];

        for (int i = 0; i < lessonWithRentals.length; i++) {
            System.out.print("Enter contract number: ");
            int contractNumber = scanner.nextInt();
            System.out.print("Enter minutes: ");
            int minutes = scanner.nextInt();
            System.out.print("Enter equipment type (1-8): ");
            int equipmentType = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            lessonWithRentals[i] = new LessonWithRental(contractNumber, minutes, equipmentType);
        }

        while (true) {
            System.out.println("1. Sort by contract number");
            System.out.println("2. Sort by equipment type");
            System.out.println("3. Sort by price");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            switch (choice) {
                case 1:
                    Arrays.sort(lessonWithRentals, (a, b) -> Integer.compare(a.getContractNumber(), b.getContractNumber()));
                    break;
                case 2:
                    Arrays.sort(lessonWithRentals, (a, b) -> Integer.compare(a.getEquipmentType(), b.getEquipmentType()));
                    break;
                case 3:
                    Arrays.sort(lessonWithRentals, (a, b) -> Double.compare(a.getPrice(), b.getPrice()));
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            for (LessonWithRental lessonWithRental : lessonWithRentals) {
                System.out.println(lessonWithRental.toString());
                System.out.println();
            }
        }
    }
}
