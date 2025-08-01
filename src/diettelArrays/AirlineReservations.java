package diettelArrays;

import java.util.Scanner;

public class AirlineReservations {
    private static boolean[] seats = new boolean[10]; // 10 seats, initially all false (empty)
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Please type 1 for First Class");
            System.out.println("Please type 2 for Economy");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                assignSeat(0, 4, "First Class");
            } else if (choice == 2) {
                assignSeat(5, 9, "Economy");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void assignSeat(int start, int end, String section) {
        for (int i = start; i <= end; i++) {
            if (!seats[i]) {
                seats[i] = true;
                System.out.println("Boarding pass:");
                System.out.println("Seat number: " + (i + 1));
                System.out.println("Section: " + section);
                return;
            }
        }

        // Section is full, ask if user wants to be placed in the other section
        String otherSection;
        int otherStart;
        int otherEnd;

        if (section.equals("First Class")) {
            System.out.println("First Class is full. Would you like to be placed in Economy? (yes/no)");
            otherSection = "Economy";
            otherStart = 5;
            otherEnd = 9;
        } else {
            System.out.println("Economy is full. Would you like to be placed in First Class? (yes/no)");
            otherSection = "First Class";
            otherStart = 0;
            otherEnd = 4;
        }

        String response = scanner.next();

        if (response.equalsIgnoreCase("yes")) {
            assignSeat(otherStart, otherEnd, otherSection);
        } else {
            System.out.println("Next flight leaves in 3 hours.");
        }
    }


}
