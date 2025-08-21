package liangInheritance;

import java.util.ArrayList;
import java.util.Scanner;

public class SortArrayList {
    public static void sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            list.add(scanner.nextInt());
        }
        System.out.println("Before sorting: " + list);
        sort(list);
        System.out.println("After sorting: " + list);
    }
}
