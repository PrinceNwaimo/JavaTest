package conditionStatements;

import java.util.Scanner;

public class OneWayIf {
    public static void main(String[] args) {
        Scanner Input =new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int number = Input.nextInt();

        if(number % 5 == 0)
            System.out.println("HiFive");
        if (number % 2 == 0)
            System.out.println("HiEven");

    }
}
