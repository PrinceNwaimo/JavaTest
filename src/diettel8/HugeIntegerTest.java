package diettel8;

public class HugeIntegerTest {
    public static void main(String[] args) {
        HugeInteger num1 = HugeInteger.parse("1234567890123456789012345678901234567890");
        HugeInteger num2 = HugeInteger.parse("9876543210987654321098765432109876543210");

        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);

        HugeInteger sum = HugeInteger.add(num1, num2);
        System.out.println("sum: " + sum);

        HugeInteger difference = HugeInteger.subtract(num1, num2);
        System.out.println("difference: " + difference);

        System.out.println("isEqualTo: " + HugeInteger.isEqualTo(num1, num2));
        System.out.println("isNotEqualTo: " + HugeInteger.isNotEqualTo(num1, num2));
        System.out.println("isGreaterThan: " + HugeInteger.isGreaterThan(num1, num2));
        System.out.println("isLessThan: " + HugeInteger.isLessThan(num1, num2));
        System.out.println("isGreaterThanOrEqualTo: " + HugeInteger.isGreaterThanOrEqualTo(num1, num2));
        System.out.println("isLessThanOrEqualTo: " + HugeInteger.isLessThanOrEqualTo(num1, num2));
        System.out.println("isZero: " + HugeInteger.isZero(num1));
    }
}
