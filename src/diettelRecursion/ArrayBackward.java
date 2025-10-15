package diettelRecursion;

public class ArrayBackward {
    public static void main(String[] args) {
        char[] array = {'H', 'e', 'l', 'l', 'o'};
        stringReverse(array, array.length - 1);
    }

    public static void stringReverse(char[] array) {
        stringReverse(array, array.length - 1);
    }

    private static void stringReverse(char[] array, int index) {
        if (index < 0) {
            return;
        }
        System.out.print(array[index]);
        stringReverse(array, index - 1);
    }
}
