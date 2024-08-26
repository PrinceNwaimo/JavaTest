package mathsClasses;

import java.util.Scanner;

public class FindUnicode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char ch = scanner.next().charAt(0);

        int unicode = ch;
        System.out.println("The Unicode of '" + ch + "' is: " + unicode);
    }

}
