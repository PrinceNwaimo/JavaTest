package diettelGenericMethods;
public class OverloadGenericWithNonGeneric {

    // Generic version of printArray (Fig. 20.3 style)
    public static <T> void printArray(T[] inputArray) {
        for (T element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    // Nongeneric overloaded version that specifically handles String arrays
    public static void printArray(String[] inputArray) {
        System.out.println("Array stringArray contains:");

        // Print 4 strings per line, tab-separated neatly
        for (int i = 0; i < inputArray.length; i++) {
            System.out.printf("%-8s", inputArray[i]); // Left-aligned in 8 spaces
            if ((i + 1) % 4 == 0) {
                System.out.println(); // New line after every 4 elements
            }
        }
        System.out.println(); // Final line break
    }

    // Main method to demonstrate overloading
    public static void main(String[] args) {
        Integer[] integerArray = {1, 2, 3, 4, 5, 6};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] characterArray = {'A', 'B', 'C', 'D', 'E'};
        String[] stringArray = {"one", "two", "five", "six", "three", "seven", "four", "eight"};

        System.out.println("Array integerArray contains:");
        printArray(integerArray); // Generic method

        System.out.println("\nArray doubleArray contains:");
        printArray(doubleArray); // Generic method

        System.out.println("\nArray characterArray contains:");
        printArray(characterArray); // Generic method

        System.out.println();
        printArray(stringArray); // Nongeneric method (special formatting)
    }
}

