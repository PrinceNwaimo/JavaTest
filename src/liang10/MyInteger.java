package liang10;

public class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        return isEven(value);
    }

    public boolean isOdd() {
        return isOdd(value);
    }

    public boolean isPrime() {
        return isPrime(value);
    }

    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    public static boolean isOdd(int value) {
        return value % 2 != 0;
    }

    public static boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEven(MyInteger myInteger) {
        return isEven(myInteger.getValue());
    }

    public static boolean isOdd(MyInteger myInteger) {
        return isOdd(myInteger.getValue());
    }

    public static boolean isPrime(MyInteger myInteger) {
        return isPrime(myInteger.getValue());
    }

    public boolean equals(int value) {
        return this.value == value;
    }

    public boolean equals(MyInteger myInteger) {
        return equals(myInteger.getValue());
    }

    public static int parseInt(char[] array) {
        return Integer.parseInt(new String(array));
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        MyInteger myInteger = new MyInteger(10);
        System.out.println("Value: " + myInteger.getValue());
        System.out.println("Is even? " + myInteger.isEven());
        System.out.println("Is odd? " + myInteger.isOdd());
        System.out.println("Is prime? " + myInteger.isPrime());

        System.out.println("Is 10 even? " + MyInteger.isEven(10));
        System.out.println("Is 11 odd? " + MyInteger.isOdd(11));
        System.out.println("Is 7 prime? " + MyInteger.isPrime(7));

        char[] array = {'1', '2', '3'};
        System.out.println("Parsed int value from array: " + MyInteger.parseInt(array));

        String str = "456";
        System.out.println("Parsed int value from string: " + MyInteger.parseInt(str));
    }
}
