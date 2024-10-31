package liang5;

    import java.util.Scanner;

    public class ReverseString {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter a string
            System.out.print("Enter a string: ");
            String inputString = scanner.nextLine();

            // Reverse the string
            String reversedString = reverse(inputString);

            // Display the reversed string
            System.out.println("Reversed string: " + reversedString);

            // Close the scanner
            scanner.close();
        }

        // Method to reverse a string
        public static String reverse(String str) {
            StringBuilder reversed = new StringBuilder();

            // Loop through the string from the end to the beginning
            for (int i = str.length() - 1; i >= 0; i--) {
                reversed.append(str.charAt(i));
            }

            return reversed.toString();
        }
    }


