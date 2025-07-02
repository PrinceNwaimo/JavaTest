package liangArrays;

import java.util.Scanner;

public class ChineseZodiac {
    public static void main(String[] args) {
        String[] zodiac = {"monkey", "rooster", "dog", "pig", "rat", "ox", "tiger", "rabbit", "dragon", "snake", "horse", "sheep"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        int index = (year - 4) % 12;
        System.out.println(zodiac[index]);
    }

}
