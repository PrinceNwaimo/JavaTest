package joyceTwoDimensionalArrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SalespersonDatabase {
    private static final int MAX_RECORDS = 20;
    private static final Salesperson2[] database = new Salesperson2[MAX_RECORDS];
    private static int count = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add a record");
            System.out.println("2. Delete a record");
            System.out.println("3. Change a record");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    addRecord();
                    break;
                case 2:
                    deleteRecord();
                    break;
                case 3:
                    changeRecord();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }

            displayDatabase();
        }
    }

    private static void addRecord() {
        if (count == MAX_RECORDS) {
            System.out.println("Database is full");
            return;
        }

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (int i = 0; i < count; i++) {
            if (database[i].getId() == id) {
                System.out.println("ID already exists");
                return;
            }
        }

        System.out.print("Enter sales: ");
        double sales = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        database[count] = new Salesperson2(id, sales);
        count++;
        Arrays.sort(database,0,count,Comparator.comparingInt(Salesperson2::getId));
    }

    private static void deleteRecord() {
        if (count == 0) {
            System.out.println("Database is empty");
            return;
        }

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (int i = 0; i < count; i++) {
            if (database[i].getId() == id) {
                database[i] = database[count - 1];
                count--;
                Arrays.sort(database,0,count,Comparator.comparingInt(Salesperson2::getId));
                return;
            }
        }

        System.out.println("ID not found");
    }

    private static void changeRecord() {
        if (count == 0) {
            System.out.println("Database is empty");
            return;
        }

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (int i = 0; i < count; i++) {
            if (database[i].getId() == id) {
                System.out.print("Enter new sales: ");
                double sales = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over
                database[i].setSales(sales);
                return;
            }
        }

        System.out.println("ID not found");
    }

    private static void displayDatabase() {
        if (count == 0) {
            System.out.println("Database is empty");
            return;
        }

        Arrays.sort(database,0,count,Comparator.comparingInt(Salesperson2::getId));
        System.out.println("Database:");
        for (int i = 0; i < count; i++) {
            System.out.println(database[i]);
        }
    }

}
