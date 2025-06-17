package diettel6;

import java.util.Scanner;

public class DivisibleBy5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++);
            System.out.print("Enter an integer: ");
            int num = scanner.nextInt();
            if (isDivisibleBy5(num)) {
                System.out.println(num + " is divisible by 5");
            } else {
                System.out.println(num + " is not divisible by 5");
            }

        scanner.close();
    }

    public static boolean isDivisibleBy5(int num) {
        return num % 5 == 0;
    }

}
