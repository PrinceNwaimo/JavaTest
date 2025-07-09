package liangMultiArrays;

public class CheckSudokuSolution2 {
    public static void main(String[] args) {
        int[][] grid = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        System.out.println(isValidSudoku(grid) ? "Valid solution" : "Invalid solution");
    }

    public static boolean isValidSudoku(int[][] grid) {
        // Check rows
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || seen[grid[i][j] - 1]) {
                    return false;
                }
                seen[grid[i][j] - 1] = true;
            }
        }

        // Check columns
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || seen[grid[i][j] - 1]) {
                    return false;
                }
                seen[grid[i][j] - 1] = true;
            }
        }

        // Check small boxes
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] seen = new boolean[9];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        int num = grid[i + x][j + y];
                        if (num < 1 || num > 9 || seen[num - 1]) {
                            return false;
                        }
                        seen[num - 1] = true;
                    }
                }
            }
        }

        return true;
    }

}
