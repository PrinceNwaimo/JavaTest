package leetCodeProblems;
import java.util.Arrays;
public class SetMatrixZero {
        /**
         * Sets entire rows and columns to zero if any element in that row or column is zero.
         * Modifies the matrix in-place.
         *
         * @param matrix the m x n matrix to modify
         */
        public void setZeroes(int[][] matrix) {
            // Handle edge cases
            if (matrix == null || matrix.length == 0) {
                return;
            }

            // Handle 1x1 matrix
            if (matrix.length == 1 && matrix[0].length == 1) {
                return;
            }

            int rows = matrix.length;
            int cols = matrix[0].length;

            // Track which rows and columns contain zeros
            boolean[] rowsWithZero = new boolean[rows];
            boolean[] colsWithZero = new boolean[cols];

            // First pass: identify rows and columns that need to be zeroed
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == 0) {
                        rowsWithZero[i] = true;
                        colsWithZero[j] = true;
                    }
                }
            }

            // Second pass: set zeros
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (rowsWithZero[i] || colsWithZero[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        /**
         * Optimized version using first row and first column as markers (O(1) space)
         */
        public void setZeroesOptimized(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }

            int rows = matrix.length;
            int cols = matrix[0].length;

            boolean firstRowHasZero = false;
            boolean firstColHasZero = false;

            // Check if first row has zero
            for (int j = 0; j < cols; j++) {
                if (matrix[0][j] == 0) {
                    firstRowHasZero = true;
                    break;
                }
            }

            // Check if first column has zero
            for (int i = 0; i < rows; i++) {
                if (matrix[i][0] == 0) {
                    firstColHasZero = true;
                    break;
                }
            }

            // Use first row and column as markers
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
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
         * Alternative: Using sets (similar to original but with HashSet)
         */
        public void setZeroesWithSets(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }

            int rows = matrix.length;
            int cols = matrix[0].length;

            java.util.Set<Integer> zeroRows = new java.util.HashSet<>();
            java.util.Set<Integer> zeroCols = new java.util.HashSet<>();

            // First pass: identify zeros
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == 0) {
                        zeroRows.add(i);
                        zeroCols.add(j);
                    }
                }
            }

            // Second pass: set zeros
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (zeroRows.contains(i) || zeroCols.contains(j)) {
                        matrix[i][j] = 0;
                    }
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
            SetMatrixZero smz = new SetMatrixZero();

            System.out.println("=== Set Matrix Zeroes ===");
            System.out.println();

            // Test case 1: Standard matrix with zeros
            int[][] matrix1 = {
                    {1, 2, 3},
                    {4, 0, 6},
                    {7, 8, 9}
            };
            System.out.println("Test 1: Standard 3x3 matrix with one zero:");
            System.out.println("Original:");
            printMatrix(matrix1);
            smz.setZeroes(matrix1);
            System.out.println("After setZeroes:");
            printMatrix(matrix1);
            System.out.println();

            // Test case 2: Matrix with multiple zeros
            int[][] matrix2 = {
                    {0, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 0, 12},
                    {13, 14, 15, 16}
            };
            System.out.println("Test 2: 4x4 matrix with multiple zeros:");
            System.out.println("Original:");
            printMatrix(matrix2);
            smz.setZeroes(matrix2);
            System.out.println("After setZeroes:");
            printMatrix(matrix2);
            System.out.println();

            // Test case 3: Matrix with all zeros
            int[][] matrix3 = {
                    {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
            };
            System.out.println("Test 3: All zeros matrix:");
            System.out.println("Original:");
            printMatrix(matrix3);
            smz.setZeroes(matrix3);
            System.out.println("After setZeroes:");
            printMatrix(matrix3);
            System.out.println();

            // Test case 4: No zeros
            int[][] matrix4 = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            System.out.println("Test 4: No zeros matrix:");
            System.out.println("Original:");
            printMatrix(matrix4);
            smz.setZeroes(matrix4);
            System.out.println("After setZeroes (should be unchanged):");
            printMatrix(matrix4);
            System.out.println();

            // Test case 5: 1xN matrix
            int[][] matrix5 = {
                    {1, 0, 3, 4, 5}
            };
            System.out.println("Test 5: 1x5 matrix:");
            System.out.println("Original:");
            printMatrix(matrix5);
            smz.setZeroes(matrix5);
            System.out.println("After setZeroes:");
            printMatrix(matrix5);
            System.out.println();

            // Test case 6: Mx1 matrix
            int[][] matrix6 = {
                    {1},
                    {0},
                    {3},
                    {4}
            };
            System.out.println("Test 6: 4x1 matrix:");
            System.out.println("Original:");
            printMatrix(matrix6);
            smz.setZeroes(matrix6);
            System.out.println("After setZeroes:");
            printMatrix(matrix6);
            System.out.println();

            // Test optimized version
            System.out.println("=== Optimized Version (O(1) space) ===");
            int[][] matrix7 = {
                    {1, 2, 3, 4},
                    {5, 0, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            System.out.println("Original:");
            printMatrix(matrix7);
            smz.setZeroesOptimized(matrix7);
            System.out.println("After optimized setZeroes:");
            printMatrix(matrix7);
            System.out.println();

            // Test with sets version
            System.out.println("=== Set-Based Version ===");
            int[][] matrix8 = {
                    {1, 2, 3},
                    {4, 0, 6},
                    {7, 8, 9}
            };
            System.out.println("Original:");
            printMatrix(matrix8);
            smz.setZeroesWithSets(matrix8);
            System.out.println("After setZeroesWithSets:");
            printMatrix(matrix8);
            System.out.println();

            // Edge cases
            System.out.println("=== Edge Cases ===");
            int[][] emptyMatrix = {};
            System.out.println("Empty matrix:");
            smz.setZeroes(emptyMatrix);
            printMatrix(emptyMatrix);

            int[][] nullMatrix = null;
            System.out.println("Null matrix:");
            smz.setZeroes(nullMatrix);
            printMatrix(nullMatrix);

            int[][] oneByOne = {{5}};
            System.out.println("1x1 matrix:");
            printMatrix(oneByOne);
            smz.setZeroes(oneByOne);
            System.out.println("After setZeroes (should be unchanged):");
            printMatrix(oneByOne);
        }
    }
