package liangExceptionHandling;

public class OutOfMemoryErrorTest {
    public static void main(String[] args) {
        try {
            long[] array = new long[Integer.MAX_VALUE];
        } catch (OutOfMemoryError e) {
            System.out.println("Caught OutOfMemoryError: " + e.getMessage());
            System.out.println("Error occurred because the JVM ran out of memory.");
        }
    }
}
