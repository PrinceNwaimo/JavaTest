package leetCodeProblems;
import java.util.Arrays;

public class SpiralMatrixII {
    /**
     * Generates an n x n matrix filled with numbers from 1 to n^2 in spiral order.
     *
     * @param n the size of the matrix
     @return the generated spiral matrix
     */
    public int[][] generateMatrix(int n) {
        // Handle edge cases
        if (n <= 0) {
            return new int[0][0];
        }
        if (n == 1) {
            return new int[][]{{1}};
        }

        // Allocate a square matrix with all zeros
        int[][] matrix = new int[n][n];

        int rowStart = 0;           // starting row index
        int colStart = 0;           // starting column index
        int rowEnd = n - 1;         // ending row index
        int colEnd = n - 1;         // ending column index
        int count = 1;              // counter for elements

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse from left to right along the top row
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = count++;
            }
            rowStart++;

            // Traverse from top to bottom along the right column
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = count++;
            }
            colEnd--;

            // Traverse from right to left along the bottom row
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    matrix[rowEnd][i] = count++;
                }
            }
            rowEnd--;

            // Traverse from bottom to top along the left column
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart] = count++;
                }
            }
            colStart++;
        }

        return matrix;
    }

    /**
     * Alternative implementation that more closely follows the Python code
     */
    public int[][] generateMatrixPythonStyle(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        if (n == 1) {
            return new int[][]{{1}};
        }

        int[][] matrix = new int[n][n];
        int count = 1;
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = n;
        int colEnd = n;

        while (rowStart < rowEnd && colStart < colEnd) {
            // Traverse top row
            for (int i = colStart; i < colEnd; i++) {
                matrix[rowStart][i] = count++;
            }
            rowStart++;

            // Traverse right column
            for (int i = rowStart; i < rowEnd; i++) {
                matrix[i][colEnd - 1] = count++;
            }
            colEnd--;

            // Traverse bottom row
            if (rowStart < rowEnd) {
                for (int i = colEnd - 1; i >= colStart; i--) {
                    matrix[rowEnd - 1][i] = count++;
                }
                rowEnd--;
            }

            // Traverse left column
            if (colStart < colEnd) {
                for (int i = rowEnd - 1; i >= rowStart; i--) {
                    matrix[i][colStart] = count++;
                }
                colStart++;
            }
        }

        return matrix;
    }

    /**
     * Alternative implementation using direction vectors
     */
    public int[][] generateMatrixDirection(int n) {
        if (n <= 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];

        // Direction vectors: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0; // 0: right, 1: down, 2: left, 3: up

        int row = 0;
        int col = 0;
        int count = 1;

        for (int i = 0; i < n * n; i++) {
            matrix[row][col] = count++;

            int nextRow = row + directions[dir][0];
            int nextCol = col + directions[dir][1];

            // Change direction if next position is out of bounds or already filled
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] != 0) {
                dir = (dir + 1) % 4;
                nextRow = row + directions[dir][0];
                nextCol = col + directions[dir][1];
            }

            row = nextRow;
            col = nextCol;
        }

        return matrix;
    }

    /**
     * Alternative implementation using recursion
     */
    public int[][] generateMatrixRecursive(int n) {
        if (n <= 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];
        fillSpiral(matrix, 0, 0, n - 1, n - 1, 1);
        return matrix;
    }

    private void fillSpiral(int[][] matrix, int rowStart, int colStart,
                            int rowEnd, int colEnd, int count) {
        if (rowStart > rowEnd || colStart > colEnd) {
            return;
        }

        // Fill top row
        for (int i = colStart; i <= colEnd; i++) {
            matrix[rowStart][i] = count++;
        }

        // Fill right column
        for (int i = rowStart + 1; i <= rowEnd; i++) {
            matrix[i][colEnd] = count++;
        }

        // Fill bottom row
        if (rowStart < rowEnd) {
            for (int i = colEnd - 1; i >= colStart; i--) {
                matrix[rowEnd][i] = count++;
            }
        }

        // Fill left column
        if (colStart < colEnd) {
            for (int i = rowEnd - 1; i > rowStart; i--) {
                matrix[i][colStart] = count++;
            }
        }

        // Recursively fill inner layer
        fillSpiral(matrix, rowStart + 1, colStart + 1, rowEnd - 1, colEnd - 1, count);
    }

    /**
     * Utility method to print a matrix
     */
    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("Empty matrix");
            return;
        }
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * Utility method to print matrix with formatting
     */
    public static void printMatrixFormatted(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("Empty matrix");
            return;
        }

        int maxDigits = String.valueOf(matrix.length * matrix.length).length();
        String format = "%" + (maxDigits + 1) + "d";

        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf(format, value);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SpiralMatrixII sm = new SpiralMatrixII();

        System.out.println("=== Spiral Matrix II - Generate Spiral Matrix ===");
        System.out.println();

        // Test for different sizes
        int[] testSizes = {0, 1, 2, 3, 4, 5};

        for (int n : testSizes) {
            System.out.println("n = " + n);
            int[][] result = sm.generateMatrix(n);
            System.out.println("Generated " + n + "x" + n + " spiral matrix:");
            printMatrixFormatted(result);
            System.out.println();
        }

        // Test n = 6
        System.out.println("n = 6");
        int[][] result6 = sm.generateMatrix(6);
        System.out.println("Generated 6x6 spiral matrix:");
        printMatrixFormatted(result6);
        System.out.println();

        // Compare different implementations
        System.out.println("=== Comparing Implementations for n=4 ===");
        System.out.println();

        System.out.println("Standard implementation:");
        int[][] standard = sm.generateMatrix(4);
        printMatrixFormatted(standard);
        System.out.println();

        System.out.println("Python-style implementation:");
        int[][] pythonStyle = sm.generateMatrixPythonStyle(4);
        printMatrixFormatted(pythonStyle);
        System.out.println();

        System.out.println("Direction-based implementation:");
        int[][] direction = sm.generateMatrixDirection(4);
        printMatrixFormatted(direction);
        System.out.println();

        System.out.println("Recursive implementation:");
        int[][] recursive = sm.generateMatrixRecursive(4);
        printMatrixFormatted(recursive);
        System.out.println();

        // Verify all implementations produce the same result
        System.out.println("=== Verification ===");
        System.out.println("All implementations produce identical results: " +
                (Arrays.deepEquals(standard, pythonStyle) &&
                        Arrays.deepEquals(standard, direction) &&
                        Arrays.deepEquals(standard, recursive)));
    }
}
