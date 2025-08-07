package joyceTwoDimensionalArrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SalespersonSort {
    public static void main(String[] args) {
        Salesperson[] salespeople = new Salesperson[7];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 7; i++) {
            salespeople[i] = new Salesperson();
            System.out.println("Enter details for Salesperson " + (i + 1));
            System.out.print("ID: ");
            salespeople[i].setId(scanner.nextInt());
            System.out.print("Sales: ");
            salespeople[i].setSales(scanner.nextDouble());
            scanner.nextLine(); // Consume newline left-over
        }

        System.out.println("Enter the field to sort by:");
        System.out.println("1. ID");
        System.out.println("2. Sales");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        switch (choice) {
            case 1:
                Arrays.sort(salespeople, Comparator.comparingInt(Salesperson::getId));
                break;
            case 2:
                Arrays.sort(salespeople, Comparator.comparingDouble(Salesperson::getSales));
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println("Sorted Salespeople:");
        for (Salesperson salesperson : salespeople) {
            System.out.println(salesperson);
        }
    }

}
