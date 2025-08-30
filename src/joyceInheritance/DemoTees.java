package joyceInheritance;

public class DemoTees {
    public static void main(String[] args) {
        TeeShirt teeShirt1 = new TeeShirt();
        teeShirt1.setOrderNumber(1001);
        teeShirt1.setSize("L");
        teeShirt1.setColor("Blue");
        System.out.println("Tee Shirt 1 Details:");
        System.out.println("Order Number: " + teeShirt1.getOrderNumber());
        System.out.println("Size: " + teeShirt1.getSize());
        System.out.println("Color: " + teeShirt1.getColor());
        System.out.println("Price: $" + teeShirt1.getPrice());

        TeeShirt teeShirt2 = new TeeShirt();
        teeShirt2.setOrderNumber(1002);
        teeShirt2.setSize("XXL");
        teeShirt2.setColor("Red");
        System.out.println("\nTee Shirt 2 Details:");
        System.out.println("Order Number: " + teeShirt2.getOrderNumber());
        System.out.println("Size: " + teeShirt2.getSize());
        System.out.println("Color: " + teeShirt2.getColor());
        System.out.println("Price: $" + teeShirt2.getPrice());

        CustomTee customTee1 = new CustomTee();
        customTee1.setOrderNumber(1003);
        customTee1.setSize("M");
        customTee1.setColor("Green");
        customTee1.setSlogan("Java is fun!");
        System.out.println("\nCustom Tee 1 Details:");
        System.out.println("Order Number: " + customTee1.getOrderNumber());
        System.out.println("Size: " + customTee1.getSize());
        System.out.println("Color: " + customTee1.getColor());
        System.out.println("Slogan: " + customTee1.getSlogan());
        System.out.println("Price: $" + customTee1.getPrice());

        CustomTee customTee2 = new CustomTee();
        customTee2.setOrderNumber(1004);
        customTee2.setSize("XXXL");
        customTee2.setColor("Yellow");
        customTee2.setSlogan("I love programming!");
        System.out.println("\nCustom Tee 2 Details:");
        System.out.println("Order Number: " + customTee2.getOrderNumber());
        System.out.println("Size: " + customTee2.getSize());
        System.out.println("Color: " + customTee2.getColor());
        System.out.println("Slogan: " + customTee2.getSlogan());
        System.out.println("Price: $" + customTee2.getPrice());
    }
}
