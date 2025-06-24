package joyceArrays;

import java.util.Scanner;

public class CarCareChoice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] services = {"oil change", "tire rotation", "battery check", "brake inspection"};
        double[] prices = {25, 22, 15, 5};

        System.out.println("Available services:");
        for (int i = 0; i < services.length; i++) {
            System.out.println((i + 1) + ". " + services[i].substring(0, 1).toUpperCase() + services[i].substring(1) + " - $" + prices[i]);
        }

        System.out.print("Enter a service: ");
        String input = scanner.nextLine().toLowerCase();

        int index = -1;
        for (int i = 0; i < services.length; i++) {
            if (services[i].startsWith(input)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println(services[index].substring(0, 1).toUpperCase() + services[index].substring(1) + ": $" + prices[index]);
        } else {
            System.out.println("Invalid service. Please try again.");
        }

        scanner.close();
    }

}
