package liangInheritance;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumElementInArrayList {
    public static Integer max(ArrayList<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter a sequence of numbers ending with 0:");
        while (true) {
            int number = input.nextInt();
            if (number == 0) {
                break;
            }
            list.add(number);
        }
        Integer max = max(list);
        if (max != null) {
            System.out.println("The largest number is: " + max);
        } else {
            System.out.println("The list is empty");
        }
    }
}
