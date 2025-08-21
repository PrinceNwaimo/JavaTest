package liangInheritance;

import java.util.ArrayList;
import java.util.Scanner;

public class SumArrayList {
    public static double sum(ArrayList<Double> list) {
        return list.stream().mapToDouble(Double::doubleValue).sum();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            list.add(scanner.nextDouble());
        }
        System.out.println("The sum is: " + sum(list));
    }
}
