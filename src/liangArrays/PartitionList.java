package liangArrays;

import java.util.Scanner;

public class PartitionList {
    public static int partition(int[] list) {
        int pivot = list[0];
        int low = 1;
        int high = list.length - 1;

        while (true) {
            while (low <= high && list[low] <= pivot) {
                low++;
            }

            while (low <= high && list[high] > pivot) {
                high--;
            }

            if (low > high) {
                break;
            }

            int temp = list[low];
            list[low] = list[high];
            list[high] = temp;
        }

        int temp = list[0];
        list[0] = list[high];
        list[high] = temp;

        return high;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter list: ");
        int n = scanner.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }

        int pivotIndex = partition(list);
        System.out.print("After the partition, the list is ");
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Pivot index: " + pivotIndex);
    }

}
