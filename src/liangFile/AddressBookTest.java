package liangFile;

import java.io.IOException;
import java.util.Scanner;

public class AddressBookTest {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try {
            AddressBook addressBook = new AddressBook("address.dat");

            while (true) {
                System.out.println("1. Add record");
                System.out.println("2. Update record");
                System.out.println("3. Retrieve record");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter street: ");
                        String street = scanner.nextLine();
                        System.out.print("Enter city: ");
                        String city = scanner.nextLine();
                        System.out.print("Enter state: ");
                        String state = scanner.nextLine();
                        System.out.print("Enter zip: ");
                        String zip = scanner.nextLine();
                        addressBook.addRecord(name, street, city, state, zip);
                        break;
                    case 2:
                        System.out.print("Enter record index: ");
                        int index = scanner.nextInt();
                        scanner.nextLine(); // Consume newline left-over
                        System.out.print("Enter name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter street: ");
                        street = scanner.nextLine();
                        System.out.print("Enter city: ");
                        city = scanner.nextLine();
                        System.out.print("Enter state: ");
                        state = scanner.nextLine();
                        System.out.print("Enter zip: ");
                        zip = scanner.nextLine();
                        addressBook.updateRecord(index, name, street, city, state, zip);
                        break;
                    case 3:
                        System.out.print("Enter record index: ");
                        index = scanner.nextInt();
                        scanner.nextLine(); // Consume newline left-over
                        String[] record = addressBook.retrieveRecord(index);
                        System.out.println("Name: " + record[0]);
                        System.out.println("Street: " + record[1]);
                        System.out.println("City: " + record[2]);
                        System.out.println("State: " + record[3]);
                        System.out.println("Zip: " + record[4]);
                        break;
                    case 4:
                        addressBook.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
                }
