package liangArrays;

import java.util.Scanner;

public class ProcessingArrays {
    public static void main(String[] args) {
        double[] myList = new double[10];

        Scanner input = new Scanner(System.in);
        System.out.println("Enter "+ myList.length + " values: ");
        for (int i = 0; i < myList.length; i++) {
            myList[i] = input.nextDouble();
        }
        double max = myList[0];
        int indexOfMax = 0;
        for (int i = 1; i < myList.length; i++) {
            if(myList[i] > max) max = myList[i];
            indexOfMax = i;
        }
        System.out.println("The maximum value is " + max);
        System.out.println("The smallest index of the element is " + indexOfMax);
        }

    }



