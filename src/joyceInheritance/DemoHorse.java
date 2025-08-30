package joyceInheritance;

import java.util.Scanner;

public class DemoHorse {
    public static void main(String[] args) {
        Horse cuppy = new Horse();
        RaceHorse crab = new RaceHorse(10);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter race details for horses");
        String detail = input.next();
        cuppy.setName(detail);
        System.out.println("Race is "+ cuppy.getName());
    }
}
