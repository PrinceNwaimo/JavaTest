package leetCodeProblems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    /**
     * Returns the elements of the matrix in spiral order.
     *
     * @param matrix the 2D matrix
     * @return List of integers in spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // Handle edge cases
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;      // number of rows
        int n = matrix[0].length;   // number of columns

        List<Integer> spiral = new ArrayList<>();

        int rowStart = 0;           // starting row index
        int colStart = 0;           // starting column index
        int rowEnd = m - 1;         // ending row index
        int colEnd = n - 1;         // ending column index

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse from left to right along the top row
            for (int i = colStart; i <= colEnd; i++) {
                spiral.add(matrix[rowStart][i]);
            }
            rowStart++;

            // Traverse from top to bottom along the right column
            for (int i = rowStart; i <= rowEnd; i++) {
                spiral.add(matrix[i][colEnd]);
            }
            colEnd--;

            // Traverse from right to left along the bottom row
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    spiral.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // Traverse from bottom to top along the left column
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    spiral.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }

        return spiral;
    }

    /**
     * Alternative implementation using direction vectors
     */
    public List<Integer> spiralOrderDirection(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> spiral = new ArrayList<>();

        // Direction vectors: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0; // 0: right, 1: down, 2: left, 3: up

        int row = 0;
        int col = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m * n; i++) {
            spiral.add(matrix[row][col]);
            visited[row][col] = true;

            int nextRow = row + directions[dir][0];
            int nextCol = col + directions[dir][1];

            // Change direction if next position is out of bounds or already visited
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                dir = (dir + 1) % 4;
                nextRow = row + directions[dir][0];
                nextCol = col + directions[dir][1];
            }

            row = nextRow;
            col = nextCol;
        }

        return spiral;
    }

    /**
     * Alternative implementation using recursive approach
     */
    public List<Integer> spiralOrderRecursive(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> spiral = new ArrayList<>();
        spiralRecursive(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, spiral);
        return spiral;
    }

    private void spiralRecursive(int[][] matrix, int rowStart, int colStart,
                                 int rowEnd, int colEnd, List<Integer> spiral) {
        if (rowStart > rowEnd || colStart > colEnd) {
            return;
        }

        // Traverse top row
        for (int i = colStart; i <= colEnd; i++) {
            spiral.add(matrix[rowStart][i]);
        }

        // Traverse right column
        for (int i = rowStart + 1; i <= rowEnd; i++) {
            spiral.add(matrix[i][colEnd]);
        }

        // Traverse bottom row (if not same as top row)
        if (rowStart < rowEnd) {
            for (int i = colEnd - 1; i >= colStart; i--) {
                spiral.add(matrix[rowEnd][i]);
            }
        }

        // Traverse left column (if not same as right column)
        if (colStart < colEnd) {
            for (int i = rowEnd - 1; i > rowStart; i--) {
                spiral.add(matrix[i][colStart]);
            }
        }

        // Recursively process inner layer
        spiralRecursive(matrix, rowStart + 1, colStart + 1, rowEnd - 1, colEnd - 1, spiral);
    }

    /**
     * Generates a spiral matrix from a list of values
     */
    public int[][] generateSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n <= 0) {
            return matrix;
        }

        int rowStart = 0;
        int colStart = 0;
        int rowEnd = n - 1;
        int colEnd = n - 1;
        int value = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Fill top row
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = value++;
            }
            rowStart++;

            // Fill right column
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = value++;
            }
            colEnd--;

            // Fill bottom row
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    matrix[rowEnd][i] = value++;
                }
            }
            rowEnd--;

            // Fill left column
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart] = value++;
                }
            }
            colStart++;
        }

        return matrix;
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
     * Utility method to print a list
     */
    public static void printList(List<Integer> list) {
        System.out.println(list);
    }

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();

        System.out.println("=== Spiral Matrix Traversal ===");
        System.out.println();

        // Test case 1: 3x3 matrix
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Test 1: 3x3 matrix");
        printMatrix(matrix1);
        System.out.println("Spiral order: " + sm.spiralOrder(matrix1));
        System.out.println();

        // Test case 2: 4x4 matrix
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println("Test 2: 4x4 matrix");
        printMatrix(matrix2);
        System.out.println("Spiral order: " + sm.spiralOrder(matrix2));
        System.out.println();

        // Test case 3: 3x4 matrix (rectangular)
        int[][] matrix3 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println("Test 3: 3x4 matrix (rectangular)");
        printMatrix(matrix3);
        System.out.println("Spiral order: " + sm.spiralOrder(matrix3));
        System.out.println();

        // Test case 4: 4x3 matrix (rectangular)
        int[][] matrix4 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        System.out.println("Test 4: 4x3 matrix (rectangular)");
        printMatrix(matrix4);
        System.out.println("Spiral order: " + sm.spiralOrder(matrix4));
        System.out.println();

        // Test case 5: 1x5 matrix
        int[][] matrix5 = {
                {1, 2, 3, 4, 5}
        };
        System.out.println("Test 5: 1x5 matrix");
        printMatrix(matrix5);
        System.out.println("Spiral order: " + sm.spiralOrder(matrix5));
        System.out.println();

        // Test case 6: 5x1 matrix
        int[][] matrix6 = {
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        System.out.println("Test 6: 5x1 matrix");
        printMatrix(matrix6);
        System.out.println("Spiral order: " + sm.spiralOrder(matrix6));
        System.out.println();

        // Test case 7: Empty matrix
        int[][] emptyMatrix = {};
        System.out.println("Test 7: Empty matrix");
        System.out.println("Spiral order: " + sm.spiralOrder(emptyMatrix));
        System.out.println();

        // Test case 8: Null matrix
        System.out.println("Test 8: Null matrix");
        System.out.println("Spiral order: " + sm.spiralOrder(null));
        System.out.println();

        // Test with direction-based approach
        System.out.println("=== Direction-Based Approach ===");
        int[][] matrix7 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println("Original matrix:");
        printMatrix(matrix7);
        System.out.println("Spiral order (direction): " + sm.spiralOrderDirection(matrix7));
        System.out.println();

        // Test with recursive approach
        System.out.println("=== Recursive Approach ===");
        int[][] matrix8 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println("Spiral order (recursive): " + sm.spiralOrderRecursive(matrix8));
        System.out.println();

        // Test spiral matrix generation
        System.out.println("=== Spiral Matrix Generation ===");
        for (int n = 1; n <= 5; n++) {
            System.out.println("Generated " + n + "x" + n + " spiral matrix:");
            int[][] generated = sm.generateSpiralMatrix(n);
            printMatrix(generated);
            System.out.println("Spiral order: " + sm.spiralOrder(generated));
            System.out.println();
        }
    }
}
