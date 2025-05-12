package joyceUsingLoops;





import joyceUsingIfAndElse.Event;

import java.util.Scanner;

public class EventDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Event event1 = new Event(45, 300);
        Event event2 = new Event(46,200);
        Event event3 = new Event(47,500);

        setEventDetails(scanner, event1);
        setEventDetails(scanner, event2);
        setEventDetails(scanner, event3);

        System.out.println("Event 1 details:");
        event1.toString();

        System.out.println("Event 2 details:");
        event2.toString();

        System.out.println("Event 3 details:");
        event3.toString();

        System.out.println("Please come to my event!");
        for (int i = 0; i < event3.getNumGuests(); i++) {
            System.out.println("Please come to my event!");
        }

        scanner.close();
    }

    public static void setEventDetails(Scanner scanner, Event event) {
        int guests;
        while (true) {
            System.out.print("Enter number of guests (5-100): ");
            guests = scanner.nextInt();
            if (guests >= 5 && guests <= 100) {
                break;
            }
            System.out.println("Invalid number of guests. Please enter a value between 5 and 100.");
        }
        event.setNumGuests(guests);
    }

}
