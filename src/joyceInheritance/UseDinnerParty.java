package joyceInheritance;

import java.util.Scanner;

public class UseDinnerParty {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        int guests;
        DinnerParty feasting = new DinnerParty();
        System.out.print("Enter number of guests for the dinner party >> ");
        guests = input.nextInt();
        feasting.setGuests(guests);

        System.out.print("Enter the menu option --1 for chicken or 2 for beef >> ");
        choice = input.nextInt();
        feasting.setDinnerChoice(choice);
        System.out.println("The dinner party has " + feasting.getGuests() + " guests");
        System.out.println("Menu option " + feasting.getDinnerChoice() + " will be served");

        feasting.displayInvitation();
    }

}
