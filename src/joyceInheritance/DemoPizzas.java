package joyceInheritance;

public class DemoPizzas {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("Sausage and Onion", 12.99);
        Pizza pizza2 = new Pizza("Pepperoni and Mushroom", 16.99);

        System.out.println("Pizza 1:");
        pizza1.display();
        System.out.println();

        System.out.println("Pizza 2:");
        pizza2.display();
        System.out.println();

        DeliveryPizza deliveryPizza1 = new DeliveryPizza("Sausage and Onion", 12.99, "123 Main St");
        DeliveryPizza deliveryPizza2 = new DeliveryPizza("Pepperoni and Mushroom", 16.99, "456 Elm St");

        System.out.println("Delivery Pizza 1:");
        deliveryPizza1.display();
        System.out.println();

        System.out.println("Delivery Pizza 2:");
        deliveryPizza2.display();
    }
}
