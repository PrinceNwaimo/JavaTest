package joyceTwoDimensionalArrays;

import java.util.Arrays;

public class StringSort {
    public static void main(String[] args) {
        String[] strings = {"Orange", "Apple", "Banana", "Grapes", "Mango", "Pineapple", "Watermelon", "Peach", "Cherry", "Plum", "Kiwi", "Blueberry", "Raspberry", "Strawberry", "Lemon"};

        Arrays.sort(strings);

        System.out.println("Sorted Strings:");
        for (String str : strings) {
            System.out.println(str);
        }
    }

}
