package joyceUsingIfAndElse;

import java.util.Scanner;

public class RentalDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        Rental rental1 = new Rental(1, getHours(input, 1), getMinutes(input, 1));
        Rental rental2 = new Rental(2, getHours(input, 2), getMinutes(input, 2));
        Rental rental3 = new Rental(3, getHours(input, 3), getMinutes(input, 3));


        System.out.println(rental1);
        System.out.println(rental2);
        System.out.println(rental3);


        System.out.println("\nComparing Rentals:");
        Rental longer = getLongerRental(rental1, rental2);
        System.out.println("Rental 1: Contract Number " + rental1.getContractNumber() + ", Time " + rental1.getHours() + " hours and " + rental1.getMinutes() + " minutes");
        System.out.println("Rental 2: Contract Number " + rental2.getContractNumber() + ", Time " + rental2.getHours() + " hours and " + rental2.getMinutes() + " minutes");
        System.out.println("Longer Rental: Contract Number " + longer.getContractNumber());

        longer = getLongerRental(rental2, rental3);
        System.out.println("\nRental 2: Contract Number " + rental2.getContractNumber() + ", Time " + rental2.getHours() + " hours and " + rental2.getMinutes() + " minutes");
        System.out.println("Rental 3: Contract Number " + rental3.getContractNumber() + ", Time " + rental3.getHours() + " hours and " + rental3.getMinutes() + " minutes");
        System.out.println("Longer Rental: Contract Number " + longer.getContractNumber());

        longer = getLongerRental(rental1, rental3);
        System.out.println("\nRental 1: Contract Number " + rental1.getContractNumber() + ", Time " + rental1.getHours() + " hours and " + rental1.getMinutes() + " minutes");
        System.out.println("Rental 3: Contract Number " + rental3.getContractNumber() + ", Time " + rental3.getHours() + " hours and " + rental3.getMinutes() + " minutes");
        System.out.println("Longer Rental: Contract Number " + longer.getContractNumber());
    }


    public static int getHours(Scanner input, int rentalNumber) {
        System.out.print("Enter the number of hours for Rental " + rentalNumber + ": ");
        return input.nextInt();
    }


    public static int getMinutes(Scanner input, int rentalNumber) {
        System.out.print("Enter the number of minutes for Rental " + rentalNumber + ": ");
        return input.nextInt();
    }


    public static Rental getLongerRental(Rental rental1, Rental rental2) {
        if (rental1.getHours() > rental2.getHours() ||
                (rental1.getHours() == rental2.getHours() && rental1.getMinutes() > rental2.getMinutes())) {
            return rental1;
        } else {
            return rental2;
      }
  }

}
