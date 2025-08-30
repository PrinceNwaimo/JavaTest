package joyceInheritance;

public class Event {
    private int eventNumber;
    private int guests;

    public Event(int eventNumber, int guests) {
        this.eventNumber = eventNumber;
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "Event Number: " + eventNumber +
                "\nNumber of Guests: " + guests;
    }

    public int getEventNumber() {
        return eventNumber;
    }

    public int getGuests() {
        return guests;
    }
}
