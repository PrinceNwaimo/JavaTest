package joyceUsingIfAndElse;

public class Event {
    private int eventNumber;
    private int numGuests;
    private double price;
    private double pricePerGuest;
    private static final double LOWER_PRICE_PER_GUEST = 32;
    private static final double HIGHER_PRICE_PER_GUEST = 35;

    public Event(int eventNumber, int numGuests) {
        this.eventNumber = eventNumber;
        setNumGuests(numGuests);
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
        if (isLargeEvent()) {
            pricePerGuest = LOWER_PRICE_PER_GUEST;
        } else {
            pricePerGuest = HIGHER_PRICE_PER_GUEST;
        }
        price = pricePerGuest * numGuests;
    }

    public int getEventNumber() {
        return eventNumber;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public double getPrice() {
        return price;
    }

    public double getPricePerGuest() {
        return pricePerGuest;
    }

    public boolean isLargeEvent() {
        return numGuests >= 50;
    }

    public String toString() {
        return "Event Number: " + eventNumber + "\nNumber of Guests: " + numGuests +
                "\nPrice per Guest: $" + String.format("%.2f", pricePerGuest) +
                "\nTotal Price: $" + String.format("%.2f", price);
    }

}
