package diettel5;

public class DeMorgansLaws {
    public static void main(String[] args) {
        int x = 3, y = 10, a = 2, b = 2, g = 5, i = 3, j = 7;

        // Test a
        System.out.println("!(x < 5) && !(y >= 7): " + (!(x < 5) && !(y >= 7)));
        System.out.println("(x >= 5) || (y < 7): " + ((x >= 5) || (y < 7)));
        System.out.println();

        // Test b
        System.out.println("!(a == b) || !(g != 5): " + (!(a == b) || !(g != 5)));
        System.out.println("(a != b) && (g == 5): " + ((a != b) && (g == 5)));
        System.out.println();

        // Test c
        System.out.println("!((x <= 8) && (y > 4)): " + !((x <= 8) && (y > 4)));
        System.out.println("(x > 8) || (y <= 4): " + ((x > 8) || (y <= 4)));
        System.out.println();

        // Test d
        System.out.println("!((i > 4) || (j <= 6)): " + !((i > 4) || (j <= 6)));
        System.out.println("(i <= 4) && (j > 6): " + ((i <= 4) && (j > 6)));
    }

}
