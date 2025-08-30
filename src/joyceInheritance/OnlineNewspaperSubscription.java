package joyceInheritance;

public class OnlineNewspaperSubscription extends NewspaperSubscription{
    private static final double RATE = 9.0;

    @Override
    public void setAddress(String address) {
        if (address.contains("@")) {
            this.address = address;
            this.rate = RATE;
        } else {
            System.out.println("Invalid email address for online subscription. Rate set to 0.");
            this.rate = 0;
        }
    }
}
