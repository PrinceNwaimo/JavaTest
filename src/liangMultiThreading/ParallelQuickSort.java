package liangMultiThreading;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelQuickSort {
    private static final int THRESHOLD = 1000;

    public static void parallelQuickSort(int[] list) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelQuickSortTask(list, 0, list.length - 1));
    }

    private static class ParallelQuickSortTask extends RecursiveAction {
        private int[] list;
        private int low;
        private int high;

        public ParallelQuickSortTask(int[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        protected void compute() {
            if (high - low < THRESHOLD) {
                insertionSort(list, low, high);
            } else {
                int pivotIndex = partition(list, low, high);
                ParallelQuickSortTask leftTask = new ParallelQuickSortTask(list, low, pivotIndex - 1);
                ParallelQuickSortTask rightTask = new ParallelQuickSortTask(list, pivotIndex + 1, high);
                leftTask.fork();
                rightTask.compute();
                leftTask.join();
            }
        }
    }

    private static int partition(int[] list, int low, int high) {
        int pivot = list[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list[j] < pivot) {
                i++;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        int temp = list[i + 1];
        list[i + 1] = list[high];
        list[high] = temp;
        return i + 1;
    }

    private static void insertionSort(int[] list, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = list[i];
            int j = i - 1;
            while (j >= low && list[j] > key) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
    }

    public static void sequentialQuickSort(int[] list) {
        sequentialQuickSort(list, 0, list.length - 1);
    }

    private static void sequentialQuickSort(int[] list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            sequentialQuickSort(list, low, pivotIndex - 1);
            sequentialQuickSort(list, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int size = 9000000;
        int[] list1 = new int[size];
        int[] list2 = new int[size];

        // Initialize lists with random values
        for (int i = 0; i < size; i++) {
            list1[i] = (int) (Math.random() * size);
            list2[i] = list1[i];
        }

        long startTime = System.currentTimeMillis();
        sequentialQuickSort(list1);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        parallelQuickSort(list2);
        endTime = System.currentTimeMillis();
        System.out.println("Parallel time: " + (endTime - startTime) + "ms");
    }
}
