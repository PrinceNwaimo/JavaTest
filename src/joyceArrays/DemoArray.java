package joyceArrays;

import java.util.Arrays;

public class DemoArray {
    public static void main(String[] args) {
        double [] salaries = new double[4];
        salaries[0] = 12.25;
        salaries[1] = 13.55;
        salaries[2] = 14.25;
        salaries[3] = 16.85;

        System.out.println("Salaries one by one are:");
        System.out.println(salaries[0]);
        System.out.println(salaries[1]);
        System.out.println(salaries[2]);
        System.out.println(salaries[3]);

        array2();
    }
    public static void array2(){
        double [] salaries = {12.25, 13.55, 14.25, 16.85};

        for (int x = 0; x < salaries.length; ++x) {
            System.out.println(salaries[x]);

        }

    }
}
