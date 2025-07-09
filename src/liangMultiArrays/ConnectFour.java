package liangMultiArrays;

import java.util.Scanner;

public class ConnectFour {
    private static char[][] board = new char[6][7];
    private static char currentPlayer = 'R'; // R for red, Y for yellow

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();

        while (true) {
            displayBoard();
            makeMove(scanner);
            if (checkWin()) {
                displayBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (checkDraw()) {
                displayBoard();
                System.out.println("It's a draw!");
                break;
            }
            switchPlayer();
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
        System.out.println(" 1 2 3 4 5 6 7");
    }

    private static void makeMove(Scanner scanner) {
        while (true) {
            System.out.print("Enter column for player " + currentPlayer + ": ");
            int col = scanner.nextInt() - 1;
            if (col < 0 || col >= 7) {
                System.out.println("Invalid column. Please try again.");
            } else {
                for (int i = 5; i >= 0; i--) {
                    if (board[i][col] == ' ') {
                        board[i][col] = currentPlayer;
                        return;
                    }
                }
                System.out.println("Column is full. Please try again.");
            }
        }
    }

    private static boolean checkWin() {
        // Check rows
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == currentPlayer && board[i][j + 1] == currentPlayer && board[i][j + 2] == currentPlayer && board[i][j + 3] == currentPlayer) {
                    return true;
                }
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == currentPlayer && board[i + 1][j] == currentPlayer && board[i + 2][j] == currentPlayer && board[i + 3][j] == currentPlayer) {
                    return true;
                }
            }
        }

        // Check diagonals
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == currentPlayer && board[i + 1][j + 1] == currentPlayer && board[i + 2][j + 2] == currentPlayer && board[i + 3][j + 3] == currentPlayer) {
                    return true;
                }
                if (board[i + 3][j] == currentPlayer && board[i + 2][j + 1] == currentPlayer && board[i + 1][j + 2] == currentPlayer && board[i][j + 3] == currentPlayer) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R';
    }

}
