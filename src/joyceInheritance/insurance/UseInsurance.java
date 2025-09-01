package joyceInheritance.insurance;

import java.util.Scanner;

public class UseInsurance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter type of insurance (Life/Health): ");
        String type = scanner.nextLine();

        Insurance insurance;
        if (type.equalsIgnoreCase("Life")) {
            insurance = new Life();
        } else if (type.equalsIgnoreCase("Health")) {
            insurance = new Health();
        } else {
            System.out.println("Invalid type. Exiting...");
            return;
        }

        insurance.display();
    }
}
