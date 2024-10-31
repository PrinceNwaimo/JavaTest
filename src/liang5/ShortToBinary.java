package liang5;

    import java.util.Scanner;

    public class ShortToBinary {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter a short integer
            System.out.print("Enter a short integer (between -32768 and 32767): ");
            short input = scanner.nextShort();

            // Convert the short integer to its binary representation
            String binaryString = String.format("%16s", Integer.toBinaryString(input & 0xFFFF)).replace(' ', '0');

            // Display the binary representation
            System.out.println("The binary representation of " + input + " is: " + binaryString);

            // Close the scanner
            scanner.close();
        }
    }


