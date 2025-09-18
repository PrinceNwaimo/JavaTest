package diettelStringsAndCharacters;

import java.util.Random;

public class CrosswordPuzzleGenerator {
    private static final int GRID_SIZE = 15;
    private static final String[] words = {"apple", "banana", "orange", "grape", "default", "java", "puzzle", "crossword"};

    public static void main(String[] args) {
        char[][] grid = new char[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = '_';
            }
        }

        Random random = new Random();
        for (String word : words) {
            int direction = random.nextInt(2); // 0 for horizontal, 1 for vertical
            if (direction == 0) {
                placeWordHorizontally(grid, word, random);
            } else {
                placeWordVertically(grid, word, random);
            }
        }

        printGrid(grid);
    }

    private static void placeWordHorizontally(char[][] grid, String word, Random random) {
        int row = random.nextInt(GRID_SIZE);
        int col = random.nextInt(GRID_SIZE - word.length());
        for (int i = 0; i < word.length(); i++) {
            grid[row][col + i] = word.charAt(i);
        }
    }

    private static void placeWordVertically(char[][] grid, String word, Random random) {
        int row = random.nextInt(GRID_SIZE - word.length());
        int col = random.nextInt(GRID_SIZE);
        for (int i = 0; i < word.length(); i++) {
            grid[row + i][col] = word.charAt(i);
        }
    }

    private static void printGrid(char[][] grid) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
