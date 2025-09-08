package diettelException;

public class CustomExceptionTest {
    public static void main(String[] args) {
        try {
            someMethod();
        } catch (CustomException e) {
            System.out.println("Caught rethrown exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void someMethod() throws CustomException {
        try {
            someMethod2();
        } catch (CustomException e) {
            System.out.println("Rethrowing exception");
            throw e;
        }
    }

    private static void someMethod2() throws CustomException {
        throw new CustomException("Initial exception");
    }
}
