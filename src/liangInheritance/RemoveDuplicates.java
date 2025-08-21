package liangInheritance;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicates {
    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> tempList = new ArrayList<>();
        for (Integer num : list) {
            if (!tempList.contains(num)) {
                tempList.add(num);
            }
        }
        list.clear();
        list.addAll(tempList);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Enter ten integers: ");
        for (int i = 0; i < 10; i++) {
            list.add(scanner.nextInt());
        }
        removeDuplicate(list);
        System.out.print("The distinct integers are ");
        for (Integer num : list) {
            System.out.print(num + " ");
        }
    }
}
