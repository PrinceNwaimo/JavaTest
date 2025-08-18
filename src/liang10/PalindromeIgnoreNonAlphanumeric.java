package liang10;

import java.util.Scanner;

public class PalindromeIgnoreNonAlphanumeric {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String say = input.nextLine();
        System.out.println("Ignoring nonalphanumeric characters, \nis " + say + " a palindrome? " + isPalindrome(say));
    }
    public static boolean isPalindrome(String sue){
        String sue1 = filter(sue);
        String sue2 = reverse(sue1);
        return sue2.equals(sue1);
    }
    public static String filter(String sue) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < sue.length(); i++)
            if (Character.isLetterOrDigit(sue.charAt(i))) {
                stringBuilder.append(sue.charAt(i));
            }
        return stringBuilder.toString();
    }
    public static String reverse(String sue){
        StringBuilder stringBuilder = new StringBuilder(sue);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

}

