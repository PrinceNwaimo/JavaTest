package joyceInheritance;

import java.util.Arrays;
import java.util.Scanner;

public class DinnerEventDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DinnerEvent[] dinnerEvents = new DinnerEvent[4];

        for (int i = 0; i < dinnerEvents.length; i++) {
            System.out.print("Enter event number: ");
            int eventNumber = scanner.nextInt();
            System.out.print("Enter number of guests: ");
            int guests = scanner.nextInt();
            System.out.print("Enter entree (1 for Steak, 2 for Chicken, 3 for Fish): ");
            int entree = scanner.nextInt();
            System.out.print("Enter side 1 (1 for Salad, 2 for Mashed Potatoes, 3 for Grilled Vegetables): ");
            int side1 = scanner.nextInt();
            System.out.print("Enter side 2 (1 for Salad, 2 for Mashed Potatoes, 3 for Grilled Vegetables): ");
            int side2 = scanner.nextInt();
            System.out.print("Enter dessert (1 for Cheesecake, 2 for Chocolate Cake, 3 for Fruit Salad): ");
            int dessert = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            dinnerEvents[i] = new DinnerEvent(eventNumber, guests, entree, side1, side2, dessert);
        }

        while (true) {
            System.out.println("1. Sort by event number");
            System.out.println("2. Sort by number of guests");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            switch (choice) {
                case 1:
                    Arrays.sort(dinnerEvents, (a, b) -> Integer.compare(a.getEventNumber(), b.getEventNumber()));
                    break;
                case 2:
                    Arrays.sort(dinnerEvents, (a, b) -> Integer.compare(a.getGuests(), b.getGuests()));
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            for (DinnerEvent dinnerEvent : dinnerEvents) {
                System.out.println(dinnerEvent.toString());
                System.out.println();
            }
        }
    }
}
