package liangSortingAlgorithms;

public class MergeSort2 {

    public static void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(array, temp, low, mid);
            mergeSort(array, temp, mid + 1, high);
            merge(array, temp, low, mid, high);
        }
    }

    private static void merge(int[] array, int[] temp, int low, int mid, int high) {
        System.arraycopy(array, low, temp, low, high - low + 1);
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            array[k] = temp[i];
            i++;
            k++;
        }
    }
}