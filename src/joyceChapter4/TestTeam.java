package joyceChapter4;

public class TestTeam {
    public static void main(String[] args) {

        Team team1 = new Team("Roosevelt High", "Girls' Basketball", "Dolphins");
        Team team2 = new Team("Lincoln High", "Boys' Football", "Lions");
        Team team3 = new Team("Washington High", "Girls' Soccer", "Warriors");


        System.out.println("Team 1:");
        System.out.println("High School Name: " + team1.getHighSchoolName());
        System.out.println("Sport: " + team1.getSport());
        System.out.println("Team Name: " + team1.getTeamName());
        System.out.println("Motto: " + Team.getMotto());
        System.out.println();

        System.out.println("Team 2:");
        System.out.println("High School Name: " + team2.getHighSchoolName());
        System.out.println("Sport: " + team2.getSport());
        System.out.println("Team Name: " + team2.getTeamName());
        System.out.println("Motto: " + Team.getMotto());
        System.out.println();

        System.out.println("Team 3:");
        System.out.println("High School Name: " + team3.getHighSchoolName());
        System.out.println("Sport: " + team3.getSport());
        System.out.println("Team Name: " + team3.getTeamName());
        System.out.println("Motto: " + Team.getMotto());
    }
}
