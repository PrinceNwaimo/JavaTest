package joyceChapter5;

import java.util.Scanner;

public class EventDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        Event event1 = new Event(1, getNumGuests(input, 1));
        Event event2 = new Event(2, getNumGuests(input, 2));
        Event event3 = new Event(3, getNumGuests(input, 3));


        System.out.println(event1);
        System.out.println(event2);
        System.out.println(event3);


        System.out.println("\nComparing Events:");
        Event larger = getLargerEvent(event1, event2);
        System.out.println("Event 1: " + event1.getEventNumber() + ", Guests: " + event1.getNumGuests());
        System.out.println("Event 2: " + event2.getEventNumber() + ", Guests: " + event2.getNumGuests());
        System.out.println("Larger Event: " + larger.getEventNumber() + ", Guests: " + larger.getNumGuests());

        larger = getLargerEvent(event2, event3);
        System.out.println("\nEvent 2: " + event2.getEventNumber() + ", Guests: " + event2.getNumGuests());
        System.out.println("Event 3: " + event3.getEventNumber() + ", Guests: " + event3.getNumGuests());
        System.out.println("Larger Event: " + larger.getEventNumber() + ", Guests: " + larger.getNumGuests());

        larger = getLargerEvent(event1, event3);
        System.out.println("\nEvent 1: " + event1.getEventNumber() + ", Guests: " + event1.getNumGuests());
        System.out.println("Event 3: " + event3.getEventNumber() + ", Guests: " + event3.getNumGuests());
        System.out.println("Larger Event: " + larger.getEventNumber() + ", Guests: " + larger.getNumGuests());
    }


    public static int getNumGuests(Scanner input, int eventNumber) {
        System.out.print("Enter the number of guests for Event " + eventNumber + ": ");
        return input.nextInt();
    }


    public static Event getLargerEvent(Event event1, Event event2) {
        if (event1.getNumGuests() >= event2.getNumGuests()) {
            return event1;
        } else {
            return event2;
     }
 }

}
