package leetCodeProblems;
import java.util.Arrays;

public class ConstantSpace {
        /**
         * Sets entire rows and columns to zero if any element in that row or column is zero.
         * Uses O(1) space by using the first row and first column as markers.
         * Modifies the matrix in-place.
         *
         * @param matrix the m x n matrix to modify
         */
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }

            int rows = matrix.length;
            int cols = matrix[0].length;

            // Check if first row has a zero
            boolean firstRowHasZero = false;
            for (int j = 0; j < cols; j++) {
                if (matrix[0][j] == 0) {
                    firstRowHasZero = true;
                    break;
                }
            }

            // Check if first column has a zero
            boolean firstColHasZero = false;
            for (int i = 0; i < rows; i++) {
                if (matrix[i][0] == 0) {
                    firstColHasZero = true;
                    break;
                }
            }

            // Use first row and column as markers
            // Start from index 1 to avoid overwriting markers
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;  // Mark the row
                        matrix[0][j] = 0;  // Mark the column
                    }
                }
            }

            // Set zeros based on markers
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

            // Set first row to zero if needed
            if (firstRowHasZero) {
                for (int j = 0; j < cols; j++) {
                    matrix[0][j] = 0;
                }
            }

            // Set first column to zero if needed
            if (firstColHasZero) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][0] = 0;
                }
            }
        }

        /**
         * Alternative implementation with clearer variable names
         */
        public void setZeroesClear(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }

            int m = matrix.length;
            int n = matrix[0].length;

            boolean firstRowZero = false;
            boolean firstColZero = false;

            // Check first row
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    firstRowZero = true;
                    break;
                }
            }

            // Check first column
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    firstColZero = true;
                    break;
                }
            }

            // Mark zeros on first row and column
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            // Set zeros based on markers
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

            // Set first row to zero
            if (firstRowZero) {
                for (int j = 0; j < n; j++) {
                    matrix[0][j] = 0;
                }
            }

            // Set first column to zero
            if (firstColZero) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
        }

        /**
         * Utility method to print a matrix
         */
        public static void printMatrix(int[][] matrix) {
            if (matrix == null) {
                System.out.println("null");
                return;
            }
            for (int[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }
        }

        /**
         * Creates a copy of a matrix for testing
         */
        public static int[][] copyMatrix(int[][] matrix) {
            if (matrix == null) {
                return null;
            }
            int rows = matrix.length;
            int cols = matrix[0].length;
            int[][] copy = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                System.arraycopy(matrix[i], 0, copy[i], 0, cols);
            }
            return copy;
        }

        public static void main(String[] args) {
            ConstantSpace cs = new ConstantSpace();

            System.out.println("=== Set Matrix Zeroes (O(1) Space) ===");
            System.out.println();

            // Test case 1: Standard matrix with zeros
            int[][] matrix1 = {
                    {1, 2, 3, 4},
                    {5, 0, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            };
            System.out.println("Test 1: 4x4 matrix with one zero:");
            System.out.println("Original:");
            printMatrix(matrix1);
            cs.setZeroes(matrix1);
            System.out.println("After setZeroes:");
            printMatrix(matrix1);
            System.out.println();

            // Test case 2: Matrix with first row zero
            int[][] matrix2 = {
                    {0, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            };
            System.out.println("Test 2: Matrix with first row zero:");
            System.out.println("Original:");
            printMatrix(matrix2);
            cs.setZeroes(matrix2);
            System.out.println("After setZeroes:");
            printMatrix(matrix2);
            System.out.println();

            // Test case 3: Matrix with first column zero
            int[][] matrix3 = {
                    {1, 2, 3, 4},
                    {0, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            };
            System.out.println("Test 3: Matrix with first column zero:");
            System.out.println("Original:");
            printMatrix(matrix3);
            cs.setZeroes(matrix3);
            System.out.println("After setZeroes:");
            printMatrix(matrix3);
            System.out.println();

            // Test case 4: Matrix with multiple zeros
            int[][] matrix4 = {
                    {0, 2, 3, 0},
                    {5, 6, 7, 8},
                    {9, 0, 11, 12},
                    {13, 14, 15, 16}
            };
            System.out.println("Test 4: Matrix with multiple zeros:");
            System.out.println("Original:");
            printMatrix(matrix4);
            cs.setZeroes(matrix4);
            System.out.println("After setZeroes:");
            printMatrix(matrix4);
            System.out.println();

            // Test case 5: All zeros
            int[][] matrix5 = {
                    {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
            };
            System.out.println("Test 5: All zeros matrix:");
            System.out.println("Original:");
            printMatrix(matrix5);
            cs.setZeroes(matrix5);
            System.out.println("After setZeroes:");
            printMatrix(matrix5);
            System.out.println();

            // Test case 6: No zeros
            int[][] matrix6 = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            System.out.println("Test 6: No zeros matrix:");
            System.out.println("Original:");
            printMatrix(matrix6);
            cs.setZeroes(matrix6);
            System.out.println("After setZeroes (should be unchanged):");
            printMatrix(matrix6);
            System.out.println();

            // Test case 7: 1xN matrix
            int[][] matrix7 = {
                    {1, 0, 3, 4, 5}
            };
            System.out.println("Test 7: 1x5 matrix with zero:");
            System.out.println("Original:");
            printMatrix(matrix7);
            cs.setZeroes(matrix7);
            System.out.println("After setZeroes:");
            printMatrix(matrix7);
            System.out.println();

            // Test case 8: Mx1 matrix
            int[][] matrix8 = {
                    {1},
                    {0},
                    {3},
                    {4},
                    {5}
            };
            System.out.println("Test 8: 5x1 matrix with zero:");
            System.out.println("Original:");
            printMatrix(matrix8);
            cs.setZeroes(matrix8);
            System.out.println("After setZeroes:");
            printMatrix(matrix8);
            System.out.println();

            // Test case 9: Matrix where first row and column have zeros
            int[][] matrix9 = {
                    {0, 2, 3},
                    {4, 0, 6},
                    {7, 8, 9}
            };
            System.out.println("Test 9: Matrix with first row and column zeros:");
            System.out.println("Original:");
            printMatrix(matrix9);
            cs.setZeroes(matrix9);
            System.out.println("After setZeroes:");
            printMatrix(matrix9);
            System.out.println();

            // Edge cases
            System.out.println("=== Edge Cases ===");
            int[][] emptyMatrix = {};
            System.out.println("Empty matrix:");
            cs.setZeroes(emptyMatrix);
            printMatrix(emptyMatrix);
            System.out.println();

            int[][] nullMatrix = null;
            System.out.println("Null matrix:");
            cs.setZeroes(nullMatrix);
            printMatrix(nullMatrix);
        }
    }