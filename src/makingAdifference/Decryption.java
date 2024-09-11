package makingAdifference;

import java.util.Scanner;

public class Decryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the encrypted four-digit integer:");
        int encrypted = scanner.nextInt();

        int digit1 = (encrypted / 1000 + 3) % 10;
        int digit2 = ((encrypted / 100) % 10 + 3) % 10;
        int digit3 = ((encrypted / 10) % 10 + 3) % 10;
        int digit4 = (encrypted % 10 + 3) % 10;

        int decrypted = digit1 * 1000 + digit2 * 100 + digit3 * 10 + digit4;

        System.out.println("Decrypted integer: " + decrypted);
    }
}
