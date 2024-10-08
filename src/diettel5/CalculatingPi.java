package diettel5;

public class CalculatingPi {
    public static void main(String[] args) {
        int terms = 200000;
        double pi = 0.0;
        boolean plus = true;

        System.out.println("Terms\tValue of Pi");
        for (int i = 1; i <= terms; i++) {
            if (plus) {
                pi += 4.0 / (2 * i - 1);
            } else {
                pi -= 4.0 / (2 * i - 1);
            }
            plus = !plus;

            if (i % 1000 == 0) {
                System.out.println(i + "\t" + pi);
            }
        }

        System.out.println("\nFinal Value of Pi: " + pi);
        System.out.println("Math.PI: " + Math.PI);
    }

}
