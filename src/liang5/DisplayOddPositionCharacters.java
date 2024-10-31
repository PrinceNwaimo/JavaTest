package liang5;

    import java.util.Scanner;

    public class DisplayOddPositionCharacters {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter a string
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // Display characters at odd positions
            System.out.print("Characters at odd positions: ");
            for (int i = 0; i < input.length(); i++) {
                // Check if the index is odd (considering 0-based index, so check for even index)
                if (i % 2 == 0) {
                    System.out.print(input.charAt(i));
                }
            }

            // Close the scanner
            scanner.close();
        }
    }


