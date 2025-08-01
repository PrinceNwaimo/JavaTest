package diettelArrays;

import java.util.Random;

public class KnightsTourBruteForce {
    private static final int BOARD_SIZE = 8;
    private static final int NUM_TOURS = 1000;
    private static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    private static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static Random random = new Random();

    public static void main(String[] args) {
        int[] tourLengths = new int[BOARD_SIZE * BOARD_SIZE + 1];
        int fullTours = 0;
        long startTime = System.currentTimeMillis();

        while (fullTours == 0) {
            int currentRow = random.nextInt(BOARD_SIZE);
            int currentColumn = random.nextInt(BOARD_SIZE);
            board[currentRow][currentColumn] = 1;
            int move = 2;
            while (move <= BOARD_SIZE * BOARD_SIZE) {
                int[] nextMove = getNextMove(currentRow, currentColumn);
                if (nextMove == null) {
                    break;
                }
                currentRow = nextMove[0];
                currentColumn = nextMove[1];
                board[currentRow][currentColumn] = move;
                move++;
            }
            tourLengths[move - 1]++;
            if (move > BOARD_SIZE * BOARD_SIZE) {
                fullTours++;
                System.out.println("Full tour found!");
                printBoard();
                System.out.println("Number of tours attempted: " + (tourLengths[move - 1]));
                System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + "ms");
                break;
            }
            resetBoard();
        }
    }

    private static int[] getNextMove(int currentRow, int currentColumn) {
        int[] possibleMoves = new int[8];
        int numPossibleMoves = 0;
        for (int i = 0; i < 8; i++) {
            int newRow = currentRow + vertical[i];
            int newColumn = currentColumn + horizontal[i];
            if (isValidMove(newRow, newColumn)) {
                possibleMoves[numPossibleMoves] = i;
                numPossibleMoves++;
            }
        }
        if (numPossibleMoves == 0) {
            return null;
        }
        int randomMove = random.nextInt(numPossibleMoves);
        int[] nextMove = new int[2];
        nextMove[0] = currentRow + vertical[possibleMoves[randomMove]];
        nextMove[1] = currentColumn + horizontal[possibleMoves[randomMove]];
        return nextMove;
    }

    private static boolean isValidMove(int row, int column) {
        return row >= 0 && row < BOARD_SIZE && column >= 0 && column < BOARD_SIZE && board[row][column] == 0;
    }

    private static void resetBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = 0;
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
    }

}
