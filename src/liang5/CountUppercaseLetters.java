package liang5;

    import java.util.Scanner;

    public class CountUppercaseLetters {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter a string
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // Initialize counter for uppercase letters
            int uppercaseCount = 0;

            // Iterate through each character in the string
            for (char ch : input.toCharArray()) {
                // Check if the character is an uppercase letter
                if (Character.isUpperCase(ch)) {
                    uppercaseCount++;
                }
            }

            // Display the result
            System.out.println("Number of uppercase letters: " + uppercaseCount);

            // Close the scanner
            scanner.close();
        }
    }


