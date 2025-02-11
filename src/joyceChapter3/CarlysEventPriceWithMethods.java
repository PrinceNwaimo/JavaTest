package joyceChapter3;

import java.util.Scanner;

public class CarlysEventPriceWithMethods {
    public static void main(String[] args) {
        int guests = getNumberOfGuests();
        displayMotto();
        displayEventDetails(guests);
    }

    public static int getNumberOfGuests() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of guests: ");
        int guests = scanner.nextInt();
        scanner.close();
        return guests;
    }

    public static void displayMotto() {
        System.out.println("*********************************");
        System.out.println("* Carly's makes every event *");
        System.out.println("*   a tasteful success!     *");
        System.out.println("*********************************");
    }

    public static void displayEventDetails(int guests) {
        final int PRICE_PER_GUEST = 35;
        final int LARGE_EVENT_CUTOFF = 50;

        int price = guests * PRICE_PER_GUEST;
        String largeEvent = (guests >= LARGE_EVENT_CUTOFF) ? "Yes" : "No";

        System.out.println("Number of guests: " + guests);
        System.out.println("Price per guest: $" + PRICE_PER_GUEST);
        System.out.println("Total price: $" + price);
        System.out.println("Large event? " + largeEvent);
    }
}
