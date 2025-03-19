package joyceChapter5;

public class AutomobileTest {
    public static void main(String[] args) {
        Automobile car1 = new Automobile(1234, "Toyota", "Camry", "Blue", 2015, 25);
        Automobile car2 = new Automobile(-1, "Honda", "Civic", "Red", 2020, 30);
        Automobile car3 = new Automobile(5678, "Ford", "Fusion", "Silver", 2000, 20);

        System.out.println("Car 1:");
        System.out.println("ID: " + car1.getId());
        System.out.println("Make: " + car1.getMake());
        System.out.println("Model: " + car1.getModel());
        System.out.println("Color: " + car1.getColor());
        System.out.println("Year: " + car1.getYear());
        System.out.println("Miles per gallon: " + car1.getMilesPerGallon());

        System.out.println("\nCar 2:");
        System.out.println("ID: " + car2.getId());
        System.out.println("Make: " + car2.getMake());
        System.out.println("Model: " + car2.getModel());
        System.out.println("Color: " + car2.getColor());
        System.out.println("Year: " + car2.getYear());
        System.out.println("Miles per gallon: " + car2.getMilesPerGallon());

        System.out.println("\nCar 3:");
        System.out.println("ID: " + car3.getId());
        System.out.println("Make: " + car3.getMake());
        System.out.println("Model: " + car3.getModel());
        System.out.println("Color: " + car3.getColor());
        System.out.println("Year: " + car3.getYear());
        System.out.println("Miles per gallon: " + car3.getMilesPerGallon());
 }

}
