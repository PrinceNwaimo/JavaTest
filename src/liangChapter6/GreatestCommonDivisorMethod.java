package liangChapter6;

import java.util.Scanner;

public class GreatestCommonDivisorMethod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int n1 = input.nextInt();
        System.out.print("Enter second integer: ");
        int n2 = input.nextInt();
        System.out.println("The greatest common divisor for "+ n1 +" and "+ n2 + " is "+ gcd(n1,n2));
    }
    public static int gcd(int n1, int n2){
        int gcd = 1;
        int possibleGCD = 2;

        while (possibleGCD <= n1 && possibleGCD <= n2){
            if (n1 % possibleGCD == 0 && n2 % possibleGCD == 0)
                gcd = possibleGCD;
            possibleGCD++;
        }
        return gcd;
    }
}
