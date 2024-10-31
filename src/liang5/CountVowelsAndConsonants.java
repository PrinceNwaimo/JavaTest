package liang5;


    import java.util.Scanner;

    public class CountVowelsAndConsonants {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter a string
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // Initialize counters for vowels and consonants
            int vowelCount = 0;
            int consonantCount = 0;

            // Convert the string to lowercase to make the checking case-insensitive
            String lowerCaseInput = input.toLowerCase();

            // Iterate through each character in the string
            for (char ch : lowerCaseInput.toCharArray()) {
                // Check if the character is a letter
                if (Character.isLetter(ch)) {
                    // Check if the character is a vowel
                    if ("aeiou".indexOf(ch) != -1) {
                        vowelCount++;
                    } else {
                        // If it's not a vowel, it's a consonant
                        consonantCount++;
                    }
                }
            }

            // Display the results
            System.out.println("Number of vowels: " + vowelCount);
            System.out.println("Number of consonants: " + consonantCount);

            // Close the scanner
            scanner.close();
        }
    }


