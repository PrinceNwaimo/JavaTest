package leetCodeProblems;
import java.util.Arrays;

public class RotateImage {
    /**
     * Rotates the matrix 90 degrees clockwise in-place.
     *
     * @param matrix the n x n matrix to rotate
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int n = matrix.length;

        // Process each layer from outside to inside
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                // Save top element
                int top = matrix[first][i];

                // Left -> Top
                matrix[first][i] = matrix[last - offset][first];

                // Bottom -> Left
                matrix[last - offset][first] = matrix[last][last - offset];

                // Right -> Bottom
                matrix[last][last - offset] = matrix[i][last];

                // Top -> Right
                matrix[i][last] = top;
            }
        }
    }

    /**
     * Alternative implementation: Rotate by transposing and reversing
     */
    public void rotateTransposeReverse(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    /**
     * Rotates the matrix 90 degrees counter-clockwise
     */
    public void rotateCounterClockwise(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int n = matrix.length;

        // Process each layer from outside to inside
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                // Save top element
                int top = matrix[first][i];

                // Right -> Top
                matrix[first][i] = matrix[i][last];

                // Bottom -> Right
                matrix[i][last] = matrix[last][last - offset];

                // Left -> Bottom
                matrix[last][last - offset] = matrix[last - offset][first];

                // Top -> Left
                matrix[last - offset][first] = top;
            }
        }
    }

    /**
     * Rotates the matrix 180 degrees
     */
    public void rotate180(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = temp;
            }
        }

        // If n is odd, handle the middle row
        if (n % 2 == 1) {
            int mid = n / 2;
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[mid][j];
                matrix[mid][j] = matrix[mid][n - 1 - j];
                matrix[mid][n - 1 - j] = temp;
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

    public static void main(String[] args) {
        RotateImage ri = new RotateImage();

        System.out.println("=== Rotate Image 90 Degrees Clockwise ===");
        System.out.println();

        // Test case 1: 3x3 matrix
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Original 3x3 matrix:");
        printMatrix(matrix1);
        ri.rotate(matrix1);
        System.out.println("After 90° clockwise rotation:");
        printMatrix(matrix1);
        System.out.println();

        // Test case 2: 4x4 matrix
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println("Original 4x4 matrix:");
        printMatrix(matrix2);
        ri.rotate(matrix2);
        System.out.println("After 90° clockwise rotation:");
        printMatrix(matrix2);
        System.out.println();

        // Test case 3: 2x2 matrix
        int[][] matrix3 = {
                {1, 2},
                {3, 4}
        };
        System.out.println("Original 2x2 matrix:");
        printMatrix(matrix3);
        ri.rotate(matrix3);
        System.out.println("After 90° clockwise rotation:");
        printMatrix(matrix3);
        System.out.println();

        // Test case 4: 1x1 matrix
        int[][] matrix4 = {{5}};
        System.out.println("Original 1x1 matrix:");
        printMatrix(matrix4);
        ri.rotate(matrix4);
        System.out.println("After 90° clockwise rotation:");
        printMatrix(matrix4);
        System.out.println();

        // Test using transpose + reverse method
        System.out.println("=== Using Transpose + Reverse Method ===");
        int[][] matrix5 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Original matrix:");
        printMatrix(matrix5);
        ri.rotateTransposeReverse(matrix5);
        System.out.println("After rotation (transpose + reverse):");
        printMatrix(matrix5);
        System.out.println();

        // Test counter-clockwise rotation
        System.out.println("=== Counter-Clockwise Rotation ===");
        int[][] matrix6 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Original matrix:");
        printMatrix(matrix6);
        ri.rotateCounterClockwise(matrix6);
        System.out.println("After 90° counter-clockwise rotation:");
        printMatrix(matrix6);
        System.out.println();

        // Test 180-degree rotation
        System.out.println("=== 180-Degree Rotation ===");
        int[][] matrix7 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Original matrix:");
        printMatrix(matrix7);
        ri.rotate180(matrix7);
        System.out.println("After 180° rotation:");
        printMatrix(matrix7);
        System.out.println();

        // Edge cases
        System.out.println("=== Edge Cases ===");
        int[][] emptyMatrix = {};
        System.out.println("Empty matrix:");
        ri.rotate(emptyMatrix);
        printMatrix(emptyMatrix);

        int[][] nullMatrix = null;
        System.out.println("Null matrix:");
        ri.rotate(nullMatrix);
        printMatrix(nullMatrix);
    }
}
