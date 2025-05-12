package joyceUsingLoops;

public class DiagonalOs {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // Print spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // Print 'O'
            System.out.println("O");
        }
    }

}
