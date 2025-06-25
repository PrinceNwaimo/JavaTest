package joyceArrays;

import java.util.Scanner;

public class RentalDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rental[] rentals = new Rental[3];

        for (int i = 0; i < rentals.length; i++) {
            System.out.print("Enter contract number for rental " + (i + 1) + ": ");
            String contractNumber = scanner.nextLine();
            System.out.print("Enter number of minutes for rental " + (i + 1) + ": ");
            int minutes = scanner.nextInt();
            System.out.print("Enter price per hour for rental " + (i + 1) + ": ");
            double pricePerHour = scanner.nextDouble();
            scanner.nextLine(); // Consume newline left-over
            System.out.println("Enter equipment type for rental " + (i + 1) + ":");
            System.out.println("0 - Personal watercraft");
            System.out.println("1 - Pontoon boat");
            System.out.println("2 - Rowboat");
            System.out.println("3 - Canoe");
            System.out.println("4 - Kayak");
            System.out.println("5 - Beach chair");
            System.out.println("6 - Umbrella");
            System.out.println("7 - Other");
            int equipmentType = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            rentals[i] = new Rental(contractNumber, minutes, pricePerHour, equipmentType);
        }

        for (int i = 0; i < rentals.length; i++) {
            System.out.println("Rental " + (i + 1) + " details:");
            System.out.println("Contract number: " + rentals[i].getContractNumber());
            System.out.println("Number of minutes: " + rentals[i].getMinutes());
            System.out.println("Price per hour: $" + rentals[i].getPricePerHour());
            System.out.println("Equipment type: " + rentals[i].getEquipmentTypeName());
            System.out.println("Total price: $" + rentals[i].getTotalPrice());
            System.out.println();
        }
    }

}
