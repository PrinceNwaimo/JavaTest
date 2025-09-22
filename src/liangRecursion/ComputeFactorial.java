package liangRecursion;

import java.util.Scanner;

public class ComputeFactorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int number = input.nextInt();
        System.out.println("factorial of " + number + " is " + factorial(number));

    }
    public static long factorial(int num){
        if (num == 0)
            return 1;
        else
            return num * factorial(num -1 );
    }
}
