package joyceArrays;

import java.util.Scanner;

public class EventDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Event[] events = new Event[3];

        for (int i = 0; i < events.length; i++) {
            System.out.print("Enter event number for event " + (i + 1) + ": ");
            String eventNumber = scanner.nextLine();
            System.out.print("Enter number of guests for event " + (i + 1) + ": ");
            int numberOfGuests = scanner.nextInt();
            System.out.print("Enter price per guest for event " + (i + 1) + ": ");
            double pricePerGuest = scanner.nextDouble();
            scanner.nextLine(); // Consume newline left-over
            System.out.println("Enter event type for event " + (i + 1) + ":");
            System.out.println("0 - Wedding");
            System.out.println("1 - Baptism");
            System.out.println("2 - Birthday");
            System.out.println("3 - Corporate");
            System.out.println("4 - Other");
            int eventType = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            events[i] = new Event(eventNumber, numberOfGuests, pricePerGuest, eventType);
        }

        for (int i = 0; i < events.length; i++) {
            System.out.println("Event " + (i + 1) + " details:");
            System.out.println("Event number: " + events[i].getEventNumber());
            System.out.println("Number of guests: " + events[i].getNumberOfGuests());
            System.out.println("Price per guest: $" + events[i].getPricePerGuest());
            System.out.println("Event type: " + events[i].getEventTypeName());
            System.out.println("Total price: $" + events[i].getTotalPrice());
            System.out.println();
        }
    }

}
