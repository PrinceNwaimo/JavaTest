package liangMultiThreading;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelSum {
    private static final int THRESHOLD = 10000;

    public static double parallelSum(double[] list) {
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(new ParallelSumTask(list, 0, list.length - 1));
    }

    private static class ParallelSumTask extends RecursiveTask<Double> {
        private double[] list;
        private int low;
        private int high;

        public ParallelSumTask(double[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        protected Double compute() {
            if (high - low < THRESHOLD) {
                double sum = 0;
                for (int i = low; i <= high; i++) {
                    sum += list[i];
                }
                return sum;
            } else {
                int mid = (low + high) / 2;
                ParallelSumTask leftTask = new ParallelSumTask(list, low, mid);
                ParallelSumTask rightTask = new ParallelSumTask(list, mid + 1, high);
                leftTask.fork();
                double rightSum = rightTask.compute();
                double leftSum = leftTask.join();
                return leftSum + rightSum;
            }
        }
    }

    public static double sequentialSum(double[] list) {
        double sum = 0;
        for (double value : list) {
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {
        int size = 9000000;
        double[] list = new double[size];

        // Initialize list with random values
        for (int i = 0; i < size; i++) {
            list[i] = Math.random();
        }

        long startTime = System.currentTimeMillis();
        double sequentialResult = sequentialSum(list);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential sum: " + sequentialResult);
        System.out.println("Sequential time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        double parallelResult = parallelSum(list);
        endTime = System.currentTimeMillis();
        System.out.println("Parallel sum: " + parallelResult);
        System.out.println("Parallel time: " + (endTime - startTime) + "ms");
    }
}
