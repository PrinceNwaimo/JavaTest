package joyceInheritance;

import java.util.Scanner;

public class UseParty {
    public static void main(String[] args) {
        int guests;
        Party myParty = new Party();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of guests for the party >>> ");
        guests = input.nextInt();
        myParty.setGuests(guests);
        System.out.println("The party has " + myParty.getGuests() + " guests");
        myParty.displayInvitation();
    }
}
