package joyceArrays;

import java.util.Scanner;

public class BowlingTeamDemo {
    public static void main(String[] args) {
        String name;
        BowlingTeam bowlingTeam = new BowlingTeam();
        int x;
        final int NUM_TEAM_MEMBERS = 4;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter team name:  ");
        name = input.nextLine();
        bowlingTeam.setTeamName(name);

        for (x = 0; x < NUM_TEAM_MEMBERS; ++x) {
            System.out.print("Enter team member's name: ");
            name = input.nextLine();
            bowlingTeam.setMembers(x, name);

        }
        System.out.println("\nMembers of team " + bowlingTeam.getTeamName());
        for ( x = 0; x < NUM_TEAM_MEMBERS; ++x)
            System.out.print(bowlingTeam.getMembers(x) + " ");
        System.out.println();

        }
    }

