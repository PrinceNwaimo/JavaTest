package diettel6;

import java.util.Scanner;

public class StringBeautifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();

        String beautifiedString = beautifyString(str);
        System.out.println("Beautified string: " + beautifiedString);
    }

    public static String beautifyString(String str) {
        str = ensureFullStop(str);
        str = capitalizeFirstLetter(str);
        return str;
    }

    public static String ensureFullStop(String str) {
        if (!str.endsWith(".")) {
            str += ".";
        }
        return str;
    }

    public static String capitalizeFirstLetter(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
