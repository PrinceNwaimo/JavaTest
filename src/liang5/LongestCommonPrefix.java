package liang5;


    import java.util.Scanner;

    public class LongestCommonPrefix {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter two strings
            System.out.print("Enter the first string: ");
            String str1 = scanner.nextLine();
            System.out.print("Enter the second string: ");
            String str2 = scanner.nextLine();

            // Find the longest common prefix
            String commonPrefix = findLongestCommonPrefix(str1, str2);

            // Display the result
            if (commonPrefix.isEmpty()) {
                System.out.println("There is no common prefix.");
            } else {
                System.out.println("The longest common prefix is: " + commonPrefix);
            }

            // Close the scanner
            scanner.close();
        }

        private static String findLongestCommonPrefix(String str1, String str2) {
            StringBuilder prefix = new StringBuilder();
            int minLength = Math.min(str1.length(), str2.length());

            // Compare characters of both strings
            for (int i = 0; i < minLength; i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    prefix.append(str1.charAt(i));
                } else {
                    break; // Stop on the first mismatch
                }
            }

            return prefix.toString();
        }
    }


