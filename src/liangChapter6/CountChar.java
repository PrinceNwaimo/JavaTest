package liangChapter6;

import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("Enter a character: ");
        char c = scanner.next().charAt(0);
        scanner.close();

        System.out.println("The character '" + c + "' occurs " + count(str, c) + " times in the string.");
    }

    public static int count(String str, char a) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == a) {
                count++;
            }
        }
        return count;
    }

}
