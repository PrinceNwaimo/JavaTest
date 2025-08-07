package joyceTwoDimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe2 {
    static char[] board = {'1','2','3','4','5','6','7','8','9'};
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        while (true) {
            displayBoard();
            playerMove();
            if (checkWin('X')) {
                displayBoard();
                System.out.println("You win!");
                break;
            }
            if (isBoardFull()) {
                displayBoard();
                System.out.println("It's a tie!");
                break;
            }
            computerMove();
            if (checkWin('O')) {
                displayBoard();
                System.out.println("Computer wins!");
                break;
            }
            if (isBoardFull()) {
                displayBoard();
                System.out.println("It's a tie!");
                break;
            }
        }
    }

    static void displayBoard() {
        System.out.println("\n" +
                board[0] + " | " + board[1] + " | " + board[2] + "\n" +
                "--+---+--\n" +
                board[3] + " | " + board[4] + " | " + board[5] + "\n" +
                "--+---+--\n" +
                board[6] + " | " + board[7] + " | " + board[8] + "\n");
    }

    static void playerMove() {
        int move;
        while (true) {
            System.out.print("Enter a position (1-9): ");
            String input = scanner.nextLine();
            try {
                move = Integer.parseInt(input);
                if (move < 1 || move > 9 || board[move - 1] == 'X' || board[move - 1] == 'O') {
                    System.out.println("Invalid move. Try again.");
                } else {
                    board[move - 1] = 'X';
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    static void computerMove() {
        int move = findWinningMove('O');
        if (move == -1) {
            move = getRandomMove();
        }
        board[move] = 'O';
        System.out.println("Computer chose position " + (move + 1));
    }

    static int findWinningMove(char player) {
        int[][] winCombos = {
                {0,1,2}, {3,4,5}, {6,7,8}, // Rows
                {0,3,6}, {1,4,7}, {2,5,8}, // Columns
                {0,4,8}, {2,4,6}           // Diagonals
        };
        for (int[] combo : winCombos) {
            int count = 0;
            int empty = -1;
            for (int index : combo) {
                if (board[index] == player) count++;
                else if (board[index] != 'X' && board[index] != 'O') empty = index;
            }
            if (count == 2 && empty != -1) return empty;
        }
        return -1;
    }

    static int getRandomMove() {
        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (board[i] != 'X' && board[i] != 'O') {
                available.add(i);
            }
        }
        return available.get(random.nextInt(available.size()));
    }

    static boolean checkWin(char player) {
        int[][] winCombos = {
                {0,1,2}, {3,4,5}, {6,7,8},
                {0,3,6}, {1,4,7}, {2,5,8},
                {0,4,8}, {2,4,6}
        };
        for (int[] combo : winCombos) {
            if (board[combo[0]] == player && board[combo[1]] == player && board[combo[2]] == player) {
                return true;
            }
        }
        return false;
    }

    static boolean isBoardFull() {
        for (char c : board) {
            if (c != 'X' && c != 'O') return false;
        }
        return true;
    }
}
