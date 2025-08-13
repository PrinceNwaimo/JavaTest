package diettel8;

import java.util.Scanner;

public class CylinderTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the radius of the cylinder: ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the height of the cylinder: ");
        double height = scanner.nextDouble();

        Cylinder cylinder = new Cylinder(radius, height);

        System.out.println("Cylinder radius: " + cylinder.getRadius());
        System.out.println("Cylinder height: " + cylinder.getHeight());
        System.out.println("Cylinder volume: " + cylinder.calculateVolume());
    }
}
