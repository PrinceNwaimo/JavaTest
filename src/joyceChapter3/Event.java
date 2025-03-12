package joyceChapter3;

public class Event {
    public final static int PRICE_PER_GUEST = 35;
    public final static int LARGE_EVENT_CUTOFF = 50;

    private int eventNumber;
    private int guests;
    private double price;



    public void setEventNumber(int eventNumber) {
        this.eventNumber = eventNumber;
    }

    public void setGuests(int guests) {
        this.guests = guests;
        this.price = guests * PRICE_PER_GUEST;
    }

    public int getEventNumber() {
        return eventNumber;
    }

    public int getGuests() {
        return guests;
    }

    public double getPrice() {
        return price;
    }
}
