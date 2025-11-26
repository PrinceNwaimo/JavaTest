package liangMultiThreading;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort2 {
    private static final int THRESHOLD = 1000;

    public static <E extends Comparable<E>> void parallelMergeSort(E[] list) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelMergeSortTask<>(list, 0, list.length - 1));
    }

    private static class ParallelMergeSortTask<E extends Comparable<E>> extends RecursiveAction {
        private E[] list;
        private int low;
        private int high;

        public ParallelMergeSortTask(E[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        protected void compute() {
            if (high - low < THRESHOLD) {
                insertionSort(list, low, high);
            } else {
                int mid = (low + high) / 2;
                ParallelMergeSortTask<E> leftTask = new ParallelMergeSortTask<>(list, low, mid);
                ParallelMergeSortTask<E> rightTask = new ParallelMergeSortTask<>(list, mid + 1, high);
                leftTask.fork();
                rightTask.compute();
                leftTask.join();
                merge(list, low, mid, high);
            }
        }
    }

    private static <E extends Comparable<E>> void insertionSort(E[] list, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            E key = list[i];
            int j = i - 1;
            while (j >= low && list[j].compareTo(key) > 0) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
    }

    private static <E extends Comparable<E>> void merge(E[] list, int low, int mid, int high) {
        E[] temp = (E[]) new Comparable[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (list[i].compareTo(list[j]) <= 0) {
                temp[k++] = list[i++];
            } else {
                temp[k++] = list[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = list[i++];
        }

        while (j <= high) {
            temp[k++] = list[j++];
        }

        System.arraycopy(temp, 0, list, low, temp.length);
    }

    public static void main(String[] args) {
        Integer[] list = {4, 2, 7, 1, 3, 9, 5, 6, 8};
        System.out.println("Before sorting:");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        parallelMergeSort(list);

        System.out.println("After sorting:");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
