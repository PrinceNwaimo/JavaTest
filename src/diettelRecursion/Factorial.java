package diettelRecursion;

public class Factorial {
    public static void main(String[] args) {
        factorial(5);
    }

    public static long factorial(int number) {
        return factorialHelper(number, 0);
    }

    private static long factorialHelper(int number, int level) {
        String indent = "";
        for (int i = 0; i < level; i++) {
            indent += "  ";
        }
        System.out.println(indent + "factorial(" + number + ")");

        if (number == 0 || number == 1) {
            System.out.println(indent + "  Returning 1");
            return 1;
        } else {
            long result = number * factorialHelper(number - 1, level + 1);
            System.out.println(indent + "  Returning " + number + " * factorial(" + (number - 1) + ") = " + result);
            return result;
        }
    }
}
