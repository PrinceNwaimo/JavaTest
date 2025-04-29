package joyceUsingLoops;

import java.util.Scanner;

public class AssignVolunteer5 {
    public static void main(String[] args) {

        int donationType;
        String volunteer;
        String message;
        final int CLOTHING_CODE = 1;
        final int FURNITURE_CODE = 2;
        final int ELECTRONICS_CODE = 3;
        final int OTHER_CODE = 4;
        final String CLOTHING_PRICER = "Regina";
        final String FURNITURE_PRICER = "Gladys";
        final String ELECTRONICS_PRICER = "Prince";
        final String OTHER_PRICER = "Macro";

        Scanner input = new Scanner(System .in);
        System.out.println("What type of donation is this?");
        System.out.print("Enter an integer between 1 and 4...");

        donationType = input.nextInt();

        while(donationType < CLOTHING_CODE || donationType > OTHER_CODE){
            System.out.println("You entered " + donationType + " which is not a valid donation type");
            System.out.print("Please enter a value between " + CLOTHING_CODE + " and " + OTHER_CODE + " ...");
            System.out.print("enter an integer...");
            donationType = input.nextInt();
        }

        if(donationType == CLOTHING_CODE) {
            volunteer = CLOTHING_PRICER;
            message = "a clothing donation";
        } else if
        (donationType == FURNITURE_CODE){
            volunteer = FURNITURE_PRICER;
            message = "a furniture donation";
        } else if (donationType == ELECTRONICS_CODE) {
            volunteer = ELECTRONICS_PRICER;
            message = " an electronics donation";

        } else {
            volunteer = OTHER_PRICER;
            message = "a non- clothing donation";
        }

        System.out.println("You entered " + donationType);
        System.out.println("The volunteer who will price this item is " + volunteer);
        System.out.println("This is " + message);
    }
}
