package diettel6;

import java.util.Scanner;

public class FloorAndCeil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a double value: ");
        double num = scanner.nextDouble();
        scanner.close();

        System.out.println("myFloor(" + num + ") = " + myFloor(num));
        System.out.println("myCeil(" + num + ") = " + myCeil(num));
    }

    public static int myFloor(double num) {
        int integerPart = (int) num;
        if (num < 0 && num != integerPart) {
            integerPart--;
        }
        return integerPart;
    }

    public static int myCeil(double num) {
        int integerPart = (int) num;
        if (num > integerPart) {
            integerPart++;
        }
        return integerPart;
    }

}
