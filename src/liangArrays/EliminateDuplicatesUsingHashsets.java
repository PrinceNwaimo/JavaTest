package liangArrays;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class EliminateDuplicatesUsingHashsets {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int[] numbers = new int[5];
        System.out.println("Enter 5 numbers: ");
        numbers = new int[]{input.nextInt()};
        eliminateDuplicates(numbers);
    }

        public static int[] eliminateDuplicates(int[] list) {
            Set<Integer> set = new LinkedHashSet<>();
            for (int num : list) {
                set.add(num);
            }
            int[] result = new int[set.size()];
            int i = 0;
            for (Integer num : set) {
                result[i++] = num;
            }
            return result;
        }


}
