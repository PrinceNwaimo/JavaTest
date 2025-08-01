package diettelArrays;

public class KnightsTourClosedTourTest {
    private static final int BOARD_SIZE = 8;
    private static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    private static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        int currentRow = 0;
        int currentColumn = 0;
        board[currentRow][currentColumn] = 1;
        if (tour(currentRow, currentColumn, 2)) {
            printBoard();
            if (isClosedTour(currentRow, currentColumn)) {
                System.out.println("Closed tour found!");
            } else {
                System.out.println("Full tour found, but not closed.");
            }
        } else {
            System.out.println("No solution exists");
        }
    }

    private static boolean tour(int currentRow, int currentColumn, int move) {
        if (move > BOARD_SIZE * BOARD_SIZE) {
            return true;
        }
        int nextMove = getNextMove(currentRow, currentColumn);
        if (nextMove == -1) {
            return false;
        }
        int newRow = currentRow + vertical[nextMove];
        int newColumn = currentColumn + horizontal[nextMove];
        board[newRow][newColumn] = move;
        return tour(newRow, newColumn, move + 1);
    }

    private static int getNextMove(int currentRow, int currentColumn) {
        int minAccessibility = 9;
        int nextMove = -1;
        for (int i = 0; i < 8; i++) {
            int newRow = currentRow + vertical[i];
            int newColumn = currentColumn + horizontal[i];
            if (isValidMove(newRow, newColumn)) {
                int accessibility = getAccessibility(newRow, newColumn);
                if (accessibility < minAccessibility) {
                    minAccessibility = accessibility;
                    nextMove = i;
                }
            }
        }
        return nextMove;
    }

    private static int getAccessibility(int row, int column) {
        int accessibility = 0;
        for (int i = 0; i < 8; i++) {
            int newRow = row + vertical[i];
            int newColumn = column + horizontal[i];
            if (isValidMove(newRow, newColumn)) {
                accessibility++;
            }
        }
        return accessibility;
    }

    private static boolean isValidMove(int row, int column) {
        return row >= 0 && row < BOARD_SIZE && column >= 0 && column < BOARD_SIZE && board[row][column] == 0;
    }

    private static boolean isClosedTour(int currentRow, int currentColumn) {
        int startRow = 0;
        int startColumn = 0;
        for (int i = 0; i < 8; i++) {
            int newRow = currentRow + vertical[i];
            int newColumn = currentColumn + horizontal[i];
            if (newRow >= 0 && newRow < BOARD_SIZE && newColumn >= 0 && newColumn < BOARD_SIZE) {
                if (board[newRow][newColumn] == 1) {
                    return true;
                }
            }
        }
        return false;
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