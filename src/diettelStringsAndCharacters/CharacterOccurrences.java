package diettelStringsAndCharacters;

import java.util.Scanner;

public class CharacterOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String text = scanner.nextLine().toLowerCase();
        System.out.print("Enter a search character: ");
        char searchChar = scanner.next().toLowerCase().charAt(0);
        scanner.close();

        int count = 0;
        int index = text.indexOf(searchChar);

        while (index != -1) {
            count++;
            index = text.indexOf(searchChar, index + 1);
        }

        System.out.println("The character '" + searchChar + "' occurs " + count + " times.");
    }
}
