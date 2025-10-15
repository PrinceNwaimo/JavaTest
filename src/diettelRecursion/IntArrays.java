package diettelRecursion;

public class IntArrays {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int result = searchArray(array, target, 0);
        System.out.println("Element " + target + " found at index: " + result);
    }

    public static int searchArray(int[] array, int target) {
        return searchArray(array, target, 0);
    }

    private static int searchArray(int[] array, int target, int index) {
        if (index >= array.length) {
            return -1; // Element not found
        }
        if (array[index] == target) {
            return index; // Element found
        }
        return searchArray(array, target, index + 1);
    }
}
