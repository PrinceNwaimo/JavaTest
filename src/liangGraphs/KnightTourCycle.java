package liangGraphs;

import java.util.*;

/**
 * Exercise 28.18 – Knight’s Tour Cycle
 *
 * This program constructs a graph representing all legal knight moves
 * on an N×N chessboard, then uses Hamiltonian cycle search to find
 * a closed knight’s tour.
 */
public class KnightTourCycle extends AbstractGraph4<Integer> {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter board size (e.g., 5 for 5x5): ");
        int size = input.nextInt();
        input.close();

        KnightTourCycle kt = new KnightTourCycle();
        kt.createKnightGraph(size);

        System.out.println("Finding Knight’s tour cycle on " + size + "x" + size + " board...");

        // Use Hamiltonian cycle search (requires getHamiltonianCycle in AbstractGraph4)
        List<Integer> cycle = kt.getHamiltonianCycle();

        if (cycle == null) {
            System.out.println("No Knight’s tour cycle exists for this board size.");
        } else {
            System.out.println("Knight’s tour cycle found!");
            printCycle(cycle, size);
        }
    }

    /**
     * Create a graph representing knight moves on an N×N chessboard.
     */
    public void createKnightGraph(int boardSize) {
        int n = boardSize * boardSize;

        vertices = new ArrayList<>();
        neighbors = new ArrayList<>();

        // Initialize adjacency list for all vertices
        for (int i = 0; i < n; i++) {
            vertices.add(i);
            neighbors.add(new ArrayList<>());
        }

        // Add edges for all possible knight moves
        for (int u = 0; u < n; u++) {
            for (int v : getPossibleMoves(u, boardSize)) {
                addEdge(u, v);
            }
        }
    }

    /**
     * Returns a list of valid moves a knight can make from a given square.
     */
    private List<Integer> getPossibleMoves(int square, int boardSize) {
        List<Integer> moves = new ArrayList<>();

        // Convert square index into (row, col)
        int row = square / boardSize;
        int col = square % boardSize;

        // All 8 possible knight moves (rowOffset, colOffset)
        int[][] directions = {
                { 2,  1}, { 1,  2}, {-1,  2}, {-2,  1},
                {-2, -1}, {-1, -2}, { 1, -2}, { 2, -1}
        };

        for (int[] d : directions) {
            int newRow = row + d[0];
            int newCol = col + d[1];

            // Ensure the move stays within board boundaries
            if (newRow >= 0 && newRow < boardSize && newCol >= 0 && newCol < boardSize) {
                int newSquare = newRow * boardSize + newCol;
                moves.add(newSquare);
            }
        }

        return moves;
    }

    /**
     * Prints the Knight’s Tour cycle in readable coordinates.
     */
    public static void printCycle(List<Integer> path, int size) {
        for (int i = 0; i < path.size(); i++) {
            int index = path.get(i);
            int row = index / size;
            int col = index % size;
            System.out.printf("%2d:(%d,%d)  ", i + 1, row, col);
            if ((i + 1) % size == 0) System.out.println();
        }

        // Confirm closure
        System.out.println("\nCycle closes at: " + path.get(0) + " → " + path.get(path.size() - 1));
    }
}
