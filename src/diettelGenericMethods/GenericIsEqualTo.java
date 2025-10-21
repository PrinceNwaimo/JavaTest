package diettelGenericMethods;

public class GenericIsEqualTo {

    // Generic method to compare two values using equals()
    public static <T> boolean isEqualTo(T x, T y) {
        return x.equals(y);
    }

    public static void main(String[] args) {
        // Integer comparison
        Integer num1 = 100;
        Integer num2 = 100;
        Integer num3 = 200;

        System.out.printf("isEqualTo(%d, %d): %b%n", num1, num2, isEqualTo(num1, num2));
        System.out.printf("isEqualTo(%d, %d): %b%n", num1, num3, isEqualTo(num1, num3));

        // String comparison
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "World";

        System.out.printf("isEqualTo(\"%s\", \"%s\"): %b%n", s1, s2, isEqualTo(s1, s2));
        System.out.printf("isEqualTo(\"%s\", \"%s\"): %b%n", s1, s3, isEqualTo(s1, s3));

        // Double comparison
        Double d1 = 5.5;
        Double d2 = 5.5;
        Double d3 = 7.7;

        System.out.printf("isEqualTo(%.1f, %.1f): %b%n", d1, d2, isEqualTo(d1, d2));
        System.out.printf("isEqualTo(%.1f, %.1f): %b%n", d1, d3, isEqualTo(d1, d3));

        // Object comparison (different references)
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = obj1; // same reference

        System.out.printf("isEqualTo(obj1, obj2): %b%n", isEqualTo(obj1, obj2));
        System.out.printf("isEqualTo(obj1, obj3): %b%n", isEqualTo(obj1, obj3));
    }
}

