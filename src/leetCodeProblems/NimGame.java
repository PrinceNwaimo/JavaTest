package leetCodeProblems;
import java.util.*;

public class NimGame {
    private List<Integer> piles;
    private int currentPlayer;
    private List<Move> moveHistory;

    // Inner class to represent a move
    public static class Move {
        public int pileIndex;
        public int stones;

        public Move(int pileIndex, int stones) {
            this.pileIndex = pileIndex;
            this.stones = stones;
        }

        @Override
        public String toString() {
            return "(" + pileIndex + ", " + stones + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Move move = (Move) o;
            return pileIndex == move.pileIndex && stones == move.stones;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pileIndex, stones);
        }
    }

    // Constructor
    public NimGame(List<Integer> piles) {
        this.piles = new ArrayList<>(piles);
        this.currentPlayer = 1;
        this.moveHistory = new ArrayList<>();
    }

    // Constructor with array
    public NimGame(int[] piles) {
        this.piles = new ArrayList<>();
        for (int pile : piles) {
            this.piles.add(pile);
        }
        this.currentPlayer = 1;
        this.moveHistory = new ArrayList<>();
    }

    public boolean isGameOver() {
        for (int pile : piles) {
            if (pile > 0) {
                return false;
            }
        }
        return true;
    }

    public void makeMove(int pileIndex, int stones) {
        if (pileIndex < 0 || pileIndex >= piles.size()) {
            throw new IllegalArgumentException("Invalid pile index.");
        }
        if (stones <= 0 || stones > piles.get(pileIndex)) {
            throw new IllegalArgumentException("Invalid number of stones to remove.");
        }
        piles.set(pileIndex, piles.get(pileIndex) - stones);
        moveHistory.add(new Move(pileIndex, stones));
        // Switch player after move
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }

    public List<Integer> getPiles() {
        return new ArrayList<>(piles);
    }

    public boolean canWin() {
        int xorSum = 0;
        for (int pile : piles) {
            xorSum ^= pile;
        }
        return xorSum != 0;
    }

    public Move optimalMove() {
        int xorSum = 0;
        for (int pile : piles) {
            xorSum ^= pile;
        }

        if (xorSum == 0) {
            return null; // No winning move available
        }

        for (int i = 0; i < piles.size(); i++) {
            int targetPile = piles.get(i) ^ xorSum;
            if (targetPile < piles.get(i)) {
                int stonesToRemove = piles.get(i) - targetPile;
                return new Move(i, stonesToRemove);
            }
        }

        return null; // Should not reach here if canWin() is true
    }

    public String playGame() {
        StringBuilder gameLog = new StringBuilder();
        int player = 1;

        while (!isGameOver()) {
            if (canWin()) {
                Move move = optimalMove();
                if (move != null) {
                    makeMove(move.pileIndex, move.stones);
                    String log = String.format("Player %d removes %d stones from pile %d.",
                            player, move.stones, move.pileIndex);
                    System.out.println(log);
                    gameLog.append(log).append("\n");
                }
            } else {
                // If current player cannot win, remove 1 stone from first non-empty pile
                for (int i = 0; i < piles.size(); i++) {
                    if (piles.get(i) > 0) {
                        makeMove(i, 1);
                        String log = String.format("Player %d removes 1 stone from pile %d.",
                                player, i);
                        System.out.println(log);
                        gameLog.append(log).append("\n");
                        break;
                    }
                }
            }
            player = (player == 1) ? 2 : 1;
        }

        int winner = (player == 1) ? 2 : 1;
        String result = "Player " + winner + " wins!";
        System.out.println(result);
        gameLog.append(result);
        return result;
    }

    public void resetGame(List<Integer> newPiles) {
        this.piles = new ArrayList<>(newPiles);
        this.currentPlayer = 1;
        this.moveHistory.clear();
    }

    public Map<String, Object> getCurrentState() {
        Map<String, Object> state = new HashMap<>();
        state.put("piles", new ArrayList<>(piles));
        state.put("current_player", currentPlayer);
        return state;
    }

    public Integer getWinner() {
        if (isGameOver()) {
            return (currentPlayer == 1) ? 2 : 1;
        }
        return null; // Game is not over yet
    }

    public List<Move> getPossibleMoves() {
        List<Move> possibleMoves = new ArrayList<>();
        for (int i = 0; i < piles.size(); i++) {
            for (int stones = 1; stones <= piles.get(i); stones++) {
                possibleMoves.add(new Move(i, stones));
            }
        }
        return possibleMoves;
    }

    public Map<String, Object> getGameSummary() {
        Map<String, Object> summary = new HashMap<>();
        summary.put("current_state", getCurrentState());
        summary.put("possible_moves", getPossibleMoves());
        return summary;
    }

    public int getNimSum() {
        int nimSum = 0;
        for (int pile : piles) {
            nimSum ^= pile;
        }
        return nimSum;
    }

    public boolean isWinningPosition() {
        return getNimSum() != 0;
    }

    public List<Move> getLosingMoves() {
        List<Move> losingMoves = new ArrayList<>();
        for (int i = 0; i < piles.size(); i++) {
            for (int stones = 1; stones <= piles.get(i); stones++) {
                // Simulate the move
                piles.set(i, piles.get(i) - stones);
                if (!isWinningPosition()) {
                    losingMoves.add(new Move(i, stones));
                }
                // Undo the move
                piles.set(i, piles.get(i) + stones);
            }
        }
        return losingMoves;
    }

    public List<Move> getWinningMoves() {
        List<Move> winningMoves = new ArrayList<>();
        for (int i = 0; i < piles.size(); i++) {
            for (int stones = 1; stones <= piles.get(i); stones++) {
                // Simulate the move
                piles.set(i, piles.get(i) - stones);
                if (isWinningPosition()) {
                    winningMoves.add(new Move(i, stones));
                }
                // Undo the move
                piles.set(i, piles.get(i) + stones);
            }
        }
        return winningMoves;
    }

    public Map<String, Object> getOptimalStrategy() {
        Move optimal = optimalMove();
        if (optimal != null) {
            // Simulate the move
            piles.set(optimal.pileIndex, piles.get(optimal.pileIndex) - optimal.stones);
            Map<String, Object> resultingState = getCurrentState();
            // Undo the move
            piles.set(optimal.pileIndex, piles.get(optimal.pileIndex) + optimal.stones);

            Map<String, Object> strategy = new HashMap<>();
            strategy.put("optimal_move", optimal);
            strategy.put("resulting_state", resultingState);
            return strategy;
        }
        return null;
    }

    public String getGameStateRepresentation() {
        Map<String, Object> state = getCurrentState();
        return "Piles: " + state.get("piles") + ", Current Player: " + state.get("current_player");
    }

    public String getGameStateVisualization() {
        StringBuilder visualization = new StringBuilder();
        for (int i = 0; i < piles.size(); i++) {
            int pile = piles.get(i);
            visualization.append(String.format("Pile %d: %s (%d stones)\n",
                    i, "|".repeat(Math.max(0, pile)), pile));
        }
        return visualization.toString().trim();
    }

    public Map<String, Object> getGameStateSummary() {
        Map<String, Object> summary = new HashMap<>();
        summary.put("current_state", getCurrentState());
        summary.put("possible_moves", getPossibleMoves());
        summary.put("nim_sum", getNimSum());
        summary.put("is_winning_position", isWinningPosition());
        return summary;
    }

    public Map<String, Object> getGameStateDetails() {
        Map<String, Object> details = new HashMap<>();
        details.put("current_state", getCurrentState());
        details.put("possible_moves", getPossibleMoves());
        details.put("nim_sum", getNimSum());
        details.put("is_winning_position", isWinningPosition());
        details.put("optimal_strategy", getOptimalStrategy());
        return details;
    }

    public Map<String, Object> getGameStateAnalysis() {
        Map<String, Object> analysis = new HashMap<>();
        analysis.put("current_state", getCurrentState());
        analysis.put("possible_moves", getPossibleMoves());
        analysis.put("nim_sum", getNimSum());
        analysis.put("is_winning_position", isWinningPosition());
        analysis.put("optimal_strategy", getOptimalStrategy());
        analysis.put("winning_moves", getWinningMoves());
        analysis.put("losing_moves", getLosingMoves());
        return analysis;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Nim Game Test ===");
        System.out.println();

        // Test with a winning position
        System.out.println("Test 1: Winning position for player 1");
        List<Integer> piles1 = Arrays.asList(3, 4, 5);
        NimGame game1 = new NimGame(piles1);
        System.out.println("Initial piles: " + game1.getPiles());
        System.out.println("Nim sum: " + game1.getNimSum());
        System.out.println("Can win: " + game1.canWin());
        System.out.println("Optimal move: " + game1.optimalMove());
        System.out.println("Game state: " + game1.getGameStateRepresentation());
        System.out.println();

        // Test with a losing position
        System.out.println("Test 2: Losing position for player 1");
        List<Integer> piles2 = Arrays.asList(2, 2);
        NimGame game2 = new NimGame(piles2);
        System.out.println("Initial piles: " + game2.getPiles());
        System.out.println("Nim sum: " + game2.getNimSum());
        System.out.println("Can win: " + game2.canWin());
        System.out.println("Optimal move: " + game2.optimalMove());
        System.out.println("Game state: " + game2.getGameStateRepresentation());
        System.out.println();

        // Test with visualization
        System.out.println("Test 3: Game visualization");
        List<Integer> piles3 = Arrays.asList(5, 3, 4, 2);
        NimGame game3 = new NimGame(piles3);
        System.out.println("Visualization:");
        System.out.println(game3.getGameStateVisualization());
        System.out.println();

        // Test possible moves
        System.out.println("Test 4: Possible moves");
        List<Integer> piles4 = Arrays.asList(3, 2);
        NimGame game4 = new NimGame(piles4);
        System.out.println("Piles: " + game4.getPiles());
        System.out.println("Possible moves: " + game4.getPossibleMoves());
        System.out.println("Winning moves: " + game4.getWinningMoves());
        System.out.println("Losing moves: " + game4.getLosingMoves());
        System.out.println();

        // Test game analysis
        System.out.println("Test 5: Game analysis");
        List<Integer> piles5 = Arrays.asList(1, 2, 3);
        NimGame game5 = new NimGame(piles5);
        Map<String, Object> analysis = game5.getGameStateAnalysis();
        System.out.println("Analysis:");
        System.out.println("  Piles: " + analysis.get("current_state"));
        System.out.println("  Nim sum: " + analysis.get("nim_sum"));
        System.out.println("  Is winning: " + analysis.get("is_winning_position"));
        System.out.println("  Optimal strategy: " + analysis.get("optimal_strategy"));
        System.out.println("  Winning moves: " + analysis.get("winning_moves"));
        System.out.println("  Losing moves: " + analysis.get("losing_moves"));
        System.out.println();

        // Test game simulation
        System.out.println("Test 6: Game simulation");
        List<Integer> piles6 = Arrays.asList(3, 4, 5);
        NimGame game6 = new NimGame(piles6);
        System.out.println("Starting game with piles: " + game6.getPiles());
        System.out.println("Playing...");
        game6.playGame();
        System.out.println();

        // Test reset
        System.out.println("Test 7: Reset game");
        NimGame game7 = new NimGame(Arrays.asList(1, 2, 3));
        System.out.println("Before reset: " + game7.getPiles());
        game7.resetGame(Arrays.asList(5, 5, 5));
        System.out.println("After reset: " + game7.getPiles());

        // Test making a move
        System.out.println("\nTest 8: Making a move");
        NimGame game8 = new NimGame(Arrays.asList(3, 4, 5));
        System.out.println("Before move: " + game8.getPiles());
        game8.makeMove(0, 2);
        System.out.println("After removing 2 from pile 0: " + game8.getPiles());

        // Test getWinner
        System.out.println("\nTest 9: Get winner");
        NimGame game9 = new NimGame(Arrays.asList(0, 0, 0));
        System.out.println("Game over? " + game9.isGameOver());
        System.out.println("Winner: " + game9.getWinner());
    }
}
