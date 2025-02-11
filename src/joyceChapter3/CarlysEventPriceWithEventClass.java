package joyceChapter3;

import java.util.Scanner;

public class CarlysEventPriceWithEventClass {
    public static void main(String[] args) {
        Event event = new Event();
        event.setEventNumber(getEventNumber());
        event.setGuests(getNumberOfGuests());

        CarlysEventPriceWithMethods.displayMotto();
        displayEventDetails(event);
    }

    public static String getEventNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the event number: ");
        String eventNumber = scanner.next();
        scanner.close();
        return eventNumber;
    }

    public static int getNumberOfGuests() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of guests: ");
        int guests = scanner.nextInt();
        scanner.close();
        return guests;
    }

    public static void displayEventDetails(Event event) {
        String largeEvent = (event.getGuests() >= Event.LARGE_EVENT_CUTOFF) ? "Yes" : "No";

        System.out.println("Event Number: " + event.getEventNumber());
        System.out.println("Number of guests: " + event.getGuests());
        System.out.println("Price per guest: $" + Event.PRICE_PER_GUEST);
        System.out.println("Total price: $" + event.getPrice());
        System.out.println("Large event? " + largeEvent);
    }
}
