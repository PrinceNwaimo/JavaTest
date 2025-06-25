package joyceArrays;

public class Event {
    private String eventNumber;
    private int numberOfGuests;
    private double pricePerGuest;
    private int eventType;
    private static final String[] EVENT_TYPES = {"wedding", "baptism", "birthday", "corporate", "other"};

    public Event(String eventNumber, int numberOfGuests, double pricePerGuest, int eventType) {
        this.eventNumber = eventNumber;
        this.numberOfGuests = numberOfGuests;
        this.pricePerGuest = pricePerGuest;
        setEventType(eventType);
    }

    public String getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(String eventNumber) {
        this.eventNumber = eventNumber;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public double getPricePerGuest() {
        return pricePerGuest;
    }

    public void setPricePerGuest(double pricePerGuest) {
        this.pricePerGuest = pricePerGuest;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        if (eventType >= EVENT_TYPES.length) {
            this.eventType = EVENT_TYPES.length - 1;
        } else {
            this.eventType = eventType;
        }
    }

    public String getEventTypeName() {
        return EVENT_TYPES[eventType];
    }

    public double getTotalPrice() {
        return numberOfGuests * pricePerGuest;
    }

}
