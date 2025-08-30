package joyceInheritance;

public class OutgoingPhoneCall extends PhoneCall{
    private static final double RATE = 0.04;
    private int minutes;

    public OutgoingPhoneCall(String phoneNumber, int minutes) {
        super(phoneNumber);
        this.minutes = minutes;
        setPrice(RATE * minutes);
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void display() {
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Rate per minute: $" + RATE);
        System.out.println("Number of minutes: " + minutes);
        System.out.println("Total Price: $" + price);
    }
}
