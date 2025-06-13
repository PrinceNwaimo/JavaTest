package liangChapter6;

import java.util.Scanner;

public class FormatInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        System.out.print("Enter the width: ");
        int width = scanner.nextInt();
        scanner.close();

        System.out.println(format(number, width));
    }

    public static String format(int number, int width) {
        String numStr = Integer.toString(number);
        if (numStr.length() >= width) {
            return numStr;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < width - numStr.length(); i++) {
                sb.append('0');
            }
            sb.append(numStr);
            return sb.toString();
        }
    }

}
