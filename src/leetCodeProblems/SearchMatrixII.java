package leetCodeProblems;
import java.util.Arrays;

public class SearchMatrixII {
    /**
     * Searches for a target value in a 2D matrix where rows are sorted left to right,
     * and columns are sorted top to bottom.
     * Uses the "staircase" search approach starting from the top-right corner.
     *
     * @param matrix the 2D matrix to search
     * @param target the value to search for
     * @return true if target is found, false otherwise
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // Handle empty matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Quick bounds check
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }

        // Start from the top-right corner
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (target > matrix[row][col]) {
                // Target is larger, move down
                row++;
            } else {
                // Target is smaller, move left
                col--;
            }
        }

        return false;
    }

    /**
     * Alternative implementation using binary search on each row
     */
    public boolean searchMatrixBinarySearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int[] row : matrix) {
            if (Arrays.binarySearch(row, target) >= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Searches using divide and conquer approach
     */
    public boolean searchMatrixDivideConquer(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return searchMatrixRecursive(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private boolean searchMatrixRecursive(int[][] matrix, int target,
                                          int rowStart, int rowEnd,
                                          int colStart, int colEnd) {
        if (rowStart > rowEnd || colStart > colEnd) {
            return false;
        }

        // Check if target is within bounds of this submatrix
        if (target < matrix[rowStart][colStart] || target > matrix[rowEnd][colEnd]) {
            return false;
        }

        // Find the middle row
        int midRow = rowStart + (rowEnd - rowStart) / 2;

        // Find where target would be in the middle row
        int col = colStart;
        while (col <= colEnd && matrix[midRow][col] < target) {
            col++;
        }

        if (col <= colEnd && matrix[midRow][col] == target) {
            return true;
        }

        // Search top-right and bottom-left quadrants
        return searchMatrixRecursive(matrix, target, rowStart, midRow - 1, col, colEnd) ||
                searchMatrixRecursive(matrix, target, midRow + 1, rowEnd, colStart, col - 1);
    }

    /**
     * Searches starting from bottom-left corner instead of top-right
     */
    public boolean searchMatrixBottomLeft(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Quick bounds check
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }

        // Start from the bottom-left corner
        int row = rows - 1;
        int col = 0;

        while (row >= 0 && col < cols) {
            if (matrix[row][col] == target) {
                return true;
            } else if (target > matrix[row][col]) {
                // Target is larger, move right
                col++;
            } else {
                // Target is smaller, move up
                row--;
            }
        }

        return false;
    }

    /**
     * Utility method to print search result
     */
    public static void printSearchResult(int[][] matrix, int target, boolean result) {
        System.out.println("Searching for " + target + " in matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Result: " + (result ? "FOUND ✓" : "NOT FOUND ✗"));
        System.out.println();
    }

    /**
     * Prints matrix with search path visualization
     */
    public static void printSearchPath(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("Matrix is empty");
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] path = new char[rows][cols];

        // Initialize with dots
        for (int i = 0; i < rows; i++) {
            Arrays.fill(path[i], '.');
        }

        // Simulate search to mark path
        int row = 0;
        int col = cols - 1;
        boolean found = false;

        while (row < rows && col >= 0) {
            path[row][col] = '*';
            if (target == matrix[row][col]) {
                found = true;
                break;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }

        // Print the matrix with path
        System.out.println("Search path for target " + target + " (top-right approach):");
        System.out.println("Legend: * = visited, F = found\n");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String value = String.format("%3d", matrix[i][j]);
                if (found && i == row && j == col && path[i][j] == '*') {
                    System.out.print(" F  ");
                } else if (path[i][j] == '*') {
                    System.out.print(" *  ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
        System.out.println("Found: " + found);
        System.out.println();
    }

    public static void main(String[] args) {
        SearchMatrixII sm = new SearchMatrixII();

        // Test matrix (sorted rows and columns)
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println("=== Search in 2D Matrix II ===");
        System.out.println();

        // Test with visualization
        printSearchPath(matrix, 16);

        // Test cases
        int[] testTargets = {5, 20, 1, 30, 25, 17, 0, 35};

        for (int target : testTargets) {
            boolean result = sm.searchMatrix(matrix, target);
            printSearchResult(matrix, target, result);
        }

        // Test different implementations
        System.out.println("=== Comparing Implementations ===");
        System.out.println();

        int[][] testMatrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int testTarget = 16;
        System.out.println("Testing with matrix:");
        for (int[] row : testMatrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Target: " + testTarget);
        System.out.println();
        System.out.println("Staircase (top-right): " + sm.searchMatrix(testMatrix, testTarget));
        System.out.println("Staircase (bottom-left): " + sm.searchMatrixBottomLeft(testMatrix, testTarget));
        System.out.println("Binary search rows: " + sm.searchMatrixBinarySearch(testMatrix, testTarget));
        System.out.println("Divide & conquer: " + sm.searchMatrixDivideConquer(testMatrix, testTarget));
        System.out.println();

        // Test edge cases
        System.out.println("=== Edge Cases ===");
        System.out.println();

        // Empty matrix
        int[][] emptyMatrix = {};
        System.out.println("Empty matrix:");
        System.out.println("Search for 5: " + sm.searchMatrix(emptyMatrix, 5));
        System.out.println();

        // Null matrix
        System.out.println("Null matrix:");
        System.out.println("Search for 5: " + sm.searchMatrix(null, 5));
        System.out.println();

        // 1x1 matrix
        int[][] single = {{5}};
        System.out.println("1x1 matrix:");
        System.out.println("Search for 5: " + sm.searchMatrix(single, 5));
        System.out.println("Search for 3: " + sm.searchMatrix(single, 3));
        System.out.println();

        // 1xN matrix
        int[][] row = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
        System.out.println("1x10 matrix:");
        System.out.println("Search for 7: " + sm.searchMatrix(row, 7));
        System.out.println("Search for 0: " + sm.searchMatrix(row, 0));
        System.out.println();

        // Mx1 matrix
        int[][] col = {{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}};
        System.out.println("10x1 matrix:");
        System.out.println("Search for 8: " + sm.searchMatrix(col, 8));
        System.out.println("Search for 0: " + sm.searchMatrix(col, 0));
    }
}
