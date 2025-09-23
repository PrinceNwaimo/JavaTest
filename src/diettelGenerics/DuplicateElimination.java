package diettelGenerics;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateElimination {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add name");
            System.out.println("2. Search name");
            System.out.println("3. Display names");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.print("Enter a name: ");
                    String name = scanner.nextLine();
                    if (names.add(name)) {
                        System.out.println(name + " added successfully.");
                    } else {
                        System.out.println(name + " already exists.");
                    }
                    break;
                case 2:
                    System.out.print("Enter a name to search: ");
                    String searchName = scanner.nextLine();
                    if (names.contains(searchName)) {
                        System.out.println(searchName + " found.");
                    } else {
                        System.out.println(searchName + " not found.");
                    }
                    break;
                case 3:
                    System.out.println("Names:");
                    for (String n : names) {
                        System.out.println(n);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
