package joyceUsingLoops;

import java.util.Scanner;

public class BarChart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] players = {"Art", "Bob", "Cal", "Dan", "Eli"};
        int[] points = new int[players.length];

        for (int i = 0; i < players.length; i++) {
            System.out.print("Enter points scored by " + players[i] + ": ");
            points[i] = scanner.nextInt();
        }

        for (int i = 0; i < players.length; i++) {
            System.out.print(players[i] + ": ");
            for (int j = 0; j < points[i] / 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }

}
