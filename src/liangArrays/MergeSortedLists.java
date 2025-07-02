package liangArrays;

import java.util.Scanner;

public class MergeSortedLists {
    public static int[] merge(int[] list1, int[] list2) {
        int[] result = new int[list1.length + list2.length];
        int i = 0, j = 0, k = 0;

        while (i < list1.length && j < list2.length) {
            if (list1[i] < list2[j]) {
                result[k++] = list1[i++];
            } else {
                result[k++] = list2[j++];
            }
        }

        while (i < list1.length) {
            result[k++] = list1[i++];
        }

        while (j < list2.length) {
            result[k++] = list2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter list1: ");
        int n1 = scanner.nextInt();
        int[] list1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            list1[i] = scanner.nextInt();
        }

        System.out.print("Enter list2: ");
        int n2 = scanner.nextInt();
        int[] list2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            list2[i] = scanner.nextInt();
        }

        int[] mergedList = merge(list1, list2);
        System.out.print("The merged list is ");
        for (int num : mergedList) {
            System.out.print(num + " ");
        }
    }

}
