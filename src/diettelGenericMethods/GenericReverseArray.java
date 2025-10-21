package diettelGenericMethods;

public class GenericReverseArray {
        // Generic method to reverse an array
        public static <T> void reverseArray(T[] array) {
            int left = 0;
            int right = array.length - 1;
            while (left < right) {
                T temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }

        // Generic method to print an array
        public static <T> void printArray(T[] array) {
            for (T element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        // Main method to test reverseArray with different types
        public static void main(String[] args) {
            // Integer array
            Integer[] intArray = {1, 2, 3, 4, 5};
            System.out.println("Original Integer array:");
            printArray(intArray);
            reverseArray(intArray);
            System.out.println("Reversed Integer array:");
            printArray(intArray);
            System.out.println();

            // Double array
            Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
            System.out.println("Original Double array:");
            printArray(doubleArray);
            reverseArray(doubleArray);
            System.out.println("Reversed Double array:");
            printArray(doubleArray);
            System.out.println();

            // Character array
            Character[] charArray = {'A', 'B', 'C', 'D'};
            System.out.println("Original Character array:");
            printArray(charArray);
            reverseArray(charArray);
            System.out.println("Reversed Character array:");
            printArray(charArray);
            System.out.println();

            // String array
            String[] stringArray = {"Java", "Python", "C++", "Go"};
            System.out.println("Original String array:");
            printArray(stringArray);
            reverseArray(stringArray);
            System.out.println("Reversed String array:");
            printArray(stringArray);
        }
    }


