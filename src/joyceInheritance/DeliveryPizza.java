package joyceInheritance;

public class DeliveryPizza extends Pizza{
    private double deliveryFee;
    private String deliveryAddress;

    public DeliveryPizza(String description, double price, String deliveryAddress) {
        super(description, price);
        this.deliveryAddress = deliveryAddress;
        if (price > 15) {
            this.deliveryFee = 3;
        } else {
            this.deliveryFee = 5;
        }
    }

    public void display() {
        super.display();
        System.out.println("Delivery Address: " + deliveryAddress);
        System.out.println("Delivery Fee: $" + deliveryFee);
        System.out.println("Total Price: $" + (getPrice() + deliveryFee));
    }
}
