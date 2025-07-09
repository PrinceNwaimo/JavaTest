package liangMultiArrays;

import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("---------");
        }
    }

    private static void makeMove(Scanner scanner) {
        while (true) {
            System.out.print("Enter row (0-2) for player " + currentPlayer + ": ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0-2) for player " + currentPlayer + ": ");
            int col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid input. Please try again.");
            } else if (board[row][col] != ' ') {
                System.out.println("Cell is already occupied. Please try again.");
            } else {
                board[row][col] = currentPlayer;
                break;
            }
        }
    }

    private static boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }
        return false;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

}
