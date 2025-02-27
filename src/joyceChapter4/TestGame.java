package joyceChapter4;

public class TestGame {
    public static void main(String[] args) {

        Team team1 = new Team("Roosevelt High", "Girls' Basketball", "Dolphins");
        Team team2 = new Team("Lincoln High", "Girls' Basketball", "Lions");


        Game game = new Game(team1, team2, "7 PM");


        displayGameDetails(game);
    }

    public static void displayGameDetails(Game game) {
        System.out.println("Game Details:");
        System.out.println("Team 1:");
        System.out.println("High School Name: " + game.getTeam1().getHighSchoolName());
        System.out.println("Sport: " + game.getTeam1().getSport());
        System.out.println("Team Name: " + game.getTeam1().getTeamName());
        System.out.println();
        System.out.println("Team 2:");
        System.out.println("High School Name: " + game.getTeam2().getHighSchoolName());
        System.out.println("Sport: " + game.getTeam2().getSport());
        System.out.println("Team Name: " + game.getTeam2().getTeamName());
        System.out.println();
        System.out.println("Game Time: " + game.getGameTime());
    }
}
