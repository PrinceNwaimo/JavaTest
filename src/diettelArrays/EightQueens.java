package diettelArrays;

public class EightQueens {
    private static final int BOARD_SIZE = 8;
    private static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    public static void main(String[] args) {
        placeQueens(0);
    }

    private static boolean placeQueens(int row) {
        if (row == BOARD_SIZE) {
            printBoard();
            return true;
        }
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isValidMove(row, col)) {
                board[row][col] = 1;
                if (placeQueens(row + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isValidMove(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 1) {
                    if (j == col || Math.abs(i - row) == Math.abs(j - col)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

}
