package diettelGenericDataStructures;

import java.util.Arrays;

public class ArrayDuplicateElimination {
    public static int[] eliminateDuplicates(int[] array) {
        Arrays.sort(array);
        int writeIndex = 1;
        for (int readIndex = 1; readIndex < array.length; readIndex++) {
            if (array[readIndex] != array[readIndex - 1]) {
                array[writeIndex++] = array[readIndex];
            }
        }
        // Consider resizing or returning subarray up to writeIndex
        return Arrays.copyOfRange(array, 0, writeIndex);
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 4, 1, 3, 2, 5};
        int[] uniqueElements = eliminateDuplicates(array);
        System.out.println(Arrays.toString(uniqueElements)); // [1, 2, 3, 4, 5]
    }
}
