package liang5;

public class PyramidPattern {
    public static void main(String[] args) {
        int rows = 8;  // Number of rows for the pyramid

        for (int i = 0; i < rows; i++) {
            // Print leading spaces for alignment
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print("   ");
            }

            // Print increasing powers of 2 on the left side
            for (int j = 0; j <= i; j++) {
                System.out.printf("%3d ", (int) Math.pow(2, j));
            }

            // Print decreasing powers of 2 on the right side
            for (int j = i - 1; j >= 0; j--) {
                System.out.printf("%3d ", (int) Math.pow(2, j));
            }

            // Move to the next line
            System.out.println();
        }
    }
}
