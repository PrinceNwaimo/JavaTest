package liangArrays;

public class EightQueens {
    private static final int BOARD_SIZE = 8;
    private static int[] queens = new int[BOARD_SIZE];

    public static void main(String[] args) {
        solveQueens(0);
        printBoard();
    }

    private static boolean isValid(int row, int column) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == column || queens[i] - i == column - row || queens[i] + i == column + row) {
                return false;
            }
        }
        return true;
    }

    private static boolean solveQueens(int row) {
        if (row == BOARD_SIZE) {
            return true;
        }
        for (int column = 0; column < BOARD_SIZE; column++) {
            if (isValid(row, column)) {
                queens[row] = column;
                if (solveQueens(row + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (queens[row] == column) {
                    System.out.print("|Q");
                } else {
                    System.out.print("| ");
                }
            }
            System.out.println("|");
        }
    }

}
