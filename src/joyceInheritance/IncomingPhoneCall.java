package joyceInheritance;

public class IncomingPhoneCall extends PhoneCall{
    private static final double RATE = 0.02;

    public IncomingPhoneCall(String phoneNumber) {
        super(phoneNumber);
        setPrice(RATE);
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
        System.out.println("Rate: $" + RATE);
        System.out.println("Price: $" + price);
    }
}
