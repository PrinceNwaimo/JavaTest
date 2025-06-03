package characterAndStrings;

import java.util.Scanner;

public class ThreeLetterAcronym {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three words:");
        String[] words = scanner.nextLine().split("\\s+");

        String acronym = "";
        for (int i = 0; i < Math.min(words.length, 3); i++) {
            acronym += words[i].toUpperCase().charAt(0);
        }

        System.out.println("The three-letter acronym is: " + acronym);

        scanner.close();
    }

}
