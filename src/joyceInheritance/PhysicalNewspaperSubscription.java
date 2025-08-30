package joyceInheritance;

public class PhysicalNewspaperSubscription extends NewspaperSubscription{
    private static final double RATE = 15.0;

    @Override
    public void setAddress(String address) {
        if (address.matches(".*\\d.*")) {
            this.address = address;
            this.rate = RATE;
        } else {
            System.out.println("Invalid address for physical subscription. Rate set to 0.");
            this.rate = 0;
        }
    }
}
