package diettel5;

public class TrianglePrintingProgram {
    public static void main(String[] args) {
        int rows = 5;

        // Pattern 1: Right-aligned triangle
        System.out.println("Pattern 1:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println();

        // Pattern 2: Left-aligned triangle
        System.out.println("Pattern 2:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println();

        // Pattern 3: Inverted right-aligned triangle
        System.out.println("Pattern 3:");
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println();

        // Pattern 4: Right-aligned triangle with spaces
        System.out.println("Pattern 4:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(' ');
            }
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println();

        // Pattern 5: Inverted right-aligned triangle with spaces
        System.out.println("Pattern 5:");
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(' ');
            }
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

}
