package diettel5;

public class ModifiedTrianglePrintingProgram {
    public static void main(String[] args) {
        int rows = 5;

        // Print combined triangle patterns
        for (int i = 0; i < rows; i++) {
            // Left-aligned triangle
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.print("   ");

            // Right-aligned triangle
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(' ');
            }
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.print("   ");

            // Inverted left-aligned triangle
            for (int j = 0; j <= rows - i - 1; j++) {
                System.out.print('*');
            }
            System.out.print("   ");

            // Inverted right-aligned triangle
            for (int j = 0; j < i; j++) {
                System.out.print(' ');
            }
            for (int j = 0; j <= rows - i - 1; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

}
