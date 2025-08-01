package diettelArrays;

public class KnightsTour {
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
        } else {
            System.out.println("No solution exists");
        }
    }

    private static boolean tour(int currentRow, int currentColumn, int move) {
        if (move > BOARD_SIZE * BOARD_SIZE) {
            return true;
        }
        int nextMove = -1;
        int minAccessibility = 9;
        for (int i = 0; i < BOARD_SIZE; i++) {
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
        if (nextMove == -1) {
            return false;
        }
        int newRow = currentRow + vertical[nextMove];
        int newColumn = currentColumn + horizontal[nextMove];
        board[newRow][newColumn] = move;
        return tour(newRow, newColumn, move + 1);
    }

    private static int getAccessibility(int row, int column) {
        int accessibility = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
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

    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
    }

}
