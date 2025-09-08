package diettelException;

public class OtherScopes {
    public static void main(String[] args) {
        try {
            method1();
        } catch (ArithmeticException e) {
            System.out.println("Caught exception in main: " + e.getMessage());
        }
    }

    private static void method1() {
        method2();
    }

    private static void method2() {
        try {
            int result = 10 / 0;
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException in method2");
        }
    }
}
