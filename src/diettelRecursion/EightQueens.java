package diettelRecursion;

public class EightQueens {
    private static final int BOARD_SIZE = 8;
    private static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    public static void main(String[] args) {
        placeQueens(0);
    }

    private static void placeQueens(int column) {
        if (column == BOARD_SIZE) {
            printBoard();
            return;
        }

        for (int row = 0; row < BOARD_SIZE; row++) {
            if (isSafe(row, column)) {
                board[row][column] = 1;
                placeQueens(column + 1);
                board[row][column] = 0;
            }
        }
    }

    private static boolean isSafe(int row, int column) {
        // Check the row
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check the upper diagonal
        int i = row - 1, j = column - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        // Check the lower diagonal
        i = row + 1;
        j = column - 1;
        while (i < BOARD_SIZE && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
