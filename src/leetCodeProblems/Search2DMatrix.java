package leetCodeProblems;
import java.util.Arrays;

public class Search2DMatrix {
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
            if (target == matrix[row][col]) {
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
     * Works when each row is sorted individually
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
     * Alternative implementation treating the matrix as a flattened sorted array
     * Works when matrix is sorted row-wise and column-wise
     */
    public boolean searchMatrixFlattened(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    /**
     * Searches using row-wise binary search with column selection
     */
    public boolean searchMatrixRowBinary(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Find the row that might contain the target
        int top = 0;
        int bottom = rows - 1;
        int row = -1;

        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][cols - 1]) {
                row = mid;
                break;
            } else if (target < matrix[mid][0]) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }

        if (row == -1) {
            return false;
        }

        // Binary search in the found row
        return Arrays.binarySearch(matrix[row], target) >= 0;
    }

    /**
     * Utility method to print the search result
     */
    public static void printSearchResult(int[][] matrix, int target, boolean result) {
        System.out.println("Searching for " + target + " in matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Result: " + (result ? "FOUND ✓" : "NOT FOUND ✗"));
        System.out.println();
    }

    public static void main(String[] args) {
        Search2DMatrix sm = new Search2DMatrix();

        // Test matrix (sorted rows and columns)
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println("=== Search in 2D Matrix ===");
        System.out.println();

        // Test cases
        int[] testTargets = {5, 20, 1, 30, 25, 17, 0, 35};

        for (int target : testTargets) {
            boolean result = sm.searchMatrix(matrix, target);
            printSearchResult(matrix, target, result);
        }

        // Test with different matrices
        System.out.println("=== Additional Test Cases ===");
        System.out.println();

        // Test 1: 3x3 matrix
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Test 1: 3x3 matrix");
        System.out.println("Searching for 5: " + sm.searchMatrix(matrix1, 5));
        System.out.println("Searching for 10: " + sm.searchMatrix(matrix1, 10));
        System.out.println();

        // Test 2: 1xN matrix
        int[][] matrix2 = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };
        System.out.println("Test 2: 1x10 matrix");
        System.out.println("Searching for 7: " + sm.searchMatrix(matrix2, 7));
        System.out.println("Searching for 0: " + sm.searchMatrix(matrix2, 0));
        System.out.println("Searching for 11: " + sm.searchMatrix(matrix2, 11));
        System.out.println();

        // Test 3: Mx1 matrix
        int[][] matrix3 = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8},
                {9},
                {10}
        };
        System.out.println("Test 3: 10x1 matrix");
        System.out.println("Searching for 8: " + sm.searchMatrix(matrix3, 8));
        System.out.println("Searching for 0: " + sm.searchMatrix(matrix3, 0));
        System.out.println("Searching for 11: " + sm.searchMatrix(matrix3, 11));
        System.out.println();

        // Test 4: Empty matrix
        int[][] emptyMatrix = {};
        System.out.println("Test 4: Empty matrix");
        System.out.println("Searching for 5: " + sm.searchMatrix(emptyMatrix, 5));
        System.out.println();

        // Test 5: Null matrix
        System.out.println("Test 5: Null matrix");
        System.out.println("Searching for 5: " + sm.searchMatrix(null, 5));
        System.out.println();

        // Compare different implementations
        System.out.println("=== Comparing Implementations ===");
        int[][] testMatrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int testTarget = 16;
        System.out.println("Matrix:");
        for (int[] row : testMatrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Target: " + testTarget);
        System.out.println("Staircase method: " + sm.searchMatrix(testMatrix, testTarget));
        System.out.println("Binary search rows: " + sm.searchMatrixBinarySearch(testMatrix, testTarget));
        System.out.println("Flattened binary search: " + sm.searchMatrixFlattened(testMatrix, testTarget));
        System.out.println("Row binary search: " + sm.searchMatrixRowBinary(testMatrix, testTarget));
    }
}
