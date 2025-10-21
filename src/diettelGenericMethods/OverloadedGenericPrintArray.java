package diettelGenericMethods;
// Custom exception class
class InvalidSubscriptException extends Exception {
    public InvalidSubscriptException(String message) {
        super(message);
    }
}

public class OverloadedGenericPrintArray {

    // Generic method to print the entire array
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Overloaded generic method to print a subrange of the array
    public static <T> int printArray(T[] array, int lowSubscript, int highSubscript)
            throws InvalidSubscriptException {

        // Validate subscripts
        if (lowSubscript < 0 || highSubscript >= array.length || lowSubscript > highSubscript) {
            throw new InvalidSubscriptException(
                    "Invalid subscripts: must be within 0 and " + (array.length - 1)
            );
        }

        int count = 0;
        for (int i = lowSubscript; i <= highSubscript; i++) {
            System.out.print(array[i] + " ");
            count++;
        }
        System.out.println();
        return count;
    }

    // Main method to test both versions
    public static void main(String[] args) {
        Integer[] integerArray = {1, 2, 3, 4, 5, 6};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] characterArray = {'A', 'B', 'C', 'D', 'E'};

        System.out.println("=== Printing full arrays ===");
        System.out.print("Integer array: ");
        printArray(integerArray);
        System.out.print("Double array: ");
        printArray(doubleArray);
        System.out.print("Character array: ");
        printArray(characterArray);

        System.out.println("\n=== Printing array subranges ===");
        try {
            System.out.print("Integer array [1..4]: ");
            int count1 = printArray(integerArray, 1, 4);
            System.out.println("Elements printed: " + count1);

            System.out.print("Double array [0..2]: ");
            int count2 = printArray(doubleArray, 0, 2);
            System.out.println("Elements printed: " + count2);

            System.out.print("Character array [2..4]: ");
            int count3 = printArray(characterArray, 2, 4);
            System.out.println("Elements printed: " + count3);

            // Intentional invalid range to trigger exception
            System.out.print("\nAttempting invalid range [3..7] on Integer array:\n");
            printArray(integerArray, 3, 7);

        } catch (InvalidSubscriptException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
