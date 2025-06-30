package liangArrays;

import java.util.Scanner;

public class RandomShuffling {
    public static void main(String[] args) {
        double[] myList = new double[10];

        Scanner input = new Scanner(System.in);
        System.out.println("Enter " + myList.length + " values: ");
        for (int i = 0; i < myList.length; i++) {
            myList[i] = input.nextDouble();
        }
        for (int i = myList.length - 1; i > 0 ; i--) {
            int j = (int)(Math.random() * (i + 1));

            double temp = myList[i];
            myList[i] = myList[j];
            myList[j] = temp;
            System.out.println(temp);
        }

    }
}