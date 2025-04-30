package joyceUsingLoops;

import java.util.Scanner;

public class CountByAnything {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input number to count: ");
        int limit = input.nextInt();
        int startValue = 5;
        int endValue = 500;
        int count = 0;

        for (int i = startValue ; i <= endValue;  i +=limit){
            System.out.println(i + " ");
            count++;
            if (count % 10 ==0)
                System.out.println();
        }
        input.close();
    }
}
