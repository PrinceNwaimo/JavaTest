package leetCodeProblems;
import java.util.*;

public class NimGameTester {
    public static void main(String[] args) {
        // Test various scenarios
        testCase(Arrays.asList(3, 4, 5), true);  // Winning position
        testCase(Arrays.asList(2, 2), false);    // Losing position
        testCase(Arrays.asList(1, 2, 3), true);  // Winning position
        testCase(Arrays.asList(1, 1, 1), true);  // Winning position
        testCase(Arrays.asList(0, 0, 0), false); // Game over
        testCase(Arrays.asList(1), true);        // Single pile
        testCase(Arrays.asList(1, 1), false);    // Two equal piles
    }

    private static void testCase(List<Integer> piles, boolean expectedWin) {
        NimGame game = new NimGame(piles);
        System.out.println("Piles: " + piles);
        System.out.println("Nim sum: " + game.getNimSum());
        System.out.println("Can win: " + game.canWin());
        System.out.println("Expected: " + expectedWin);
        System.out.println("Result: " + (game.canWin() == expectedWin ? "PASS" : "FAIL"));
        System.out.println("Optimal move: " + game.optimalMove());
        System.out.println("Visualization:");
        System.out.println(game.getGameStateVisualization());
        System.out.println("----------------------------------------");
    }
}
