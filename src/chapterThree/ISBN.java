package chapterThree;

import java.util.Scanner;

public class ISBN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as an integer: ");
        int d1 = input.nextInt();
        int d2 = input.nextInt();
        int d3 = input.nextInt();
        int d4 = input.nextInt();
        int d5 = input.nextInt();
        int d6 = input.nextInt();
        int d7 = input.nextInt();
        int d8 = input.nextInt();
        int d9 = input.nextInt();

        int d10 = (d1 * 1+d2 * 2+d3 * 3+d4 * 4+d5 * 5+d6 *6+ d7 * 7+d8 * 8+d9 * 9) %11;
        System.out.print("The ISBN-10 number is ");
        System.out.print(d1);
        System.out.print(d2);
        System.out.print(d3);
        System.out.print(d4);
        System.out.print(d5);
        System.out.print(d6);
        System.out.print(d7);
        System.out.print(d8);
        System.out.print(d9);
        if (d10 == 10) {
            System.out.println("X");
        } else {
            System.out.println(d10);
        }

    }
    }

