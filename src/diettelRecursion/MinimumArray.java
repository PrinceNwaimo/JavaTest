package diettelRecursion;

public class MinimumArray {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 12, 3};
        int min = recursiveMinimum(array, array.length);
        System.out.println("Minimum value: " + min);
    }

    public static int recursiveMinimum(int[] array) {
        return recursiveMinimum(array, array.length);
    }

    private static int recursiveMinimum(int[] array, int size) {
        if (size == 1) {
            return array[0];
        }
        int minRest = recursiveMinimum(array, size - 1);
        return Math.min(array[size - 1], minRest);
    }
}
